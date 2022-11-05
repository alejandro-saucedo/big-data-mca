# Repository for Big Data Class - Maestría en Cómputo Aplicado

## Content:
   - work: This folder can also be found under the path /work in some containers.
     - notebooks: Folder with example notebooks used in different lessons
     - data: Folder with data files used by different notebooks and exercises
     - src: Code used in examples and practices
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
     1. Go to each container folder and run build.sh:
     ```
     cd namenode
     ./build.sh
     cd ../datanode
     ./build.sh
     # and so for each folder listed in section Content-Docker containers
     ```
     2. Validate that the 7 images were created by running:
     ```
     docker image list
     ```
  2. Run containers:
      1. Go to the repository root folder
      2. Run the following command.
    
      ```
      docker compose up
      ```
      3. The previous command will start all the services which will remain running until you type Ctrl+c.
  3. Validate that all 7 containers are up and running by running:
  ```
  docker container list
  ```

### Troubleshooting

   - $'\r': command not found: Make sure the file referenced by the error contains unix-style end of lines (EOL). In windows, use visual studio code or notepad++ to change from Windows EOL to Unix EOL. In linux run dos2unix on the files with the problems.
   - Containers take too long to perform tasks or appear as unhealthy running on a VM: increase the memory and if possible, add more CPU cores to the VM.
      
## Running Jupyter Notebook

Once all the containers are running, connect to any of the spark nodes. For example, connect to spark-master container:

```
docker exect -it spark-master bash
```

Once in the container, launch Jupyter Notebook by running this:

```
/spark/bin/pyspark --master spark://spark-master:7077
```
