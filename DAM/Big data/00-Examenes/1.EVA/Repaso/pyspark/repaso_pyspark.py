from pyspark.sql import SparkSession
from pyspark.sql.functions import col, round, avg, count

# A)

print("Bloque A")
# 1. Crear sesión Spark
spark = SparkSession.builder.appName("spark").getOrCreate()

# 2. Leer el archivo productos.csv
df = spark.read.csv("productos.csv", header=True, inferSchema=True)

# 3. Mostrar todo el DataFrame
#df.show()

# -------------

# B)

print("Bloque B")
# 1. Productos de la categoría "Electrónica"
df.filter(col("categoría") == "Electrónica").show()

# 2. Productos con precio mayor a 200 euros
df.filter(col("precio") > 200).show()

# 3. Productos con stock menor a 10 unidades
df.filter(col("stock") < 10).show()

# --------------

# C)

print("Bloque C")
# 1. Nueva columna precio_iva con 21% de IVA
df = df.withColumn("precio_iva", round(col("precio") * 1.21, 2))
df.show()

# 2. Precio promedio por categoría
df.groupBy("categoría").agg(round(avg("precio"), 2).alias("precio_promedio")).show()

# 3. Número de productos por categoría
df.groupBy("categoría").agg(count("*").alias("cantidad_productos")).show()

# -------------

# D)

print("D")
# 1. Productos ordenados por precio descendente y mostrar el de mayor precio
df.orderBy(col("precio").desc()).show()
df.orderBy(col("precio").desc()).limit(1).show()

# 2. Mostrar solo nombre y precio_iva
df.select("nombre", "precio_iva").show()

# E)

print("E")
# 1. Productos con stock >= 10 y precio < 500 euros
df.filter((col("stock") >= 10) & (col("precio") < 500)).show()

# 2. Eliminar temporalmente productos con stock 0
productos_disponibles = df.filter(col("stock") > 0)
productos_disponibles.show()
