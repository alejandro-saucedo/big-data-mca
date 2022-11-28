# run as: unset PYSPARK_DRIVER_PYTHON && /spark//bin/spark-submit --deploy-mode client --driver-memory 2G --executor-memory 2G --packages org.apache.spark:spark-sql-kafka-0-10_2.12:3.0.0 insert_traffic_topic.py
from pyspark.sql import SparkSession
import pyspark.sql.functions as F
from pyspark.sql.types import StructType, StructField, StringType, IntegerType, TimestampType, LongType
import time

KAFKA_BOOTSTRAP_SERVERS = "kafka:9092"
KAFKA_TOPIC = "traffic_sensor"
FILE_PATH = "/work/data/AGOSTO_2022_PARQUET_FINAL/"

# "ID EQP" -> INT 64
SCHEMA = StructType([
    StructField("EQP_ID", LongType()),
    StructField("DATE_TIME", TimestampType()),
    StructField("MILLISECOND", LongType()),
    StructField("CLASSIFICATION", StringType()),
    StructField("ROAD_LANE", LongType()),
    StructField("ADDRESS_ID", LongType()),
    StructField("ROAD_SPEED", StringType()),
    StructField("VEHICLE_SPEED", StringType()),
    StructField("VEHICLE_LENGTH", StringType()),
    StructField("SERIAL_NUMBER", LongType()),
    StructField("LATITUDE", StringType()),
    StructField("LONGITUDE", StringType()),
    StructField("ADDRESS", StringType()),
    StructField("DIRECTION", StringType())
])

spark = SparkSession.builder.appName("write_traffic_sensor_topic").getOrCreate()
spark.sparkContext.setLogLevel("WARN") # Reduce logging verbosity

# Read the parquet file write it to the topic
# We need to specify the schema in the stream
# and also convert the entries to the format (key, value)
df_traffic_stream = spark.read.format("parquet")\
    .schema(SCHEMA)\
    .load(FILE_PATH)\
    .withColumn("value", F.to_json( F.struct(F.col("*")) ) )\
    .withColumn("key", F.lit("key"))\
    .withColumn("value", F.encode(F.col("value"), "iso-8859-1").cast("binary"))\
    .withColumn("key", F.encode(F.col("key"), "iso-8859-1").cast("binary"))\
    .select("key", "value")\
    .limit(100000)

df_traffic_stream.write\
    .format("kafka")\
    .option("kafka.bootstrap.servers", KAFKA_BOOTSTRAP_SERVERS)\
    .option("topic", KAFKA_TOPIC)\
    .save()

"""
# Write the stream to the topic
df_traffic_stream\
    .writeStream\
    .format("kafka")\
    .option("kafka.bootstrap.servers", KAFKA_BOOTSTRAP_SERVERS)\
    .option("topic", KAFKA_TOPIC)\
    .option("checkpointLocation", "/tmp/checkpoint")\
    .start()\
    .awaitTermination()
"""
