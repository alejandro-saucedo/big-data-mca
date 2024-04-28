#!/bin/bash

hadoop_jars=/jlib/common/*:/jlib/common/lib/*:/jlib/hdfs/*:/jlib/hdfs/lib/*

find ./src -name "*.java" > sources.txt
classes_path=/src/classes
examples_jar_path=/jlib/java_examples.jar
rm -rf ${classes_path}
mkdir -p ${classes_path}
examples_jar_path=/jlib/examples.jar
rm -f ${examples_jar_path}

javac -classpath ${hadoop_jars} -d ${classes_path} @sources.txt && \
    jar -cvf ${examples_jar_path} -C ${classes_path} .
