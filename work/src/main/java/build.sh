#!/bin/bash

export HADOOP_CLASSPATH=$(hadoop classpath)
find ./ -name "*.java" > sources.txt
mkdir -p /work/classes
javac -classpath ${HADOOP_CLASSPATH} -d /work/classes @sources.txt && \
    mkdir -p /work/lib && \
    jar -cvf /work/lib/mapreduce-exercises.jar -C /work/classes/ .



