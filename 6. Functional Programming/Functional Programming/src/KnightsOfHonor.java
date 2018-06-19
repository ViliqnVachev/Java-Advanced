import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] names = reader.readLine().split("\\s+");

        Consumer<String[]> printer = arr -> {
            String temp = "Sir";
            for (String s : arr) {
                System.out.println(temp + " " + s);
            }
        };

        printer.accept(names);

    }
}
