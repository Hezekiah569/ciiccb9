import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print("Input the word to check if it is a palindrome (-1 to exit): ");
            String palindromeInput = sc.nextLine().replace(" ", ""); 

            if (palindromeInput.equals("-1")) {
                System.out.println("Thank you for using the Palindrome App! Bye!");
                break;
            }

            StringBuilder palindromeTransformer = new StringBuilder(palindromeInput);
            String reversedPalindrome = palindromeTransformer.reverse().toString();

            if (palindromeInput.equalsIgnoreCase(reversedPalindrome)) {
                System.out.println("The input string is a palindrome.");
            } else {
                System.out.println("The input string is not a palindrome.");
            }
        }

    }
}
