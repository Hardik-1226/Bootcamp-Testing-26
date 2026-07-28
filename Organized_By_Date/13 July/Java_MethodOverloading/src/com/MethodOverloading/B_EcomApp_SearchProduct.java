package com.MethodOverloading;


/* Task 57 - Method Overloading and Method Overriding in Java
 Example 2 - Ecom Application Search Product */



public class B_EcomApp_SearchProduct {

	public void search(String productName) {
		System.out.println("Searching product by name: " + productName);
	}
	
	public void search(String productName, String brand) {
		System.out.println("Searching by product and brand: " + productName + " " + brand);
	}
	
	public void search(String productName, String brand, int price) {
		System.out.println("Searching by product, brand and price: " + productName + " " + brand + " " + price);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B_EcomApp_SearchProduct s = new B_EcomApp_SearchProduct();
		
		s.search("Shampoo");
		s.search("Shampoo", "Dove");
		s.search("Shampoo", "Dove", 500);
		
	}

}
