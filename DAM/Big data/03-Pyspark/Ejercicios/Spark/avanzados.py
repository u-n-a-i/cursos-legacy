from pyspark.sql import SparkSession
from pyspark.sql.functions import col, sum, avg, max, count

# Crear sesión de Spark
spark = SparkSession.builder.appName("EjerciciosVentas").getOrCreate()

# Cargar los CSV
personas = spark.read.csv("personas.csv", header=True, inferSchema=True)
ventas = spark.read.csv("ventas.csv", header=True, inferSchema=True)

# Renombrar columna 'monto' en ventas para evitar ambigüedad
ventas = ventas.withColumnRenamed("monto", "monto_venta")

# Ejercicio 11: Join de DataFrames
print("\n Ejercicio 11: Join entre personas y ventas")
join_df = personas.join(ventas, on="nombre", how="inner")
join_df.select("nombre", "producto", "monto_venta").show()

# Ejercicio 12: Agregación de ventas por producto
print("\n Ejercicio 12: Agregación por producto")
ventas.groupBy("producto").agg(
    sum("monto_venta").alias("total_ventas"),
    avg("monto_venta").alias("promedio_ventas"),
    max("monto_venta").alias("venta_maxima")
).show()

# Ejercicio 13: Clientes frecuentes (más de 3 compras)
print("\n Ejercicio 13: Clientes frecuentes")
ventas.groupBy("nombre").agg(count("*").alias("compras")) \
    .filter(col("compras") > 3).show()

# Ejercicio 14: Clientes con compras grandes (más de 5000 en total)
print("\n Ejercicio 14: Clientes con compras grandes")
ventas.groupBy("nombre").agg(sum("monto_venta").alias("total_gastado")) \
    .filter(col("total_gastado") > 5000).show()
