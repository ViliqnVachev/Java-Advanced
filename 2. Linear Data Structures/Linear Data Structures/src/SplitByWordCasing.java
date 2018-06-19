import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SplitByWordCasing {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] allWords = Arrays.stream(s.nextLine().split("[\\\\,:;.!()\"'/\\[\\]\\s]+"))
                .filter(w -> w.length() > 0)
                .toArray(String[]::new);

        List<String> lowerCase = new ArrayList<>();
        List<String> upperCase = new ArrayList<>();
        List<String> mixedCase = new ArrayList<>();

        for (int i = 0; i < allWords.length; i++) {
            String word = allWords[i];
            if (isUpperCase(word)) {
                upperCase.add(word);
            } else if (isLowerCase(word)) {
                lowerCase.add(word);
            } else {
                mixedCase.add(word);
            }
        }
        System.out.println("Lower-case: " + String.join(", ", lowerCase));
        System.out.println("Mixed-case: " + String.join(", ", mixedCase));
        System.out.println("Upper-case: " + String.join(", ", upperCase));
    }

    public static boolean isLowerCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (letter < 'a' || letter > 'z') {
                return false;
            }
        }
        return true;
    }

    public static boolean isUpperCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (letter < 'A' || letter > 'Z') {
                return false;
            }
        }
        return true;
    }
}
