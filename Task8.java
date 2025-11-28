/*
Create an integer method that 

returns the sum of all PARAMETERS,
for each parameter, ENDLESS?

if 4, 5, 10,
4 = 1+2+3+4
5 = 1+2+3+4+5
etc.

*/
public class Task8 {
    public static void main(String[] args) {
        int[] myArray = {95, 39, 52, 13, 77, 41, 39, 71, 98, 92, 21, 6, 25, 98, 92};

        adder(myArray);
    }

    public static void adder(int... number) {
        
        for (int n : number) {
            int subtotal = 0;
            for (int i = 0; i <= n; i++) {
                subtotal += i;
            }
            System.out.println(n + "'s total: " + subtotal);

        }
    }
}
