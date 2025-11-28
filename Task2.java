public class Task2 {
    public static void main(String[] args) {
        byte valByte = 1;
        short valShort = 0;
        int valInt = 3;
        short valShortTwo = 2;
        char valChar = 'H';
        char valCharTwo = 'w';
        char valCharThree = 'r';
        char valCharFour = 'd';
        char valPeriod = '.';
        boolean valBool = true;

        String output = valChar + Integer.toString(valInt) + valByte + valByte + Short.toString(valShort) + " " + Character.toString(valCharTwo) + Short.toString(valShort) + valCharThree + valByte + valCharFour + " " + Short.toString(valShortTwo) + valPeriod + Short.toString(valShort) + " " + Boolean.toString(valBool);

        System.out.println(output);


    }
}
