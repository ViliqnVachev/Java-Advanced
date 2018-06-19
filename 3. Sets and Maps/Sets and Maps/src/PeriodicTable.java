import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        Set<String> chemical = new TreeSet<>();

        fillTheSet(s, n, chemical);
        printElements(chemical);
    }

    private static void printElements(Set<String> chemical) {
        for (String element : chemical) {
            System.out.print(element + " ");
        }
    }

    private static void fillTheSet(Scanner s, int n, Set<String> chemical) {
        for (int i = 0; i < n; i++) {
            String[] elements = s.nextLine().split("\\s+");
            chemical.addAll(Arrays.asList(elements));
        }
    }
}
