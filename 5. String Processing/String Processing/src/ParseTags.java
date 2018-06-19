import java.util.Scanner;

public class ParseTags {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String text = s.nextLine();
        int startIndex = text.indexOf("<upcase>");

        while (startIndex != -1) {
            int endIndex = text.indexOf("</upcase>");
            String word = text.substring(startIndex + 7, endIndex);
            text = text.replace(word, word.toUpperCase());
            text = text.replaceFirst("<upcase>", "");
            text = text.replaceFirst("</upcase>", "");
            startIndex = text.indexOf("<upcase>");
        }
        System.out.println(text);
    }
}
