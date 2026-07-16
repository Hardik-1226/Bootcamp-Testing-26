package com.FileHandlingInJava.Example;

import java.io.File;
import java.io.IOException;

public class delete_file {
	public static void main(String[] args) {
			File myobj=new File("/Users/kumaranup10/Public/trail.txt");
			try {
				if(myobj.delete()) {
					System.out.println("File is deleted: ");
				}
				else {
					System.out.print("unable to delete file");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
