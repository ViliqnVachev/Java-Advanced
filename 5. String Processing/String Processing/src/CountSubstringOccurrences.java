import java.util.Scanner;

public class CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String text = s.nextLine().toLowerCase();
        String search = s.nextLine().toLowerCase();

        int count = 0;
        int index = -1;

        while (true) {
            index = text.indexOf(search, index + 1);
            if (index == -1) {
                break;
            } else {
                count++;
            }
        }
        System.out.println(count);
    }
}
