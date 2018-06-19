import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int range = Integer.parseInt(reader.readLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= range; i++) {
            numbers.add(i);
        }
        int[] divisorsString = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> divisors = new LinkedHashSet<>();
        for (Integer divisor : divisorsString) {
            divisors.add(divisor);
        }

        Predicate<Integer> isDivisible = num -> {
            for (Integer number : divisors) {
                if (num % number != 0) {
                    return false;
                }
            }
            return true;
        };

        for (Integer number : numbers) {
            if (isDivisible.test(number)) {
                System.out.print(number + " ");

            }
        }

    }
}
