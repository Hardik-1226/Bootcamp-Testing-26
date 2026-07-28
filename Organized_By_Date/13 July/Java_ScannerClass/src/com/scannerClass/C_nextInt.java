package com.scannerClass;

import java.util.Scanner;

public class C_nextInt {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Roll Number: ");
		int rollNo = sc.nextInt();

		System.out.print("Enter Age: ");
		int age = sc.nextInt();

		System.out.print("Enter Marks: ");
		int marks = sc.nextInt();

		System.out.println("\n--- Student Details ---");
		System.out.println("Roll Number: " + rollNo);
		System.out.println("Age: " + age);
		System.out.println("Marks: " + marks);

		sc.close();
	}
}