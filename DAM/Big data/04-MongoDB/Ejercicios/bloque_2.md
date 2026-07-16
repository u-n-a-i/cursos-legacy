**1. Define qué es una base de datos NoSQL y por qué surgió esta necesidad.**

Una base de datos NoSQL (Not Only SQL) es un sistema de almacenamiento de datos que no sigue el modelo relacional tradicional. En lugar de usar tablas con filas y columnas, NoSQL permite almacenar datos en formatos más flexibles como documentos, grafos, pares clave-valor o columnas.

¿Por qué surgió?

Para responder a las limitaciones de escalabilidad y flexibilidad de las bases de datos relacionales.

Por el crecimiento masivo de datos no estructurados (como redes sociales, sensores IoT, logs).

Para permitir una alta disponibilidad y rendimiento en aplicaciones distribuidas y en tiempo real.

**2. Explica brevemente los cuatro tipos principales de bases de datos NoSQL con un ejemplo de uso**

Bases de datos documentales: almacenan datos como documentos JSON o BSON. Cada documento puede tener una estructura distinta.

Ejemplo: MongoDB, ideal para guardar perfiles de usuario o contenido dinámico.

Bases de datos clave-valor: almacenan datos como pares clave y valor. Son muy rápidas para búsquedas simples.

Ejemplo: Redis, útil para gestionar sesiones o caché.

Bases de datos columnares: organizan los datos por columnas en lugar de filas, lo que las hace eficientes para análisis masivos. Ejemplo: Cassandra, usada en sistemas de análisis de logs o métricas.

Bases de datos de grafos: representan los datos como nodos y relaciones. Son ideales para modelar redes sociales, rutas o conexiones.

Ejemplo: Neo4j, útil para analizar relaciones entre personas o entidades.

**3. Compara una base de datos relacional con una documental como MongoDB.**

Las bases de datos relacionales tienen un esquema fijo, usan tablas y requieren que todos los datos sigan una estructura definida. Son ideales para aplicaciones donde la integridad y las relaciones entre datos son críticas, como sistemas bancarios o ERP.

MongoDB, como base documental, permite que cada documento tenga una estructura distinta. No requiere un esquema fijo, lo que facilita el desarrollo ágil y el manejo de datos cambiantes. Además, escala horizontalmente, lo que significa que puede distribuirse en múltiples servidores fácilmente.

**4. Realiza un esquema sencillo con tres documentos de ejemplo para una colección de usuarios.**

([
{ "nombre": "Ana", "edad": 28, "cargo": "Ingeniera", "salario": 35000 },
{ "nombre": "Luis", "edad": 35, "cargo": "Analista", "salario": 42000 },
{ "nombre": "Carla", "edad": 30, "cargo": "Gerente", "salario": 55000 }
])
