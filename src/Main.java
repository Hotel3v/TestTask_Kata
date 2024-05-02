import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);




    public static void main(String[] args) {

        System.out.println(calc(input.nextLine()));
    }
    public static String calc(String input) {

        String[] strings = input.split(" ");

        int num1; int num2; int indRomeNum = 0; int result = 0;
        var operation = strings[1];

        try {
            num1 = Integer.parseInt(strings[0]);
            num2 = Integer.parseInt(strings[2]);

        } catch (NumberFormatException e){

            num1 = romanToInt(strings[0]);
            num2 = romanToInt(strings[2]);
            indRomeNum = 1;
        }

        check(strings);

        if (operation.equals("+"))
        {
            result = num1 + num2;
        }
        if (operation.equals("-"))
        {
            result = num1 - num2;
        }
        if (operation.equals("*"))
        {
            result = num1 * num2;
        }
        if (operation.equals("/"))
        {
            result = num1 / num2;
        }

        if (indRomeNum == 1){
            if (result <= 0){
                throw new ArithmeticException();
            }
            return intToRoman(result);
        } else {
            return Integer.toString(result);
        }

    }

    static int romanToInt(String rom){

        var keys = new String[] { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        var vals = new int [] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int ind = -1;
        int num;

        for (num = 1; num < 10; num++)
        {
            ind++;

            if (rom.equals(keys[ind]))
                break;
        }

        return num;

    }

    static String intToRoman(int num)
    {


        var keys = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        var vals = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        StringBuilder ret = new StringBuilder();
        int ind = 0;

        while(ind < keys.length)
        {
            while(num >= vals[ind])
            {
                var d = num / vals[ind];
                num = num % vals[ind];
                for(int i=0; i<d; i++)
                    ret.append(keys[ind]);
            }
            ind++;
        }

        return ret.toString();
    }

    static void check(String[] strings)
    {
        var vals = new String[] { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                                  "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                                  "+", "-", "/", "*"};

        var rome = new String[] { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        var arab = new String [] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        int ind1 = 0; int ind2 = 0; int ind3 = 0;

        for (int i = 0; i <  vals.length; i++){
            if (strings[0].equals(vals[i])){
                ind1++;
            }
        }

        for (int i = 0; i <  vals.length; i++){
            if (strings[1].equals(vals[i])){
                ind1++;
            }
        }

        for (int i = 0; i <  vals.length; i++){
            if (strings[2].equals(vals[i])){
                ind1++;
            }
        }

        for (int i = 0; i <  10; i++)
        {
            if (strings[0].equals(rome[i]))
            {
                ind2++;
            }
            if (strings[2].equals(rome[i]))
            {
                ind2++;
            }

        }

        for (int i = 0; i <  10; i++)
        {
            if (strings[0].equals(arab[i]))
            {
                ind3++;
            }
            if (strings[2].equals(arab[i]))
            {
                ind3++;
            }

        }

        try
        {
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[2]);
            if (a == b){throw new NumberFormatException();}
        } catch (NumberFormatException e){}

        if (ind1 != 3)
        {
            throw new NumberFormatException();
        }

        if (ind1 == 3)
        {
            if (ind2 == ind3)
            {
                throw new NumberFormatException();
            }
        }

        if (strings.length > 3)
        {
            throw new NumberFormatException();
        }







    }
}







