import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Set<Integer> numbersSet = new LinkedHashSet<>();
        for (int number : numbers) {
            numbersSet.add(number);
        }
        Function<Set<Integer>, Integer> smallestNumber = set -> {
            int smallestNum = Integer.MAX_VALUE;
            while (set.size() != 0) {
                int temp = set.iterator().next();
                set.remove(temp);
                if (temp < smallestNum) {
                    smallestNum = temp;
                }
            }
            return smallestNum;
        };

        System.out.println(smallestNumber.apply(numbersSet));
    }
}
