# Guía Paso a Paso: Bloque 1 – Menús y Vistas en Odoo 18

> ✅ Requisitos previos:
>
> - Tener acceso como **Administrador**.
> - **Activar el modo desarrollador**:  
>   `Perfil → Acerca de Odoo → Activar el modo desarrollador`.

---

## 📌 Ejercicio 1: Crear nuevo menú “Mis Reportes”

### Pasos:

1. Ve a **Ajustes → Técnico → Interfaz de usuario → Menús**.
2. Haz clic en **Crear**.
3. Rellena:
   - **Nombre del menú**: `Mis Reportes`
   - **Secuencia**: `100` (valor arbitrario; asegura posición visible)
   - **Padre**: _dejar vacío_ (menú de primer nivel)
   - **Acción**: _dejar vacío_ (solo es contenedor por ahora)
4. Guarda.

✅ **Verificación**: Recarga la interfaz. El menú debe aparecer en la barra lateral izquierda.

---

## 📌 Ejercicio 2: Submenú “Clientes” bajo “Mis Reportes”

### Pasos:

1. En **Menús**, crea otro registro:
   - **Nombre**: `Clientes`
   - **Padre**: selecciona `Mis Reportes`
   - **Acción**: busca y selecciona la acción tipo _Ventana_ para el modelo `res.partner`.
     > 🔍 Nombre común: `base.action_partner_form` o simplemente escribe _“Clientes”_ en el buscador del campo _Acción_.
2. Guarda.

✅ **Verificación**: Expande _Mis Reportes_ → haz clic en _Clientes_. Debe abrir la lista de contactos/clientes.

---

## 📌 Ejercicio 3: Menú “Habilidades Empleados” al final del menú principal

### Pasos:

1. Crea un nuevo menú:
   - **Nombre**: `Habilidades Empleados`
   - **Padre**: _vacío_
   - **Secuencia**: `999` (máximo valor para que quede al final)
   - **Acción**:
     - Modelo: `hr.employee.skill`
     - Busca la acción `hr_skills.open_view_employee_skill_tree` (tipo _Ventana_).
     - Si no existe, créala:
       - Ve a **Ajustes → Técnico → Acciones → Ventanas**
       - Nombre: `Habilidades de Empleados`
       - Modelo objetivo: `hr.employee.skill`
       - Vista tipo: `Árbol`
       - Dominio: `[]`
2. Asigna esa acción al menú.

✅ **Verificación**: El menú aparece al final en la barra lateral. Al abrirlo, se muestran las habilidades asignadas a empleados.

> ⚠️ Asegúrate de tener instalado el módulo **`hr_skills`**.

---

## 📌 Ejercicio 4: Mover “Habilidades Empleados” dentro de _Empleados_, después de _Organigrama_

### Pasos:

1. Edita el menú `Habilidades Empleados`.
2. Cambia:
   - **Padre**: `Empleados` (busca `hr.menu_hr_root`)
   - **Secuencia**:
     - Busca el menú _Organigrama_ (`hr.menu_hr_organigram`) → anota su secuencia (ej. `20`).
     - Ponle a tu menú: `21`.

✅ **Verificación**: En el menú _Empleados_, _Organigrama_ aparece antes que _Habilidades Empleados_.

---

## 📌 Ejercicio 5: Submenú “Currículum Empleado” (reporte PDF)

### Pasos:

1. Crea menú:
   - **Nombre**: `Currículum Empleado`
   - **Padre**: `Habilidades Empleados`
   - **Acción**: busca y selecciona el reporte:  
     `hr_skills.report_employee_cv` (tipo: **Reporte**)
2. Guarda.

✅ **Verificación**:

- Antes: asegúrate de que al menos un empleado tenga habilidades asignadas (en formulario de empleado → pestaña _Habilidades_).
- Al hacer clic en el menú:
  - Si no abre nada: es normal → el reporte espera `active_ids`.
  - Alternativa: abre un empleado → ⋯ (más) → **Imprimir → Currículum Empleado**.
  - Debe generar un PDF con foto, datos personales y habilidades.

> 📝 Nota: El menú _global_ no es ideal para este reporte; funciona mejor como acción contextual.

---

6. Modificar la vista de lista de un modelo
   Objetivo: Personalizar la lista de registros.
   Pasos:

- Ve a Empleados → cambia a la vista Lista.
- Activa el modo desarrollador (si no lo está).
- Haz clic en el icono de engranaje (⚙️) → "Editar lista".
- En el editor XML, dentro de la etiqueta <tree>, añade los campos que quieras mostrar como columnas. Ejemplo:
  <field name="department_id"/>
  <field name="job_title"/>
  <field name="work_email"/>
- Haz clic en "Guardar".
  Verificación:
- La vista de lista ahora muestra las nuevas columnas.
- Prueba con otro modelo (ej. Productos): ve a Productos → Lista → ⚙️ → Editar lista → añade <field name="categ_id"/> y <field name="list_price"/>.
- Guarda y confirma que los cambios se ven reflejados.

7. Modificar la vista de formulario de un modelo
   Objetivo: Personalizar la disposición de campos.
   Pasos:

- Abre cualquier registro de Empleado (formulario).
- ⚙️ → "Editar formulario".
- En el editor XML, modifica la estructura:
  • Puedes mover campos entre grupos.
  • Añadir una nueva sección con:
  <group string="Información adicional">
  <field name="department_id"/>
  <field name="job_title"/>
  </group>
  • Si quieres mostrar habilidades directamente (y tienes hr_skills instalado), añade:
  <separator string="Habilidades"/>
  <field name="employee_skill_ids" widget="many2many_tags"/>
- Guarda los cambios.
  Verificación:
- El formulario ahora tiene el nuevo diseño.
- Los campos aparecen donde los colocaste.
- Si añadiste employee_skill_ids, verás las habilidades del empleado como etiquetas.

8. Crear un menú que abra una vista kanban
   Objetivo: Mostrar pedidos confirmados en Kanban, agrupados por vendedor.
   Pasos:
   a) Crea una acción de ventana:
   - Ve a Ajustes → Técnico → Acciones → Ventanas → Crear.
   - Nombre: Pedidos Confirmados
   - Modelo objetivo: sale.order
   - Dominio: [('state', '=', 'sale')] (en Odoo 18, "Confirmado" = estado 'sale')
   - Vista tipo: Kanban (marca la casilla)
   - Vista kanban: déjala vacía para usar la predeterminada.
   - Contexto (opcional, para agrupación sugerida): {"default_group_by": "user_id"}
   - Guarda.

b) Crea el menú:

- Ve a Menús → Crear.
- Nombre: Pedidos Confirmados
- Padre: Ventas (o vacío para menú raíz)
- Acción: selecciona la acción creada.
- Guarda.

Verificación:

- Al abrir el menú, se carga la vista Kanban.
- Haz clic en "Agrupar por" → selecciona "Vendedor".
- Los pedidos deben aparecer agrupados por vendedor (usuarios del equipo de ventas).
- Si ya lo hiciste antes, Odoo recordará la agrupación.

9. Crear un menú que abra un árbol con agrupación
   Objetivo: Lista de empleados agrupada por departamento.
   Pasos:
   a) Ve a Empleados → Vista Lista.
   b) Haz clic en el buscador → "Agrupar por" → selecciona "Departamento".
   c) Guarda el filtro:
   - Haz clic en el icono del disquete (💾) junto al buscador.
   - Nombre del filtro: Por Departamento
   - Marca "Disponible para todos los usuarios" (opcional).
   - Guarda.

d) Crea una acción de ventana:

- Nombre: Empleados por Departamento
- Modelo: hr.employee
- Dominio: [] (todos los empleados)
- Contexto: {"search_default_por_departamento": 1}
  → Este nombre debe coincidir con el del filtro guardado (en minúsculas y guiones bajos).

e) Crea el menú:

- Nombre: Empleados por Departamento
- Padre: Empleados (o Mis Reportes)
- Acción: la recién creada.
- Guarda.

Verificación:

- Al abrir el menú, la lista aparece automáticamente agrupada por departamento.
- Cada grupo muestra el número de empleados y sus nombres.

10. Crear un menú que abra un reporte PDF con selección de registro
    Objetivo: Imprimir el currículum de un empleado con sus habilidades.
    ⚠️ Importante: Este reporte requiere tener al menos un empleado con habilidades asignadas.

Pasos previos:

- Asegúrate de que esté instalado el módulo hr_skills.
- Ve a Empleados → abre un empleado → pestaña "Habilidades" → añade al menos una habilidad (ej. Python, nivel Avanzado).
- Guarda el empleado.

Ejecución del reporte:
a) Ve a Empleados → Lista.
b) Selecciona un empleado (marca la casilla a la izquierda).
c) Haz clic en los tres puntos (⋯) → "Imprimir" → "Currículum Empleado".
d) Se generará un PDF. Ábrelo y verifica que:

- Muestra foto, nombre, puesto, departamento.
- Incluye una sección "Habilidades" con nombre y nivel.

Alternativa mediante menú (solo si insistes):

- Crea un menú llamado "Imprimir Currículum Empleado".
- Acción: hr_skills.report_employee_cv (tipo Reporte).
- ⚠️ Pero: al hacer clic, si no hay contexto (active_ids), no generará nada. Por eso se recomienda usarlo desde selección o desde formulario.

Verificación final:

- El PDF generado debe ser legible y contener los datos del empleado + habilidades.
- Si no incluye habilidades, revisa que el empleado tenga registros en employee_skill_ids.

Nota: Este ejercicio confirma que el reporte QWeb está funcionando y que los datos relacionados (skills) se inyectan correctamente en el template.
