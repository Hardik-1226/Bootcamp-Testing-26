package com.ExceptionHandling;

import java.io.IOException;
import java.util.Scanner;

public class E {

    int x, y;

    public void accept() throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two values");

        x = sc.nextInt();
        y = sc.nextInt();
    }

    public void display() {

        int result = x + y;

        System.out.println("Addition = " + result);
    }

    public static void main(String ar[]) {

        E ce = new E();

        try {
            ce.accept();
        } catch (IOException ie) {
            System.out.println(ie);
        }

        ce.display();
    }
}