package WordCounter;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter words to count (-1 to exit): ");
            String input = sc.nextLine();

            if (input.equals("-1")) {
                System.out.println("Thank you for using the word counter!");
                break;
            }

            int countedLen = input.length();

            System.out.println("Total length of the word \"" + input + "\" is: " + countedLen);
        }
    }
}