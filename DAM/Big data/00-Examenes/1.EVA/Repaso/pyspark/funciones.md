# Funciones

```py
# Funciones comunes de agregación
Estas se usan con groupBy, agg, etc.

sum(): suma de una columna

min(), max(): mínimo y máximo

mean(): promedio

stddev(), variance(): desviación estándar y varianza

countDistinct(): cuenta valores únicos

# Funciones matemáticas
abs(): valor absoluto

sqrt(): raíz cuadrada

exp(), log(), log10(): exponencial y logaritmos

pow(): potencia

floor(), ceil(): redondeo hacia abajo o arriba

# Funciones de fecha y hora
current_date(), current_timestamp()

year(), month(), dayofmonth(), hour(), minute()

datediff(), date_add(), date_sub()

to_date(), to_timestamp()

# Funciones de texto
lower(), upper(): cambiar a minúsculas o mayúsculas

length(): longitud de cadena

trim(), ltrim(), rtrim(): eliminar espacios

concat(): concatenar columnas

substring(): extraer parte de una cadena

regexp_replace(), regexp_extract(): expresiones regulares

# Funciones de ventana (window functions)
row_number(), rank(), dense_rank()

lead(), lag(): acceder a filas anteriores o siguientes

ntile(): dividir en grupos

# Funciones lógicas y condicionales
when(), otherwise(): condicionales tipo if

isnull(), isnotnull()

lit(): crear una columna con un valor constante

# Funciones de transformación
col(): acceder a una columna

alias(): renombrar columnas

cast(): cambiar tipo de dato

array(), struct(), explode(): trabajar con estructuras complejas
```
