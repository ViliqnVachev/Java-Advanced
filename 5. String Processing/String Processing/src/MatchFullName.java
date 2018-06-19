import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^([A-Z][a-z]+) ([A-Z][a-z]+)$");

        String name = s.nextLine();
        while (!"end".equals(name)) {
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                System.out.println(name);
            }
            name = s.nextLine();
        }
    }
}
