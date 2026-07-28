package com.overriding;

class Employee {

    public void work() {
        System.out.println("Employee Working");
    }
}

class Developer extends Employee {

    @Override
    public void work() {
        System.out.println("Developer Writing Java Code");
    }
}

class Tester extends Employee {

    @Override
    public void work() {
        System.out.println("Tester Executing Test Cases");
    }
}

public class B_EmployeeManagement {

    public static void main(String[] args) {

        Developer dev = new Developer();
        dev.work();

        Tester tester = new Tester();
        tester.work();
    }
}