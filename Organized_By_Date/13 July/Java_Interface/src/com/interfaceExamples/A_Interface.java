package com.interfaceExamples;

interface FirstInterface {
	public void myMethod(); //interface method
}

interface SecondInterface {
	public void otherMethod(); //interface method
}

//DemoClass "implements" FirstInterface and SecondInterface
class A_Interface implements FirstInterface, SecondInterface {
	public void myMethod() {
		System.out.println("Enter Some text... ");
	}
	
	public void otherMethod() {
		System.out.println("Enter some other text... ");
	}
	
	public static void main(String[] args) {
		A_Interface myObj = new A_Interface();
		myObj.myMethod();
	}
}



