import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] input = s.nextLine().split(" ");
        char[] first = input[0].toCharArray();
        char[] second = input[1].toCharArray();
        Set<Character> fir = new LinkedHashSet<>();
        Set<Character> secon = new LinkedHashSet<>();
        for (char c : first) {
            fir.add(c);
        }
        for (char c : second) {
            secon.add(c);
        }
        if(fir.size()==secon.size()){
            System.out.println("true");
        }else {
            System.out.println("false");
        }


    }
}
