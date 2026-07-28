package com.AccessModifiersExample;

public class C_Protected extends B {

		C_Protected obj = new C_Protected();
		int output = obj.z;
		System.out.println("Value of z is: " + output);
		obj.ProtectedMethod();
}
