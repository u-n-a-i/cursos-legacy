# Agenda de Contactos

Una aplicación de escritorio desarrollada con **JavaFX** para gestionar contactos de forma sencilla e intuitiva.

## 📋 Descripción

Agenda de Contactos es una aplicación Java que permite crear, editar, eliminar y visualizar contactos de forma organizada. Incluye una interfaz gráfica moderna con soporte para tema claro y oscuro, almacenamiento en base de datos SQLite y visualización de contactos en tabla interactiva.

## ✨ Características

- ✅ **Gestión de Contactos**: Crear, editar, eliminar y ver contactos
- ✅ **Base de Datos SQLite**: Almacenamiento persistente de datos
- ✅ **Interfaz Gráfica Moderna**: Diseño limpio y profesional con JavaFX
- ✅ **Temas Personalizables**: Cambiar entre tema claro y oscuro
- ✅ **Panel de Detalles**: Visualización completa de la información del contacto
- ✅ **Tabla de Contactos**: Listado interactivo con búsqueda rápida
- ✅ **Foto de Perfil**: Soporte para imagen de perfil de cada contacto

## 🛠️ Tecnologías Utilizadas

- **Java 11+** - Lenguaje de programación
- **JavaFX 13** - Framework para interfaz gráfica
- **SQLite** - Base de datos relacional
- **Maven** - Gestor de dependencias y compilación
- **FXML** - Lenguaje para diseño de interfaces en JavaFX

## 📁 Estructura del Proyecto

```
agenda-contactos/
├── pom.xml                                 # Configuración de Maven
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── module-info.java           # Configuración de módulos Java
│   │   │   └── com/unai/agenda/
│   │   │       ├── view/
│   │   │       │   └── App.java           # Punto de entrada de la aplicación
│   │   │       ├── controller/
│   │   │       │   ├── MainViewController.java    # Controlador principal
│   │   │       │   └── NewContactController.java  # Controlador del formulario
│   │   │       ├── model/
│   │   │       │   └── Contacto.java     # Modelo de datos
│   │   │       ├── dao/
│   │   │       │   └── ContactoDAO.java  # Acceso a datos
│   │   │       └── db/
│   │   │           └── ConexionBD.java   # Conexión a la base de datos
│   │   └── resources/
│   │       └── com/unai/agenda/
│   │           ├── css/
│   │           │   ├── styles.css        # Tema claro
│   │           │   ├── dark-theme.css    # Tema oscuro
│   │           │   └── light-theme.css
│   │           ├── view/
│   │           │   ├── mainView.fxml     # Vista principal
│   │           │   └── newContact.fxml   # Formulario de nuevo contacto
│   │           ├── icons/                # Iconos de botones
│   │           └── img/                  # Imágenes de perfil
│   └── target/                           # Directorio compilado
```

## 🚀 Instalación y Ejecución

### Requisitos Previos

- Java JDK 11 o superior
- Maven 3.6+

### Pasos para Ejecutar

1. **Clonar o descargar el proyecto**

2. **Navegar al directorio del proyecto**
   ```bash
   cd agenda-contactos
   ```

3. **Compilar el proyecto con Maven**
   ```bash
   mvn clean install
   ```

4. **Ejecutar la aplicación**
   ```bash
   mvn javafx:run
   ```

## 📊 Modelo de Datos

### Tabla: `contactos`

| Campo | Tipo | Descripción |
|-------|------|-------------|
| id | INTEGER PRIMARY KEY | Identificador único |
| nombre | TEXT NOT NULL | Nombre del contacto |
| telefono | TEXT | Número de teléfono |
| correo | TEXT | Correo electrónico |
| webPersonal | TEXT | Sitio web personal |
| imagenPerfil | TEXT | Ruta de la imagen de perfil |

## 🎨 Interfaz de Usuario

### Componentes Principales

1. **Barra Superior**: Botón para cambiar entre tema claro y oscuro
2. **Tabla de Contactos**: 
   - Columnas: Nombre, Teléfono, Correo
   - Seleccionar un contacto para ver detalles
3. **Panel de Detalles**:
   - Foto de perfil circular
   - Información completa del contacto
   - Botones de acción (nuevo, editar, eliminar)

### Botones de Acción

- 🟢 **Nuevo**: Abrir formulario para crear un nuevo contacto
- 🔵 **Editar**: Modificar los datos del contacto seleccionado
- 🔴 **Eliminar**: Borrar el contacto seleccionado

## 🎯 Funcionalidades

### Crear Contacto

1. Hacer clic en el botón "Nuevo"
2. Completar el formulario con los datos
3. Guardar el contacto

### Editar Contacto

1. Seleccionar un contacto de la tabla
2. Hacer clic en el botón "Editar"
3. Modificar los datos necesarios
4. Guardar los cambios

### Eliminar Contacto

1. Seleccionar un contacto de la tabla
2. Hacer clic en el botón "Eliminar"
3. Confirmar la eliminación

### Cambiar Tema

1. Hacer clic en el botón de tema en la esquina superior derecha
2. La interfaz se cambiará entre tema oscuro y claro

## 📝 Clases Principales

### `App.java`
Clase principal que inicia la aplicación, carga las vistas FXML y conecta a la base de datos.

### `MainViewController.java`
Controlador de la vista principal. Gestiona la interacción con la tabla de contactos y el panel de detalles.

### `NewContactController.java`
Controlador del formulario para crear/editar contactos.

### `Contacto.java`
Modelo de datos que representa un contacto con propiedades observables para JavaFX.

### `ContactoDAO.java`
Clase de acceso a datos que realiza operaciones CRUD en la base de datos.

### `ConexionBD.java`
Gestiona la conexión a SQLite y la creación de tablas.

## 🎨 Temas

### Tema Oscuro (Por defecto)
- Colores oscuros para reducir el cansancio visual
- Texto claro para contraste
- Tabla con fondo gris claro

### Tema Claro
- Colores claros y limpios
- Fondo blanco
- Ideal para uso en ambientes bien iluminados

## 📂 Base de Datos

La aplicación crea automáticamente una base de datos SQLite llamada `agenda.db` en la raíz del proyecto con las tablas necesarias al iniciar.


