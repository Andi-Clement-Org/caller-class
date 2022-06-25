package oop.recursion;

public class Base {

    public static boolean isPalindromeRecursive(String s) {
        if (s.length() == 0 || s.length() == 1) return true;
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
        System.out.printf("Text Value: %s", s.substring(1, s.length() -1));
        System.out.println();
        return isPalindromeRecursive(s.substring(1, s.length() -1));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder reversed = new StringBuilder();
        for (int i = (s.length() - 1); i >=0 ; --i) reversed.append(s.charAt(i));
        return s.equalsIgnoreCase(reversed.toString());
    }

    public static boolean isPalindrome(String s, int i) {
        return false;
    }

}
