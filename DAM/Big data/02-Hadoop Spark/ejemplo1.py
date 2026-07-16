from pyspark.sql import SparkSession

spark = SparkSession.builder \
    .appName("Spark Timeout Example") \
    .getOrCreate()

# Your operations
df = spark.read.csv("datos.csv", header=True, inferSchema=True)
df.filter(df["edad"] > 30).groupBy("ciudad").count().show()