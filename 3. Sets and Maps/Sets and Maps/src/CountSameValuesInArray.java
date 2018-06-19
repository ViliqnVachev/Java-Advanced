import java.util.*;

public class CountSameValuesInArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Map<String, Integer> numbers = new HashMap<>();
        String[] tokens = s.nextLine().split(" ");

        for (String token : tokens) {
            if (!numbers.containsKey(token)) {
                numbers.put(token, 0);
            }
            numbers.put(token, numbers.get(token) + 1);
        }

        for (Map.Entry<String, Integer> entry : numbers.entrySet()) {
            System.out.printf("%s - %d times%n", entry.getKey(), entry.getValue());
        }
    }
}
