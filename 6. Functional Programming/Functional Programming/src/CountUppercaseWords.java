import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] text = reader.readLine().split("\\s+");
        List<String> upperCaseWords = new ArrayList<>();

        Predicate<String> isUpperCaseWords = word -> {

            return word.charAt(0) == word.toUpperCase().charAt(0);
        };

        for (String s : text) {
            if (isUpperCaseWords.test(s)) {
                upperCaseWords.add(s);
            }
        }
        System.out.println(upperCaseWords.size());
        upperCaseWords.forEach(System.out::println);
    }
}
