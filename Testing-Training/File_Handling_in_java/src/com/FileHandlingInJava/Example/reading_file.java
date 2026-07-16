package com.FileHandlingInJava.Example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class reading_file {
	public static void main(String[] args) {
		try{
			File obj=new File("/Users/kumaranup10/Public/trail.txt");
		Scanner myreader=new Scanner(obj);
		while(myreader.hasNextLine()){
			String data=myreader.nextLine();
			System.out.println(data);
		}
		myreader.close();
	}
	catch(FileNotFoundException e) {
		System.out.println(e.getMessage());
		}
	}
}
