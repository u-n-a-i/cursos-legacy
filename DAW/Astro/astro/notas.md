# Astro

## Estructura (Básica)

- tsconfig: configuración de TypeScript
- package.json: configuración de dependencias, scripts, información del proyecto.
- astro.config.mjs: permite personalizar cómo se comporta Astro durante el desarrollo y la construcción del sitio.
- public: Los archivos se sirven tal cual, sin procesamiento. Útil para favicons, PDFs, etc.
- src:
  - assets: Astro puede optimizar imágenes, fuentes y otros archivos durante el build.
  - components: Aquí defines bloques reutilizables como botones, encabezados, tarjetas, etc.
  - layouts: Esta carpeta contiene plantillas que definen la estructura común de tus páginas (como `<html>`, `<head>`,` <body>`, etc.).
  - pages: Cada archivo que colocas allí se convierte automáticamente en una página accesible desde una URL en tu sitio web.

## Sintaxis

- code fences: --- Se ejecuta en el servidor o en build time.
