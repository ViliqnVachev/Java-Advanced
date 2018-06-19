import java.util.*;

public class SeriesOfLetters {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String text = s.nextLine();
        StringBuilder sb = new StringBuilder(text);

        int i = 0;
        int state = 0;
        while (i < sb.length() - 1)
            switch (state) {
                case 0:
                    if (sb.charAt(i) == sb.charAt(i + 1)) {
                        sb.deleteCharAt(i);
                        state = 0;
                    } else {
                        state = 1;
                    }
                    break;
                case 1:
                    i++;
                    state = 0;
                    break;
            }
        System.out.println(sb);
    }
}
