#!/bin/bash
input_path=$1
output_path=$2
hadoop jar /work/lib/mapreduce-exercises.jar com.packt.mapreduce.minmax.MinMaxDriver $input_path $output_path 
