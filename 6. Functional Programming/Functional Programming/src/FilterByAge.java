import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());
        Map<String, Integer> people = new LinkedHashMap<>();


        while (count != 0) {
            String[] input = reader.readLine().split(", ");
            people.putIfAbsent(input[0], Integer.parseInt(input[1]));
            count--;
        }

        String condition = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        Predicate<Integer> conditionFunct = condition(condition, age);
        for (Map.Entry<String, Integer> entry : people.entrySet()) {
            if (conditionFunct.test(entry.getValue())) {
                getPrint(format, entry).accept(entry);
            }
        }

    }

    private static Consumer<Map.Entry<String, Integer>> getPrint(String format, Map.Entry<String, Integer> entry) {
        if ("name".equals(format)) {
            return e -> System.out.printf("%s%n", e.getKey());
        } else if ("age".equals(format)) {
            return e -> System.out.printf("%d%n", e.getValue());
        }
        return e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue());
    }

    private static Predicate<Integer> condition(String condition, int age) {
        if ("younger".equals(condition)) {
            return x -> x < age;
        } else {
            return x -> x >= age;
        }
    }
}
