# Angular

## Conceptos

- WEB:
  - SPA: Single Page Application (Una sola pagina)
  - SSR: Server Side Rendering (Lado del servidor)
  - SSG: Server Side Rendering (De manera estática)
- Movil:
  - Ionic
  - NativeScript
- Desktop:

  - Electron

- Angular tiene gestor de estado, enrutamiento, reactivad, petición HTTP, directivas...

- Bloques fundamentales:
  - Componentes: Pieza que representa una parte de la interface del usuario(Lógica-TS; Estilo-CSS/SASS...; Plantilla-HTML)
  - Rutas: Navegación, cambiar entre paginas
  - Directivas: Modifica el comportamiento de un elemento HTML. Directivas(Atributo,Estructurales,Componente)
  - Servicios: Encapsulan la lógica de negocio y centralizan el acceso(gestión de datos, reutilizar código, inyección de dependencias).
  - Módulos: Agrupan funcionalidades relacionadas.
  - Pipes: Transforman datos de forma visual para representarlos apropiadamente.Tipos pipes puros e impuros.

## Comandos

- Crear proyecto con CLI: ng new nombreProyecto
- Levantar proyecto: ng serve
  - Abrir en el navegador(automático): ng serve -o
- Modo producción/distribución: ng build
  - Compartir el directorio de browser.
  - Rutas: Configurar el app.config.ts -> Implementar HashStrategy
