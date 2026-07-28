package com.constructors;

public class B_ConstructorOverloading {

	
	//constructor 1
	public B_ConstructorOverloading(int a, int b) {
		int c = a+b;
		System.out.println("Summation is: " + c);
	}
	
	
	//constructor 2
	public B_ConstructorOverloading(double a, double b) {
		double c = a+b;
		System.out.println("Summation is: " + c);
	}
	
	//method
	public void display() {
		System.out.println("Constructor overloading is working successfully");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B_ConstructorOverloading obj1 = new B_ConstructorOverloading(10,20);
		obj1.display();
		B_ConstructorOverloading obj2 = new B_ConstructorOverloading(10.3,20.2);
		obj2.display();
	}

}
