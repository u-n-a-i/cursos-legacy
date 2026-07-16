from pyspark.sql import SparkSession
from pyspark.sql.functions import col

# Crear sesión de Spark
spark = SparkSession.builder.appName("EjemploPySpark").getOrCreate()

# Cargar el CSV como DataFrame
df = spark.read.csv("personas.csv", header=True, inferSchema=True)

# Mostrar el contenido
df.show()

#  Filtrado: personas mayores de 30 años
df.filter(col("edad") > 30).show()

# Agrupación: contar cuántas personas hay por edad
df.groupBy("edad").count().show()

#  Ordenación: ordenar por edad descendente
df.orderBy(col("edad").desc()).show()
