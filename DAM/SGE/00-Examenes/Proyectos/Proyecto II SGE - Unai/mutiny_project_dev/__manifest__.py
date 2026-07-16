# mutiny_project_dev/__manifest__.py
{
    'name': 'Mutiny - Gestión de Proyectos de Desarrollo',
    'version': '1.0',
    'summary': 'Gestión interna de proyectos de software en Mutiny',
    'description': """
        Módulo para gestionar proyectos de desarrollo de software:
        - Asignación de desarrolladores
        - Seguimiento de estado y progreso
        - Integración con clientes y empleados
    """,
    'author': 'Tu Nombre',
    'category': 'Services',
    'depends': ['base', 'hr', 'mail'],
    'data': [
        'security/ir.model.access.csv',
        'views/views.xml',
    ],
    'installable': True,
    'application': True,
    'auto_install': False,
}