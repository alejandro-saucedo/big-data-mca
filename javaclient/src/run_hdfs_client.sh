#!/bin/bash
hadoop_jars=/jlib/common/*:/jlib/common/lib/*:/jlib/hdfs/*:/jlib/hdfs/lib/*
examples_jar_path=/jlib/examples.jar

java -cp ${examples_jar_path}:${hadoop_jars} example.HDFSClient $1 $2
