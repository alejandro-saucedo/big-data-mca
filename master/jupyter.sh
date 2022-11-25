#!/bin/bash
lib_path=/work/lib
docker exec -it spark-master /spark/bin/pyspark --master spark://spark-master:7077 --packages org.apache.spark:spark-sql-kafka-0-10_2.12:3.0.0 --driver-class-path $lib_path/sqlite-jdbc-3.39.3.0.jar --jars $lib_path/sqlite-jdbc-3.39.3.0.jar
