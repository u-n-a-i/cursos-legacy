from pyspark.sql import SparkSession
from pyspark.sql.functions import sum as _sum

# Crear sesión de Spark
spark = SparkSession.builder.appName("UnidadesVendidasPorDia").getOrCreate()

# Cargar el archivo CSV
df = spark.read.csv("ventas2.csv", header=True, inferSchema=True)

# Agrupar por fecha y sumar la cantidad
unidades_por_dia = df.groupBy("date").agg(_sum("quantity").alias("total_unidades"))

# Mostrar resultado
unidades_por_dia.show()
