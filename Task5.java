import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the first number: ");
        int firstInt = sc.nextInt();

        System.out.print("Input the second number: ");
        int secondInt = sc.nextInt();

        System.out.print("Input the third number: ");
        int thirdInt = sc.nextInt();

        if (firstInt > secondInt && firstInt > thirdInt) {
            System.out.println(firstInt + " is the largest number");
        } else if (secondInt > firstInt && secondInt > thirdInt) {
            System.out.println(secondInt + " is the largest number.");
        } else if (thirdInt > firstInt && thirdInt > secondInt) {
            System.out.println(thirdInt + " is the largest number.");
        } else {
            System.out.println("All numbers are equal.");
        }
    }
}
