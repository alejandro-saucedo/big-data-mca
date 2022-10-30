package com.packt.mapreduce.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class CustomPartitioner extends Partitioner < Text, IntWritable >{
	   @Override
	public int getPartition(Text key, IntWritable value, int numReduceTasks){
		String str = key.toString();
		if(str.length() == 0){
			return 0;
		}
		char c = str.charAt(0);
		if(c < 'h'){
			return 0;
		}
		if (c < 'p'){
			return 1;
		}
		return 2;

	}
}
