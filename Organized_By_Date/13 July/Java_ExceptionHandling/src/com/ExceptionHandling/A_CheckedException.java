package com.ExceptionHandling;

public class A_CheckedException {
	int x = 10;
	
	public void m1() {
		System.out.println("Value of x is: " + x);
	}
	
	
	public static void main(String[] args) {
		A_CheckedException obj = new A_CheckedException();
		obj.m1();
		
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}

	}

}