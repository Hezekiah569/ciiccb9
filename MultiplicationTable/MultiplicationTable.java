package MultiplicationTable;

public class MultiplicationTable {
    public static void main(String[] args) {
        for (int multiplicand = 1; multiplicand <= 10; multiplicand++) {
            System.out.println("\nMultiplication Table for " + multiplicand + "\n");
            for (int multiplier = 1; multiplier <= 10; multiplier++) {
                int product = multiplicand * multiplier;
                System.out.println(multiplicand + " x " + multiplier + " = " + product);
            }
        }
    }
}
