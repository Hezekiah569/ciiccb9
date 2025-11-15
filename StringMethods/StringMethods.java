package StringMethods;

import java.util.Scanner;

public class StringMethods {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String userInput = "This is just a test.";

        System.out.println(userInput.toUpperCase());
        System.out.println(userInput.toLowerCase());
        System.out.println(userInput.charAt(0));
        System.out.println(userInput.charAt(userInput.length() - 1));
        System.out.println(userInput.substring(1, 4));
    }
}
