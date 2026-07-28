package com.DecisionMakingStatements.Examples;

public class D_Nested_If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String address = "Delhi, India";
		
		if(address.endsWith("India")) {
			if(address.contains("Meerut")) {
				System.out.println("City is meerut");
			} else if(address.contains("Noida")){
				System.out.println("City is Noida");
			} else {
				System.out.println(address.split(",")[0]);
			}
		} else {
			System.out.println("You are not in india");
		}
	}

}
