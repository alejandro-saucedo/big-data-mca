#!/bin/bash
number=$1
cont_name="spark-worker-$number"
port1=$((8080+$number))
port2=$((4041+$number))
docker run --name $cont_name --network big-data-mca_default -p $port1:8081 -p $port2:4040 -v $(pwd)/../work:/work  -e  CORE_CONF_fs_defaultFS=hdfs://namenode:9000 -e SPARK_MASTER=spark://spark-master:7077 bd_mca/spark-worker:3.0.0-hadoop3.2
