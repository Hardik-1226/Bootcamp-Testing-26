package com.Exceptions;

public class throws_declaretaion {
	int x=10;
	public void m1() {
		System.out.println("value of x: "+x);
	}
	public static void main(String[] args) throws InterruptedException {
		throws_declaretaion i=new throws_declaretaion();
		i.m1();
			Thread.sleep(0);
	}
}


