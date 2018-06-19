import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split("\\s+");
        BiPredicate<String, Integer> checkLength = (name, size) -> name.length() <= size;

        for (String name : names) {
            if (checkLength.test(name, length)) {
                System.out.println(name);
            }
        }
    }
}
