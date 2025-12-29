package com.logic;

public class App {
    public static void main(String[] args) {
        String str = "RADAR", reverseStr = "";
        for (int i = str.length() - 1; i >= 0; --i) {
            reverseStr += str.charAt(i);
        }
        if (str.equals(reverseStr)) {
            System.out.println(str + " is a Palindrome.");
        } else {
            System.out.println(str + " is not a Palindrome.");
        }
    }
}
