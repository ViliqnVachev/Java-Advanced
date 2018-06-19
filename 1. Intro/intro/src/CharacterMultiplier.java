import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String first = s.next();
        String second = s.next();

        int totalSum = 0;

        int lenght = Math.min(first.length(), second.length());


        for (int i = 0; i < lenght; i++) {
            int a = first.charAt(i);
            int b = second.charAt(i);

            totalSum += a * b;
        }
        first = first.substring(lenght);
        second = second.substring(lenght);
        if (first.length() > 0) {
            for (int i = 0; i < first.length(); i++) {
                int a = first.charAt(i);
                totalSum += a;
            }
            System.out.println(totalSum);

        } else if (second.length() > 0) {
            for (int i = 0; i < second.length(); i++) {
                int a = second.charAt(i);
                totalSum += a;
            }
            System.out.println(totalSum);
        } else {

            System.out.println(totalSum);
        }
    }
}
