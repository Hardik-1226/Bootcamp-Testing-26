package com.ExceptionHandling;

public class G {

    public static void main(String[] args) {

        try {

            int StudentID[] = new int[2];

            StudentID[0] = 15103022;
            StudentID[1] = 16103762;
            StudentID[2] = 13203022;
            StudentID[3] = 10653222;
            StudentID[4] = 19823022;

            System.out.println(StudentID[3]);
        }

        catch (ArithmeticException e) {

            System.out.println("Arithmetic Exception occurs");
        }

        catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Array Index OutOfBounds Exception occurs");
        }

        catch (Exception e) {

            System.out.println("Parent Exception occurs");
        }

        System.out.println("rest of the code");
    }
}