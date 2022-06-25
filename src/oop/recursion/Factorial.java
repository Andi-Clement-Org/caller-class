package oop.recursion;

public class Factorial {

    private static int count = 0;

    public static int findFactorial(int n) {
        if (n == 0) return 1;
        return n * findFactorial(n - 1);
    }

    public static int find(int n) {
        if (n != 0) {
            return n * n - count;
        }
        else {
            return 1;
        }
    }

    public static void findFactorial() {
        int size = 6;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            count ++;
            int res = find(i);
            sum += res;
        }
        System.out.println(sum);
    }

}
