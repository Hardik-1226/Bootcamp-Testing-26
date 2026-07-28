package com.scannerClass;

import java.util.Scanner;


public class B_nextLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter Full Name: ");
        String fullName = sc.nextLine();

        System.out.print("Enter House Number: ");
        String house = sc.nextLine();

        System.out.print("Enter Street Name: ");
        String street = sc.nextLine();

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        System.out.println("\n--- Address Details ---");
        System.out.println("Full Name: " + fullName);
        System.out.println("House Number: " + house);
        System.out.println("Street Name: " + street);
        System.out.println("City: " + city);

        sc.close();

	}

}
