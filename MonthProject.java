/*
> prompt user to enter a month:
1 - 12
output: number of days in that month.
output: february only has 28 days.
use a switch-case statement

import scanner

initialize class
initialize main method
inside main method:
    instantiate Scanner sc
    declare month: int

    switch(month) {
        case 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 -> "30 days";
        case 2 -> "28 days";
    }
 */

import java.util.Scanner;

public class MonthProject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month;

        System.out.print("Enter month: ");
        month = sc.nextInt();

        int numberOfDays = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;

            case 2 -> 28;
            case 4, 6, 9, 11 -> 30;
            default ->
                throw new IllegalStateException("Invalid month: " + month);
        };
        System.out.println("Month Number: " + month + "\nNumber of days: " + numberOfDays);
    }
}