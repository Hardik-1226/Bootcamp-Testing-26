package com.constructors;

class Website {

    // fields (or instance variables)
    String webName;
    int webAge;

    // constructor
    Website(String name, int age) {
        this.webName = name;
        this.webAge = age;
    }
}

public class D_UsingInstanceVariable {

    public static void main(String[] args) {

        Website obj1 = new Website("Brahm", 20);
        Website obj2 = new Website("https://www.google.com/", 18);

        // Accessing object data through reference variables
        System.out.println(obj1.webName + " " + obj1.webAge);
        System.out.println(obj2.webName + " " + obj2.webAge);
    }
}