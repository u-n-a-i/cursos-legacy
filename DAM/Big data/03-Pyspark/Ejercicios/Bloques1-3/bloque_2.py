from pyspark.sql import SparkSession
from pyspark.sql.functions import col, sum as _sum, expr

# Crear sesión de Spark
spark = SparkSession.builder.appName("VentasTotalesPorProducto").getOrCreate()

# Cargar el archivo CSV
df = spark.read.csv("ventas.csv", header=True, inferSchema=True)

# Filtrar ventas con quantity > 0
df_filtrado = df.filter(col("quantity") > 0)

# Calcular ingresos por fila: quantity * price
df_ingresos = df_filtrado.withColumn("ingreso", expr("quantity * price"))

# Agrupar por producto y sumar ingresos
ventas_totales = df_ingresos.groupBy("product").agg(_sum("ingreso").alias("total_ventas"))

# Mostrar resultado
ventas_totales.show()
