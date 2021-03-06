import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> bounds = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = numbers.stream()
                .filter(x -> x >= bounds.get(0) && x <= bounds.get(1))
                .collect(Collectors.toList());
        result.forEach(x -> System.out.print(x + " "));
    }
}
