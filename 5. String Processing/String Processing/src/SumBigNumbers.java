import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String firstNumber = s.nextLine();
        String secondNumber = s.nextLine();

        StringBuilder second = new StringBuilder(secondNumber);
        StringBuilder first = new StringBuilder(firstNumber);
        if (firstNumber.length() > secondNumber.length()) {
            second.reverse();
            for (int i = secondNumber.length(); i < firstNumber.length(); i++) {
                second.append("0");
            }
            second.reverse();
        } else {
            first.reverse();
            for (int i = firstNumber.length(); i < secondNumber.length(); i++) {
                first.append("0");
            }
            first.reverse();
        }

        StringBuilder result = new StringBuilder();
        int sum = 0;
        int reminder = 0;
        for (int i = first.length() - 1; i >= 0; i--) {
            int a = Integer.parseInt(first.charAt(i) + "");
            int b = Integer.parseInt(second.charAt(i) + "");
            sum = a + b + reminder;
            if (sum > 9) {
                sum = sum % 10;
                reminder = 1;
                result.append(sum);
            } else {
                reminder = 0;
                result.append(sum);
            }
        }

        if (reminder == 1) {
            result.append(reminder);
        }
        result.reverse();
        String finalResult=result.toString();
        finalResult=finalResult.replaceFirst("^0+(?!$)", "");

        System.out.println(finalResult);
    }
}
