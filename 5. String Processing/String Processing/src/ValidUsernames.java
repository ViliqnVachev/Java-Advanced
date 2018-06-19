import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        Pattern pattern = Pattern.compile("^[\\w-]{3,16}$");
        List<String> temp = new ArrayList<>();
        while (!"END".equals(line)) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                temp.add("valid");
            } else {
                temp.add("invalid");
            }

            line = s.nextLine();
        }
        if (temp.contains("valid")) {
            for (String s1 : temp) {
                System.out.println(s1);
            }
        }
    }
}
