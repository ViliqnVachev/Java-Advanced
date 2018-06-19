import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double[] prices = Arrays.stream(reader.readLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Function<double[], double[]> addVat = arr -> {
            double[] temp = new double[arr.length];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i] * 1.20;
            }
            return temp;
        };
        double[] finalPrice = addVat.apply(prices);
        System.out.println("Prices with VAT:");
        Consumer<double[]> printer = num -> {
            for (Double a : num) {
                System.out.printf("%.2f%n", a);
            }
        };
        printer.accept(finalPrice);

    }
}
