import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Consumer<String> printer = text -> {
            String[] splitedWords = text.split("\\s+");
            for (String splitedWord : splitedWords) {
                System.out.println(splitedWord);
            }
        };
        printer.accept(input);
    }
}
