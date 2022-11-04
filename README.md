# Repository for Big Data Class - Maestría en Cómputo Aplicado

## Content:
   - notebooks: Folder with example notebooks used in different lessons
   - data: Folder with data files used by different notebooks and exercises
   - exercises: Folder containing exercises by lessons
   - Docker containers: The following folders contain the docker image's Dockerfile, a build and a run script for building/running hadoop/spark-related containers:
     - namenode
     - datanode
     - resourcemanager
     - nodemanager
     - historyserver
     - master
     - worker

## Running Containers

  1. Build each container using the build.sh script located under each container folder
  2. There are two ways to run the containers:
      1. Run all the containers at once using the docker-compose.yaml file. Run:
    
      ```
      docker compose up
      ```
    
      2. Run each container using the run.sh script located under each container folder. The containers must be run in the order listed in the containers list from the Content section
      
## Running Jupyter Notebook

Once all the containers are running, connect to any of the spark nodes. For example, connect to spark-master container:

```
docker exect -it spark-master bash
```

Once in the container, launch Jupyter Notebook by running this:

```
/spark/bin/pyspark --master spark://spark-master:7077
```
