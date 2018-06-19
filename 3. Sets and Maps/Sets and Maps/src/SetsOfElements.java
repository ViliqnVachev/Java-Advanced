import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();

        String[] lenghtOfSets = s.nextLine().split("\\s+");

        int firstSetLenght = Integer.parseInt(lenghtOfSets[0]);
        int secondSetLenght = Integer.parseInt(lenghtOfSets[1]);

        for (int i = 0; i < firstSetLenght; i++) {
            int number = Integer.parseInt(s.nextLine());
            first.add(number);
        }
        for (int i = 0; i < secondSetLenght; i++) {
            int number = Integer.parseInt(s.nextLine());
            second.add(number);
        }

        int size = Math.min(first.size(), second.size());
        int a = first.size();
        int b = second.size();
        for (int i = 0; i < size; i++) {
            if (a < b) {
                int number = first.iterator().next();
                if (second.contains(number)) {
                    System.out.print(number + " ");
                }
                first.remove(number);
            } else {
                int number = second.iterator().next();
                if (first.contains(number)) {
                    System.out.print(number + " ");
                }
                second.remove(number);
            }
        }

    }
}
