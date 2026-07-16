# pyspark_ejercicios.py
# Ejemplos PySpark comentados — lectura, filtros, transformaciones, agregaciones y más.

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, round as spark_round, avg, count, when, expr
from pyspark.sql.functions import sum as spark_sum
from pyspark.sql.window import Window

# -------------------------------------------------------
# 1) Crear sesión Spark
# -------------------------------------------------------
# SparkSession es la entrada principal para usar DataFrames en PySpark.
spark = SparkSession.builder \
    .appName("EjerciciosPySpark") \
    .master("local[*]") \   # usa todos los cores locales (en examen puede valer también sin especificar)
    .getOrCreate()

# -------------------------------------------------------
# 2) Crear / preparar un CSV de ejemplo (opcional)
# -------------------------------------------------------
# Si no tienes el fichero productos.csv en el entorno, puedes crear uno rápidamente.
# (En un examen normal ya te darán el CSV; este bloque es sólo para pruebas locales.)
csv_text = """nombre,categoría,precio,stock
Portátil,Electrónica,850,10
Smartphone,Electrónica,500,25
Silla Oficina,Mobiliario,120,15
Mesa Escritorio,Mobiliario,250,8
Auriculares,Electrónica,80,50
"""
# Guardar a disco (descomenta si quieres crear el fichero)
# with open("productos.csv", "w", encoding="utf-8") as f:
#     f.write(csv_text)

# -------------------------------------------------------
# 3) Leer el archivo productos.csv como DataFrame
# -------------------------------------------------------
# header=True para que la primera fila sea cabecera; inferSchema=True intenta detectar tipos.
df = spark.read.csv("productos.csv", header=True, inferSchema=True)

# Mostrar el esquema y las primeras filas para confirmar lectura correcta
print("Esquema del DataFrame:")
df.printSchema()
print("Contenido del DataFrame:")
df.show(truncate=False)

# -------------------------------------------------------
# a) Consultas y filtros (según enunciado)
# -------------------------------------------------------
# 1. Mostrar todos los productos de la categoría "Electrónica"
print("Productos categoría Electrónica:")
df.filter(col("categoría") == "Electrónica").show()

# 2. Mostrar productos cuyo precio sea mayor de 200 euros
print("Productos con precio > 200:")
df.filter(col("precio") > 200).show()

# 3. Mostrar productos con stock menor a 10 unidades
print("Productos con stock < 10:")
df.filter(col("stock") < 10).show()

# -------------------------------------------------------
# b) Transformaciones y agregaciones
# -------------------------------------------------------
# 1. Crear nueva columna precio_iva aplicando 21% IVA (redondeando a 2 decimales)
df = df.withColumn("precio_iva", spark_round(col("precio") * 1.21, 2))
print("DataFrame con columna precio_iva:")
df.show(truncate=False)

# 2. Precio promedio de todos los productos por categoría
print("Precio promedio por categoría (sin IVA):")
df.groupBy("categoría") \
  .agg(spark_round(avg("precio"), 2).alias("precio_promedio")) \
  .show()

# 3. Cuenta cuántos productos hay en cada categoría
print("Número de productos por categoría:")
df.groupBy("categoría") \
  .agg(count("*").alias("cantidad_productos")) \
  .show()

# -------------------------------------------------------
# c) Ordenaciones y selecciones
# -------------------------------------------------------
# 1. Productos ordenados por precio de mayor a menor
print("Productos ordenados por precio descendente:")
df.orderBy(col("precio").desc()).show()

# Mostrar el producto con mayor precio (limit 1)
print("Producto con mayor precio:")
df.orderBy(col("precio").desc()).limit(1).show()

# 2. Mostrar únicamente las columnas nombre y precio_iva
print("Columnas nombre y precio_iva:")
df.select("nombre", "precio_iva").show()

# -------------------------------------------------------
# d) Filtrado avanzado y 'eliminación lógica'
# -------------------------------------------------------
# 1. Filtrar productos con stock >= 10 y precio < 500
print("Productos con stock >= 10 y precio < 500:")
df.filter((col("stock") >= 10) & (col("precio") < 500)).show()

# 2. Crear DataFrame productos_disponibles eliminando temporalmente productos con stock 0
# (En este dataset no hay stock 0; pero así se haría)
productos_disponibles = df.filter(col("stock") > 0)
print("Productos disponibles (stock > 0):")
productos_disponibles.show()

# -------------------------------------------------------
# Ejercicios adicionales que pueden caer en examen
# -------------------------------------------------------

# Ejemplo 1: Crear una columna 'estado_stock' usando when: 'Bajo' si stock<10, 'Medio' si 10-30, 'Alto' >30
df2 = df.withColumn("estado_stock",
                   when(col("stock") < 10, "Bajo")
                   .when((col("stock") >= 10) & (col("stock") <= 30), "Medio")
                   .otherwise("Alto"))
print("Ejemplo estado_stock:")
df2.select("nombre", "stock", "estado_stock").show()

# Ejemplo 2: Agregaciones extra — total inventario por categoría (suma de stock) y valor total (precio * stock)
df_valor = df.withColumn("valor_total", col("precio") * col("stock"))
print("Valor total por categoría (suma de precio * stock) y stock total:")
df_valor.groupBy("categoría") \
    .agg(
        spark_round(avg("precio"), 2).alias("precio_promedio"),
        spark_sum("stock").alias("stock_total"),
        spark_round(spark_sum("valor_total"), 2).alias("valor_inventario_total")
    ).show()

# Ejemplo 3: Window — ranking de productos por precio dentro de cada categoría
w = Window.partitionBy("categoría").orderBy(col("precio").desc())
from pyspark.sql.functions import rank
df_rank = df.withColumn("rank_precio_categoria", rank().over(w))
print("Ranking por precio dentro de cada categoría:")
df_rank.select("nombre", "categoría", "precio", "rank_precio_categoria").orderBy("categoría", "rank_precio_categoria").show()

# Ejemplo 4: Pivot — tabla cruzada: contar número de productos por estado_stock y categoría
pivot = df2.groupBy("categoría").pivot("estado_stock").count()
print("Pivot (conteo por estado_stock / categoría):")
pivot.show()

# Ejemplo 5: Guardar resultado a CSV (modo local)
# df_valor.write.mode("overwrite").csv("productos_valorados.csv", header=True)

# -------------------------------------------------------
# Fin — cerrar sesión Spark
# -------------------------------------------------------
spark.stop()
