package com.constructors;

public class A_definition {

	
	public A_definition() {
		System.out.println("This is the constructor block");
	}
	
	public void method() {
		System.out.println("This is the method block");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A_definition obj = new A_definition();
		
		obj.method();
		

	}

}
