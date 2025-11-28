import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the first number: ");
        int firstInt = sc.nextInt();

        System.out.print("Input the second number: ");
        int secondInt = sc.nextInt();

        System.out.println("SUM: " + addition(firstInt, secondInt));
        System.out.println("DIFFERENCE: " + subtraction(firstInt, secondInt));
        System.out.println("PRODUCT: " + product(firstInt, secondInt));
        System.out.println("QUOTIENT: " + quotient(firstInt, secondInt));
    }

    public static int addition(int addendOne, int addendTwo) {
        int sum = addendOne + addendTwo;
        return sum;
    }

    public static int subtraction(int subtrahend, int minuend) {
        int difference = subtrahend - minuend;
        return difference;
    }

    public static int product(int multiplicand, int multiplier) {
        int product = multiplicand * multiplier;
        return product;
    }

    public static int quotient(int dividend, int divider) {
        int quotient = dividend / divider;
        return quotient;
    }
}
