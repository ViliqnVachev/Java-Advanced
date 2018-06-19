import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\+[359]+([\\s-])2(\\1)[0-9]{3}(\\1)[0-9]{4}$");
        String numbers = s.nextLine();
        while (!"end".equals(numbers)) {
            Matcher matcher=pattern.matcher(numbers);
            if(matcher.find()){
                System.out.println(matcher.group());
            }
            numbers = s.nextLine();
        }
    }
}
