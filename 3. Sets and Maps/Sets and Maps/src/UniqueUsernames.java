import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int namesCount = Integer.parseInt(s.nextLine());
        Set<String> names = new LinkedHashSet<>();

        fillTheSet(s, namesCount, names);
        printTheSetValue(names);
    }

    private static void fillTheSet(Scanner s, int namesCount, Set<String> names) {
        for (int i = 0; i < namesCount; i++) {
            String name = s.nextLine();
            names.add(name);
        }
    }

    private static void printTheSetValue(Set<String> names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
}
