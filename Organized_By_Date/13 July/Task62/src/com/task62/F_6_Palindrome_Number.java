package com.task62;

public class F_6_Palindrome_Number {
	public static void main(String[] args) {

	    int num = 121;
	    int temp = num;
	    int reverse = 0;

	    while (num > 0) {
	        int digit = num % 10;
	        reverse = reverse * 10 + digit;
	        num = num / 10;
	    }

	    if (temp == reverse) {
	        System.out.println("Palindrome Number");
	    } else {
	        System.out.println("Not a Palindrome Number");
	    }
	}
}
