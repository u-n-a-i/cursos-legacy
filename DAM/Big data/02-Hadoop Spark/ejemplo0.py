from pyspark.sql import SparkSession

# Crear la sesión de Spark
spark = SparkSession.builder.appName("Ejemplo").getOrCreate()

# Datos de ejemplo
data = [
    {"nombre": "Ana", "edad": 25, "ciudad": "Madrid"},
    {"nombre": "Luis", "edad": 35, "ciudad": "Barcelona"},
    {"nombre": "Pedro", "edad": 40, "ciudad": "Madrid"},
    {"nombre": "Laura", "edad": 28, "ciudad": "Valencia"}
]

# Crear DataFrame
df = spark.createDataFrame(data)

# Filtrar por edad > 30, agrupar por ciudad y contar
df.filter(df["edad"] > 30).groupBy("ciudad").count().show()
