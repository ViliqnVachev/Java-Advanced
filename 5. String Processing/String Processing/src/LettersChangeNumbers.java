import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] intput = s.nextLine().split("\\s+");
        double result = 0;

        for (int i = 0; i < intput.length; i++) {
            String temp = intput[i];
            char firstLetter = temp.charAt(0);
            double number = Double.parseDouble(temp.substring(1, temp.length() - 1));
            char lastLetter = temp.charAt(temp.length() - 1);
            double sum = 0;

            if (firstLetter >= 'A' && firstLetter <= 'Z') {
                sum = number / (firstLetter - 64);
            } else if (firstLetter >= 'a' && firstLetter <= 'z') {

                sum = number *( firstLetter - 96);
            }
            if (lastLetter >= 'A' && lastLetter <= 'Z') {

                sum = sum - (lastLetter-64);
            } else if(lastLetter >= 'a' && lastLetter <= 'z') {

                sum = sum + (lastLetter-96);
            }
            result += sum;
        }
        System.out.printf("%.2f", result);
    }
}
