import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> oddNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 != 0) {
                oddNumbers.add(numbers.get(i));
                numbers.remove(numbers.get(i));
                i--;
            }

        }
        numbers.sort(Integer::compareTo);
        oddNumbers.sort(Integer::compareTo);
        numbers.addAll(oddNumbers);
        numbers.forEach(e -> System.out.print(e + " "));
    }
}
