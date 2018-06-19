import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().split(", ");

        Function<String[], int[]> func = strNumbers -> {
            int[] intNumbers = new int[strNumbers.length];
            for (int i = 0; i < strNumbers.length; i++) {
                intNumbers[i] = Integer.parseInt(strNumbers[i]);
            }
            return intNumbers;
        };

        int[] parsedNumbers = func.apply(numbers);

        Function<int[], Integer> countFunc = arr -> arr.length;
        int count = countFunc.apply(parsedNumbers);

        Function<int[], Integer> sumFunc = arr -> {
            int s = 0;
            for (int i : arr) {
                s += i;
            }
            return s;
        };

        int sum = sumFunc.apply(parsedNumbers);

        System.out.println("Count = " + count);
        System.out.println("Sum = " + sum);

    }
}
