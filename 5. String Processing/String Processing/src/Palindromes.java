import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Palindromes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] text = s.nextLine().split("[!?,\\s.]+");
        Set<String> palindrome = new TreeSet<>();

        String temp = "";
        for (String aText : text) {
            temp = aText;
            StringBuilder sb = new StringBuilder(temp).reverse();
            if (temp.equals(sb.toString())) {
                palindrome.add(temp);
            }
        }
        System.out.println("[" + String.join(", ", palindrome) + "]");
    }
}
