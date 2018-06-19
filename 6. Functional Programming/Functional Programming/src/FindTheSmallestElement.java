import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Function<List<Integer>, Integer> smallestElementIndex = list -> {
            int index = 0;
            int smallestElement = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
                if (smallestElement >= list.get(i)) {
                    smallestElement = list.get(i);
                    index = i;
                }
            }
            return index;
        };
        System.out.println(smallestElementIndex.apply(numbers));
    }
}
