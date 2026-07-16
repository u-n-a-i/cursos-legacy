# mutiny_project_dev/models/dev_project.py
from odoo import models, fields, api, _
from odoo.exceptions import ValidationError

class MutinyDevProject(models.Model):
    _name = 'mutiny.dev.project'
    _description = 'Proyecto de Desarrollo en Mutiny'
    _inherit = ['mail.thread', 'mail.activity.mixin']

    name = fields.Char(string='Nombre del Proyecto', required=True)
    reference_code = fields.Char(
        string='Código',
        readonly=True,
        copy=False,  # no se copia al duplicar
        help="Código generado automáticamente al guardar"
    )
    
    client_id = fields.Many2one('res.partner', string='Cliente', domain=[('customer_rank', '>', 0)])
    assigned_developer_id = fields.Many2one('hr.employee', string='Desarrollador Asignado')
    
    start_date = fields.Date(string='Fecha de Inicio')
    end_date = fields.Date(string='Fecha Estimada de Entrega')
    
    status = fields.Selection([
        ('planned', 'Planeado'),
        ('in_progress', 'En Desarrollo'),
        ('testing', 'En Pruebas'),
        ('done', 'Entregado')
    ], string='Estado', default='planned', required=True)
    
    complexity = fields.Selection([
        ('low', 'Baja'),
        ('medium', 'Media'),
        ('high', 'Alta')
    ], string='Complejidad')
    
    estimated_hours = fields.Float(string='Horas Estimadas')
    actual_hours = fields.Float(string='Horas Reales')
    
    progress_percentage = fields.Float(
        string='Progreso (%)',
        compute='_compute_progress_percentage',
        store=True
    )

    # ----- Progreso (esto SÍ puede depender de estimated/actual) -----
    @api.depends('estimated_hours', 'actual_hours')
    def _compute_progress_percentage(self):
        for record in self:
            if record.estimated_hours > 0:
                record.progress_percentage = min(100.0, 100.0 * record.actual_hours / record.estimated_hours)
            else:
                record.progress_percentage = 0.0

    # ----- Validación de fechas -----
    @api.constrains('start_date', 'end_date')
    def _check_dates(self):
        for record in self:
            if record.start_date and record.end_date and record.start_date > record.end_date:
                raise ValidationError(_("La fecha de inicio no puede ser posterior a la de entrega."))

    # Sobrescribir create() para generar el código al guardar por primera vez
    @api.model_create_multi
    def create(self, vals_list):
        records = super().create(vals_list)
        for record in records:
            if not record.reference_code:
                # El ID ya está asignado tras create(), así que es seguro usarlo
                record.reference_code = f"PROJ-{record.id:04d}"
        return records

    # ----- Botón: Iniciar Desarrollo -----
    def action_start_development(self):
        for record in self:
            if not record.assigned_developer_id:
                raise ValidationError(_("Tienes que asignar un desarrollador antes de iniciar el desarrollo."))
            if not record.start_date:
                record.start_date = fields.Date.today()
            record.status = 'in_progress'
            record.message_post(
                body=_("Desarrollo iniciado por %s.") % record.env.user.name,
                message_type='notification'
            )

    # ----- Botón: Pasar a En Pruebas -----
    def action_start_testing(self):
        for record in self:
            if record.status != 'in_progress':
                raise ValidationError(_("Solo se puede pasar a pruebas si el proyecto está en desarrollo."))
            record.status = 'testing'
            record.message_post(
                body=_("Proyecto movido a En Pruebas por %s.") % record.env.user.name,
                message_type='notification'
            )

    # ----- Botón: Marcar como Entregado -----
    def action_mark_done(self):
        for record in self:
            if record.status != 'testing':
                raise ValidationError(_("Solo se puede entregar un proyecto que está en pruebas."))
            record.status = 'done'
            record.message_post(
                body=_("Proyecto marcado como Entregado por %s.") % record.env.user.name,
                message_type='notification'
            )