#!/bin/bash

mkdir -p jlib

docker cp namenode:/opt/hadoop-3.2.1/share/hadoop/common ./jlib/
docker cp namenode:/opt/hadoop-3.2.1/share/hadoop/hdfs ./jlib/
docker cp namenode:/opt/hadoop-3.2.1/share/hadoop/yarn ./jlib/
docker cp namenode:/opt/hadoop-3.2.1/share/hadoop/mapreduce ./jlib/
