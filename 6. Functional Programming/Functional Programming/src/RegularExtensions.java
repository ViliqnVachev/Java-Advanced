import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExtensions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        String pattern = reader.readLine();
        while (!"Print".equals(pattern)) {
            if (pattern.startsWith("%")) {
                pattern = pattern.substring(1);
            } else if (pattern.contains("%")) {
                pattern = pattern.replaceAll("%", "[A-Za-z]+");
            }else if(pattern.startsWith(".")){
                pattern = pattern.replaceFirst(".", "\\\\.");
            }
            Pattern pattern1 = Pattern.compile(pattern);
            Matcher matcher = pattern1.matcher(text);
            while (matcher.find()) {
                String temp = matcher.group();
                StringBuilder sb = new StringBuilder(temp).reverse();
                // temp = sb.toString();
                text = text.replaceAll(temp, sb.toString());
            }

            pattern = reader.readLine();
        }

        System.out.println(text);
    }
}
