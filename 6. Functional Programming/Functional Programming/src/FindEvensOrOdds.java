import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] bound = reader.readLine().split(" ");
        int start = Integer.parseInt(bound[0]);
        int end = Integer.parseInt(bound[1]);
        String type = reader.readLine();
        List<Integer> numbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            numbers.add(i);
        }

        BiConsumer<List<Integer>, String> printTypeOfNumbers = (num, typeOfNumber) -> {
            switch (typeOfNumber) {
                case "even":
                    for (Integer integer : num) {
                        if (integer % 2 == 0) {
                            System.out.print(integer + " ");
                        }
                    }
                    break;
                default:
                    for (Integer integer : num) {
                        if (integer % 2 != 0) {
                            System.out.print(integer + " ");
                        }
                    }
                    break;
            }
        };

        printTypeOfNumbers.accept(numbers, type);
    }
}
