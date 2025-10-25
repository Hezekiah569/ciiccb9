import java.util.Scanner;

public class GradeCount {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gradeInput;

        while (true) {
            System.out.print("Input grade (-1 to exit): ");
            gradeInput = sc.nextInt();

            if (gradeInput == -1) {
                break;
            }
            if (gradeInput >= 90) {
                System.out.println("A");
            } else if (gradeInput >= 80) {
                System.out.println("B");
            } else if (gradeInput >= 70) {
                System.out.println("C");
            } else if (gradeInput >= 60) {
                System.out.println("D");
            } else {
                System.out.println("F");
            }
        }

    }
}
