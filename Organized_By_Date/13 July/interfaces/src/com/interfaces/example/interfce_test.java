package com.interfaces.example;
interface firstinterface{
	public void mymethod();
}
interface second{
	public void second_interface();
}
class demo implements firstinterface,second{
	public void mymethod() {
		System.out.println("First interface ");
	}
	public void second_interface() {
		System.out.println("Second interface ");
	}
}
public class interfce_test {
	public static void main(String[] args) {
		demo d=new demo();
		d.mymethod();
		d.second_interface();
	}public interfce_test() {
		// TODO Auto-generated constructor stub
	}
}