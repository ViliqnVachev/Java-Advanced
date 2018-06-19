import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Long> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        String command = reader.readLine();
        Consumer<List<Long>> print = list -> list.forEach(e -> System.out.print(e + " "));
        BiFunction<List<Long>, String, List<Long>> operationFunc = (arr, type) -> {
            List<Long> list = new ArrayList<>();
            switch (type) {
                case "add":
                    for (Long integer : arr) {
                        list.add(integer + 1);
                    }
                    return list;
                case "multiply":
                    for (Long integer : arr) {
                        list.add(integer * 2);
                    }
                    return list;
                case "subtract":
                    for (Long integer : arr) {
                        list.add(integer - 1);
                    }
                    return list;
                default:
                    return null;
            }
        };
        while (!"end".equals(command)) {
            if (!"print".equals(command)) {
                numbers = operationFunc.apply(numbers, command);
            } else {
                print.accept(numbers);
                System.out.println();
            }

            command = reader.readLine();
        }
    }
}
