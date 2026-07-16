from pyspark.sql import SparkSession
from pyspark.sql.functions import col, count, sum, avg, min, max

# Crear sesión de Spark
spark = SparkSession.builder.appName("EjerciciosCSV").getOrCreate()

# Cargar el CSV
df = spark.read.csv("personas.csv", header=True, inferSchema=True)

# Ejercicio 1: Filtrar edades > 30
df.filter(col("edad") > 30).show()

# Ejercicio 2: Contar por ciudad
df.groupBy("ciudad").agg(count("*").alias("cantidad")).show()

# Ejercicio 3: Seleccionar columnas nombre y edad
df.select("nombre", "edad").show()

# Ejercicio 4: Ordenar por edad descendente
df.orderBy(col("edad").desc()).show()

# Ejercicio 5: Crear nueva columna edad + 5
df.withColumn("edad_mas_5", col("edad") + 5).show()

# Ejercicio 6: Suma de la columna monto
df.select(sum("monto").alias("suma_monto")).show()

# Ejercicio 7: Promedio de edades
df.select(avg("edad").alias("promedio_edad")).show()

# Ejercicio 8: Filtrar por ciudad “Madrid”
df.filter(col("ciudad") == "Madrid").show()

# Ejercicio 9: Contar filas
print("Número de registros:", df.count())

# Ejercicio 10: Edad mínima y máxima
df.select(min("edad").alias("edad_minima"), max("edad").alias("edad_maxima")).show()
