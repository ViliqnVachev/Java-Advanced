import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class GameOfNames {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int playersNumber = Integer.parseInt(s.nextLine());

        int maxScore = Integer.MIN_VALUE;
        String winner = "";
        for (int i = 0; i < playersNumber; i++) {
            String name = s.next();
            int points = s.nextInt();
            s.nextLine();

            for (int j = 0; j < name.length(); j++) {
                int ch = name.charAt(j);
                if (ch % 2 == 0) {
                    points += ch;
                } else {
                    points -= ch;
                }
            }
            if (maxScore < points) {
                maxScore = points;
                winner = name;
            }
        }


        if (maxScore != 0) {

            System.out.printf("The winner is %s - %d points", winner, maxScore);
        }
    }
}
