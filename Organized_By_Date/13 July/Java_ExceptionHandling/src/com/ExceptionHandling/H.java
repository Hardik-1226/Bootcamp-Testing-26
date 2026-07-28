package com.ExceptionHandling;

public class H {

    public static void main(String[] args) {

        Integer age = null;
        String ageAsString;

        try {
            ageAsString = age.toString();
        }
        catch (NullPointerException e) {

            age = 18;
            ageAsString = age.toString();
        }

        System.out.println(age);
        System.out.println(ageAsString);

        String yourAge = "You are " + age.toString() + " years old";

        if (yourAge.equals("You are 18 years old")) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }
}