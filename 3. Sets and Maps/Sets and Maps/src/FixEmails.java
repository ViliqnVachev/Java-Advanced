import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Map<String, String> map = new LinkedHashMap<>();
        String line = s.nextLine();
        int count = 1;
        String name = "";

        fillTheMap(s, map, line, count, name);

        printKeyValuePairs(map);
    }

    private static void fillTheMap(Scanner s, Map<String, String> map, String line, int count, String name) {
        while (!"stop".equals(line)) {
            if (count % 2 != 0) {
                name = line;
                if (!map.containsKey(name)) {
                    map.put(name, "");
                }
            } else {
                String email = line.toLowerCase();
                if (email.endsWith(".us") || email.endsWith(".uk") || email.endsWith(".com")) {
                    map.remove(name);
                } else {

                    map.put(name, line);
                }

            }
            count++;
            line = s.nextLine();
        }
    }

    private static void printKeyValuePairs(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
