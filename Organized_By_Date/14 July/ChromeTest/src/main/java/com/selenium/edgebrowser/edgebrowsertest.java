package com.selenium.edgebrowser;

import org.openqa.selenium.edge.EdgeDriver;

public class edgebrowsertest {

	public static void main(String[] args) {
		EdgeDriver driver=new EdgeDriver();
		driver.get("https://www.selenium.dev/about/");
		driver.manage().window().maximize();
		// TODO Auto-generated method stub

	}

}
