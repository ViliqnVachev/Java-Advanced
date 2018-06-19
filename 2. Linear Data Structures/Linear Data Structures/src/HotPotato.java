import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] kids = s.nextLine().split("\\s+");
        int n = Integer.parseInt(s.nextLine());

        Deque<String> queu = new ArrayDeque<>();

        Collections.addAll(queu, kids);
        while (queu.size()>1){
            for (int i = 1; i < n; i++) {
                queu.offer(queu.poll());
            }
            System.out.println("Removed "+queu.poll());
        }
        System.out.println("Last is "+queu.poll());
    }
}
