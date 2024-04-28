package example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;

public class HDFSClient{

	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
                conf.set("fs.defaultFS", "hdfs://namenode:9000");
		
		FileSystem fs = FileSystem.get(conf);


		FileStatus[] files = fs.listStatus(new Path("/data"));
                for(FileStatus file : files){
			System.out.println(file.getPath());
		}
		String localPath = args[0];

		String hdfsPath = args[1];
		
		Path src = new Path(localPath);
		Path dst = new Path(hdfsPath);

		fs.copyFromLocalFile(src, dst);

		fs.close();
	}

}
