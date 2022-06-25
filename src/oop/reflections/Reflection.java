package oop.reflections;

import oop.encapsulation.Supplier;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflection {

    private int scores;

    public static void main(String[] args) {

        try {
            Class<Supplier> myClass = Supplier.class;
            Method[] m = myClass.getDeclaredMethods();
            Constructor[] constructors = myClass.getConstructors();
            for (Constructor c : constructors) {
                System.out.printf("constructor Name:\t\t %s\n\n", c.getName());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void selfReflection() {
        try {
            Class<Reflection> myClass = Reflection.class;
            Method[] m = myClass.getDeclaredMethods();
            for (Method method : m) {
                System.out.printf("Method Name:\t\t %s\n\n", method.getName());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int addValues() {
        for (int i = 0; i < 5; i++) {
            scores += i;
        }
        return scores;
    }

    public int multiplyValues() {
        for (int i = 0; i < 5; i++) {
            scores *= i;
        }
        return scores;
    }

    public static void arrangeNumbers() {
        int length = 6;
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
