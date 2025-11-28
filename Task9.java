/*

*/

import static java.lang.Math.*;

public class Task9 {

    public static int add(int a, int b) {
        int sum = Math.addExact(a, b);
        return sum;
    }

    public static int subtract(int a, int b) {
        int difference = Math.subtractExact(a, b);
        return difference;
    }

    public static int multiply(int a, int b) {
        int product = Math.multiplyExact(a, b);
        return product;
    }

    public static float divide(int a, int b) {
        float quotient = Math.floorDiv(a, b);
        return quotient;
    }
    public static void main(String[] args) {
        System.out.println("Safe Addition Demo: " + add(75, 70));
        System.out.println("Safe Subtraction Demo: " + subtract(69, 22));
        System.out.println("Safe Multiplication Demo: " + multiply(67, 89));
        System.out.println("Safe Division Demo: " + divide(100, 3));
    }
}
