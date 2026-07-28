package com.constructors;

class Employee {
    private int id;
    private String name;
    private float salary;
    private String ssn;

    // Constructor
    public Employee(int id, String name, float salary, String ssn) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.ssn = ssn;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }

    public String getSsn() {
        return ssn;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}

public class C_UsingSetterGetter {

    public static void main(String[] args) {

        // Creating Employee object using constructor
        Employee emp = new Employee(101, "Brahm", 50000.0f, "SSN12345");

        // Using getters
        System.out.println("Employee ID: " + emp.getId());
        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Employee Salary: " + emp.getSalary());
        System.out.println("Employee SSN: " + emp.getSsn());

        // Using setters
        emp.setSalary(60000.0f);
        emp.setName("Brahm Z");

        System.out.println("\nAfter Updating Details:");
        System.out.println("Employee Name: " + emp.getName());
        System.out.println("Employee Salary: " + emp.getSalary());
    }
}