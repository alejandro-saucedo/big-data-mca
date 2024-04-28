# Java Client for Hadoop

This folder contains steps to launch a container with a simple JDK installation.

The container will run simple Java programs to connect to HDFS and run mapreduce jobs.

Code is located under ./src folder.

Before running the java client container, and while the namenode container is running, run ./get_hadoop_jars.sh to copy the required hadoop libraries to the jlib folder, in order to be able to compile and run the java examples.

 - Pull java image (no needed to run again once the java image has been pulled):

`./pull.sh`

 - Run java container:

`.run.sh`


 - Once the container starts, build examples jar:

  `src/build.sh`

Locate and run examples specific scripts under /src
