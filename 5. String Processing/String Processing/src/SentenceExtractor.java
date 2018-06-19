import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceExtractor {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String searchWord = s.nextLine();
        String text = s.nextLine();
        Pattern pattern = Pattern.compile("(^| )[^!.?]*\\b"+searchWord+"\\b.*?[.!?]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            System.out.println(matcher.group().trim());
        }
    }
}
