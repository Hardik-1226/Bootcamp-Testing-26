package com.decisionMaking.Examples;

public class D_Nested_If {
	public static void main(String[] args) {

	    int age = 25;
	    boolean citizen = true;

	    if (age >= 18) {
	        if (citizen) {
	            System.out.println("Eligible to Vote");
	        }
	    }
	}
}
