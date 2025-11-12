package SumOfAllIntegerInputs;

import java.util.Scanner;
public class SumOfAll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;

        while (true) {
            System.out.print("Enter an integer to add (-1 to exit): ");
            int intInput = sc.nextInt();

            if (intInput == -1) {
                break;
            }

            sum += intInput;
            System.out.println("Current sum: " + sum);
        }

        System.out.println("Total sum: " + sum);
    }
}
