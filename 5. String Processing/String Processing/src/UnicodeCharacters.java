import java.util.Scanner;

public class UnicodeCharacters {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String text = s.nextLine();
        StringBuilder sb = new StringBuilder(text);
        for (int i = 0; i < sb.length(); i++) {
            System.out.print(String.format("\\u%04x", (int) sb.charAt(i)));
        }

    }
}
