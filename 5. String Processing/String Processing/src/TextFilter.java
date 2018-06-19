import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] replaceWords = s.nextLine().split(", ");
        String text = s.nextLine();

        for (String replaceWord : replaceWords) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < replaceWord.length(); j++) {
                sb.append("*");
            }
            text = text.replace(replaceWord, sb);
        }
        System.out.println(text);
    }
}
