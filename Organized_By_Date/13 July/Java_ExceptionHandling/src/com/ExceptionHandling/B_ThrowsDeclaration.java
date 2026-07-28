package com.ExceptionHandling;

public class B_ThrowsDeclaration {

	int x = 143;

	public void m1() {
		System.out.println("Value of x is: " + x);
	}

	public static void main(String[] args) throws InterruptedException {

		B_ThrowsDeclaration obj = new B_ThrowsDeclaration();

		obj.m1();

		Thread.sleep(0);
	}
}