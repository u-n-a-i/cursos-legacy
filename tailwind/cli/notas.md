# Notas de Tailwind

## CLI

- Modo observer en CLI
  - npx @tailwindcss/cli -i ./src/input.css -o ./src/output.css --watch

## Configuración tailwind.config.js

- Permite agregar tus propios estilos.
- Crearlo en la raíz

```js
/** @type {import('tailwindcss').Config} */
export default {
  content: ["./src/**/*.{html,js}"],
  theme: {
    extend: {},
  },
  plugins: [],
};
```
