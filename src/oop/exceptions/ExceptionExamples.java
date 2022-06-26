package oop.exceptions;

import java.io.*;

public class ExceptionExamples {

    public static void main(String[] args) {
        tryCatchExampleTwo(30, 0);
    }

    public static void checkException() throws FileNotFoundException {
        File file = new File("E://document.txt");
        FileReader fileReader = new FileReader(file);
    }

    public static void unCheckedException() {
        int[] num = {1, 2, 3, 4};
//        System.out.println(num[5]);
    }

    /**
     * Exception Methods
     * - public String getMessage
     * - public Throwable getCause
     * - public String toString
     * - public void printStackTrace
     * - public StackTraceElement[] getStackTrace
     * - public Throwable fillInStackStrace
     */

    private static void tryCatchExampleOne() {
        try {
            int[] elements = new int[2];
            System.out.printf("Accessing element three: %d", elements[3]);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Index does not exist : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void tryCatchExampleTwo(int x, int y) {
        try {
            int[] arr = new int[10];
            arr[79] = x / y;
        }
        catch (IndexOutOfBoundsException iex) {
            System.out.println("Out of Bounds exception");
        }
        catch (ArithmeticException aex) {
            System.out.println("Arithmetic exception");
        }
    }

}
