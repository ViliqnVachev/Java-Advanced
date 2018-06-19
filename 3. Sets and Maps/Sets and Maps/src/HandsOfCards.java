import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Map<String, LinkedHashSet<String>> score = new LinkedHashMap<>();

        String[] line = s.nextLine().split(": ");

        while (!"JOKER".equals(line[0])) {
            String name = line[0];
            String[] temp = line[1].split(", ");
            LinkedHashSet<String> cards = new LinkedHashSet<>();
            Collections.addAll(cards, temp);

            if (!score.containsKey(name)) {
                score.put(name, cards);
            } else {
                LinkedHashSet<String> oldSet = score.get(name);
                oldSet.addAll(cards);
                score.put(name, oldSet);
            }
            line = s.nextLine().split(": ");
        }

        for (Map.Entry<String, LinkedHashSet<String>> entry : score.entrySet()) {
            int sum = 0;
            int number;
            int S = 4;
            int H = 3;
            int D = 2;
            int C = 1;
            for (String card : entry.getValue()) {
                char[] num = card.toCharArray();
                if (num.length == 3) {
                    number = 10;
                    if (num[num.length - 1] == 'S') {
                        sum = sum + (number * S);
                    } else if (num[num.length - 1] == 'H') {
                        sum = sum + (number * H);
                    } else if (num[num.length - 1] == 'D') {
                        sum = sum + (number * D);
                    } else if (num[num.length - 1] == 'C') {
                        sum = sum + (number * C);
                    }
                } else if (num.length < 3) {
                    String temp = num[0] + "";
                    if (temp.equals("A")) {
                        number = 14;
                    } else if (temp.equals("K")) {
                        number = 13;
                    } else if (temp.equals("Q")) {
                        number = 12;
                    } else if (temp.equals("J")) {
                        number = 11;
                    } else {
                        number = Integer.parseInt(temp);
                    }
                    if (num[num.length - 1] == 'S') {
                        sum = sum + (number * S);
                    } else if (num[num.length - 1] == 'H') {
                        sum = sum + (number * H);
                    } else if (num[num.length - 1] == 'D') {
                        sum = sum + (number * D);
                    } else if (num[num.length - 1] == 'C') {
                        sum = sum + (number * C);
                    }
                }

            }
            System.out.println(entry.getKey() + ": " + sum);
        }

    }
}
