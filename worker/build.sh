#!/bin/bash

docker build -t bd_mca/spark-worker:3.0.0-hadoop3.2 -f ./Dockerfile .
