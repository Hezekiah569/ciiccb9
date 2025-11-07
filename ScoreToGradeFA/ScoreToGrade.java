package ScoreToGradeFA;
import java.util.Scanner;

public class ScoreToGrade {
    public static void main(String[] args) {
        Scanner rd = new Scanner(System.in);
        String gradeCategory;
        while (true) {
            System.out.print("STUDENT GRADE CHECKER\nProvide the student's grade (-1 to quit): ");
            int studentGrade = rd.nextInt();

            if (studentGrade == -1) {
                break;
            }

            if (studentGrade >= 90) {
                gradeCategory = "A";
            } else if (studentGrade >= 80) {
                gradeCategory = "B";
            } else if (studentGrade >= 70) {
                gradeCategory = "C";
            } else if (studentGrade >= 60) {
                gradeCategory = "D";
            } else {
                gradeCategory = "F";
            }
            System.out.println("Grade: " + gradeCategory + "\n");
        }

    }

}
