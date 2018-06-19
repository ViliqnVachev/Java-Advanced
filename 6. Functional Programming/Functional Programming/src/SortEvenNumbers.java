import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        numbers.removeIf(num -> num % 2 != 0);
        printElementsofList(numbers);
        numbers.sort((a,b)->a.compareTo(b));
        printElementsofList(numbers);
    }

    private static void printElementsofList(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i == numbers.size() - 1) {
                System.out.println(numbers.get(i));
                break;
            }
            System.out.print(numbers.get(i) + ", ");
        }
    }
}
