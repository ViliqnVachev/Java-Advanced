import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String tokens = s.nextLine();
        Map<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < tokens.length(); i++) {
            char ch = tokens.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 0);
            }
            map.put(ch, map.get(ch) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }
}
