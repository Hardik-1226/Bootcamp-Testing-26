package com.FileHandlingInJava.Example;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class wite_to_file {
	public static void main(String[] args) {
		try{
			FileWriter obj=new FileWriter("/Users/kumaranup10/Public/trail.txt");
			obj.append("Welcome to Coforge");
			obj.close();
			System.out.println("Written successfully");
	}catch(IOException e) {
		System.out.println(e.getMessage());
		}
	}
}
