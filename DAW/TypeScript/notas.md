# TypeScript

- Compilar ts a js
  - tsc nombreDelArchivo.ts
- Observar los cambios
  - tsc nombreDelArchivo.ts -watch
  - tsc nombreDelArchivo.ts -w

Con archivo de configuración:

- Crear fichero de configuración
  - tsc --init
  - (no hace falta el nombre para compilar) tsc -w
  - Carpeta entrada: "rootDir": "./src",
  - Carpeta salida: "outDir": "./public",
  - Carpetas a tener en cuenta (debajo(fuera de las llaves) del cierre compilerOptions):
  ```json
    "include": ["src"]
  ```
