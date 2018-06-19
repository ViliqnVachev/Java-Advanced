import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelCount {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String text = s.nextLine();

        Pattern pattern = Pattern.compile("[AEOUYIaeouyi]");
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println("Vowels: " + count);
    }
}
