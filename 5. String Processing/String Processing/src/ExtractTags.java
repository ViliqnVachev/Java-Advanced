import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractTags {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        Pattern pattern = Pattern.compile("<.*?>");

        while (!"END".equals(line)) {

            Matcher matcher=pattern.matcher(line);
            while (matcher.find()){
                System.out.println(matcher.group());
            }

            line = s.nextLine();
        }

    }
}
