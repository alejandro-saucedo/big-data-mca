#!/bin/bash
cont_name="datanode-2"
vol_name="hadoop_$cont_name"
docker volume create $vol_name
docker run --name $cont_name --network big-data-mca_default -p 9865:9864 --mount "type=volume,src=$vol_name,target=/hadoop/dfs/data" -e  CORE_CONF_fs_defaultFS=hdfs://namenode:9000 -e SERVICE_PRECONDITION="namenode:9870" --env-file $(dirname $(pwd))/hadoop.env bd_mca/hadoop-datanode:2.0.0-hadoop3.2.1-java8
