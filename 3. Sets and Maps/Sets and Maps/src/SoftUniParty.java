import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<String> invited = new TreeSet<>();

        String line;
        while (!"END".equals(line = s.nextLine())) {
            if ("PARTY".equals(line)) {
                while (!"END".equals(line)) {
                    invited.remove(line);
                    line = s.nextLine();
                }
                break;
            } else {
                invited.add(line);
            }

        }

        System.out.println(invited.size());
        for (String s1 : invited) {
            System.out.println(s1);
        }
    }
}
