package com.Exceptions;

public class Exception_demo {
	int x=10;
	public void m1() {
		System.out.println("value of x: "+x);
	}
	public static void main(String[] args) {
		Exception_demo i=new Exception_demo();
		i.m1();
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
		e.printStackTrace();
		}
	}
}
