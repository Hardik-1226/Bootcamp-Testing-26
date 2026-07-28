package com.AccessModifiersExample;

class A {
	int x = 100;
}

public class A_Private {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A obj = new A();
		int output = obj.x;
		System.out.println("Output is: " + output);
	}

}
