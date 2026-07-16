package com.FileHandlingInJava.Example;
import java.io.File;
import java.io.IOException;
public class get_info_of_file {
	public static void main(String[] args) {
		File obj=new File("/Users/kumaranup10/Public/trail.txt");
		if(obj.exists()) {
			System.out.println("File name: "+obj.getName());
			System.out.println("Absolute path: "+obj.getAbsolutePath());
			System.out.println("writeable or not: "+obj.canWrite());
			System.out.println("readble or not: "+obj.canRead());
		}
		else {
			System.out.println("File not exits ");
		}
	}
}
