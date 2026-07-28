package com.overriding;

class Bank {
	public void calculateInterest() {
		System.out.println("General Interest Calculation");
	}
}

class SBI extends Bank {
	public void calculateInterest() {
		System.out.println("SBI Interest = 6.5%");
	}
}

class HDFC extends Bank {
	public void calculateInterest() {
		System.out.println("HDFC Interest = 7%");
	}
}

class ICICI extends Bank {
	public void calculateInterest() {
		System.out.println("ICICI Interest = 8%");
	}
}


public class A_BankTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SBI sbi = new SBI();
		sbi.calculateInterest();
		
		HDFC hdfc = new HDFC();
		hdfc.calculateInterest();
		
		ICICI icici = new ICICI();
		icici.calculateInterest();

	}

}
