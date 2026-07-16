# Sumador

> Objetivo: Lanzar una clase con ProcessBuilder

- Una clase Sumador que suma los números entre dos valores.
- Un método main que acepta los valores desde la línea de comandos.
- Una clase Lanzador que ejecuta el programa Sumador como proceso externo y guarda el resultado en archivos.

Recordatorio:

- Con VSCode y los archivos.class en bin.
- Poner la carpeta classpath->bin
  -  ProcessBuilder pb = new ProcessBuilder("java", "-cp", "bin", "Sumador", String.valueOf(n1), String.valueOf(n2));

```bash
javac -d bin src/Sumador.java src/Lanzador.java
java -cp bin Lanzador
```