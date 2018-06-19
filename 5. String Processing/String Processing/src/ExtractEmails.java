import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String text = s.nextLine();
        Pattern pattern = Pattern.compile("(^|(?<=\\s))[a-z0-9]+[-\\._]?[a-z0-9]+@[a-z]+[-]?[a-z]*[\\.]?[a-z]*[.][a-z]+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
