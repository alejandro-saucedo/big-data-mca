#!/bin/bash
docker run --name namenode --network host -p 9870:9870 -p 9010:9000 -v $(dirname $(pwd))/work:/work  --mount "type=volume,src=hadoop_namenode,target=/hadoop/dfs/name" -e CLUSTER_NAME=test -e CORE_CONF_fs_defaultFS="hdfs://namenode:9000" --env-file $(dirname $(pwd))/hadoop.env bd_mca/hadoop-namenode:2.0.0-hadoop3.2.1-java8
