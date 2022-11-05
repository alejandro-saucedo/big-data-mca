#!/bin/bash
docker exec -it spark-master /spark/bin/pyspark --master spark://spark-master:7077
