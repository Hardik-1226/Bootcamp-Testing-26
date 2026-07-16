package com.FileHandlingInJava.Example;

import  java.io.File;
import java.io.IOException;

public class File_Demo {
	public static void main(String[] args) {
		try {
			File myobj=new File("/Users/kumaranup10/Public/trail.txt");
			if(myobj.createNewFile()) {
				System.out.println("File is created: "+myobj.getName());
				System.out.println("Absolute path: "+myobj.getAbsolutePath());
			}
			else {
				System.out.println("File already exist");
			}
		}
		catch(IOException e) {
		e.printStackTrace();
		}
	}
}
