import java.util.*;

public class VoinaNumbergame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<Integer> firstPlayed = new LinkedHashSet<>();
        Set<Integer> secondPlayed = new LinkedHashSet<>();

        int[] first = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < first.length; i++) {
            firstPlayed.add(first[i]);
        }
        int[] second = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < second.length; i++) {
            secondPlayed.add(second[i]);
        }

        int round = 1;
        while (round != 50) {
            if (firstPlayed.isEmpty() || secondPlayed.isEmpty()) {
                System.out.println(firstPlayed.isEmpty() ? "Seond player win!" : "First player win!");
                return;
            }

            int num1 = firstPlayed.iterator().next();
            firstPlayed.remove(num1);
            int num2 = secondPlayed.iterator().next();
            secondPlayed.remove(num2);
            if (num1 > num2) {
                firstPlayed.add(num1);
                firstPlayed.add(num2);
            } else if (num1 < num2) {
                secondPlayed.add(num1);
                secondPlayed.add(num2);
            }
            round++;
        }

        if (firstPlayed.size() == secondPlayed.size()) {
            System.out.println("Draw!");
        } else if (firstPlayed.size() > secondPlayed.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }

    }
}
