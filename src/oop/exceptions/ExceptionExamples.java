package oop.exceptions;

import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ExceptionExamples {

    public static void main(String[] args) {
        ExceptionExamples exceptionExamples = new ExceptionExamples();
        exceptionExamples.bankingSystem();
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
    
    public void bankingSystemV2() {

    }

    public void bankingSystem() {
//        int totalAmountDeposited = totalDeposited(0.00);
//        int totalAmountDeposited2 = totalDeposited(400.00);
//        checker(30, 5);

        double balance = 0.00;
        try {
            balance = withdrawFromAccount(90.00, 20.00);
            System.out.printf("Tried %f \n", balance);
        }
//        catch (ArithmeticException ex) {
//            balance = 20.00;
//            System.out.printf("Caught %f \n", balance);
//        }
        finally {
            balance /= 2;
            System.out.printf("Afterwards %f \n", balance);
        }

        System.out.printf("Your current balance is %f \n", balance);
    }

    private int totalDeposited(double amount) throws ArithmeticException {
        if (0.00 == amount) {
            throw new ArithmeticException("You cannot pass in the value of 0");
        }
        return (int) (amount * 2);
    }

    private double withdrawFromAccount(double amount, double fixedCharge) {
        int total = totalDeposited(fixedCharge);
        if (total < amount) {
            throw new ArithmeticException("Please enter a valid amount : Insufficient Funds!");
        }
        return total - amount;
    }

    private void checker(int x, int y) throws ArrayIndexOutOfBoundsException {
        int size = 70;
        ArrayList<Integer> m = new ArrayList<>();
        m.add(0, 5);
        m.add(1, 55);
        m.add(2, 555);
        m.add(3, 5555);
        int[] arr = new int[size];
        int index = 79;
        if (m.size() > 0) {
            throw new ArrayIndexOutOfBoundsException("Please check your code and continue");
        }
        arr[index] = x / y;
    }

}
