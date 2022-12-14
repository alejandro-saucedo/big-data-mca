package com.packt.mapreduce.minmax;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
public class MinMaxDriver  extends Configured implements Tool {
    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), (Tool) new
                MinMaxDriver(), args);
        System.exit(res);
    }

    public int run(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "MinMax");
        job.setJarByClass(MinMaxDriver.class);
        if (args.length < 2) {
            System.out.println("Jar requires 2 paramaters : \""
                    + job.getJar()
                    + " input_path output_path");
            return 1;
        }
        job.setMapperClass(MinMaxMapper.class);
        job.setReducerClass(MinMaxReducer.class);
        //job.setCombinerClass(MinMaxReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(PlayerDetail.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        Path filePath = new Path(args[0]);
        FileInputFormat.setInputPaths(job, filePath);
        Path outputPath = new Path(args[1]);
        FileOutputFormat.setOutputPath(job, outputPath);
        job.waitForCompletion(true);
        return 0;
    }
}
