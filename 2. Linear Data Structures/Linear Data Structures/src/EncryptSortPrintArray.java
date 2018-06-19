import java.lang.reflect.Array;
import java.util.*;

public class EncryptSortPrintArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int numbersNames = Integer.parseInt(s.nextLine());

        List<Integer> sort = new ArrayList<>();

        for (int i = 0; i < numbersNames; i++) {
            String name = s.nextLine();
            boolean isVowel = false;
            int encr = 0;
            for (int j = 0; j < name.length(); j++) {
                char letter = name.charAt(j);
                isVowel = isVowel(letter);
                if (isVowel) {
                    encr += letter * name.length();
                } else {
                    encr += letter / name.length();
                }
            }
            sort.add(encr);
        }

        Collections.sort(sort);
        for (Integer integer : sort) {
            System.out.println(integer);
        }
    }

    public static boolean isVowel(char ch) {
        char[] vowels = {'a', 'e', 'o', 'u', 'i'};

        for (int i = 0; i < vowels.length; i++) {
            if (vowels[i] == Character.toLowerCase(ch)) {
                return true;
            }
        }
        return false;
    }
}
