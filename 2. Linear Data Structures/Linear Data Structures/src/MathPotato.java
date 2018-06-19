import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] kids = s.nextLine().split("\\s+");
        int n = Integer.parseInt(s.nextLine());

        Deque<String> queu = new ArrayDeque<>();

        Collections.addAll(queu, kids);
        int cycle = 1;
        while (queu.size() > 1) {

            for (int i = 1; i < n; i++) {
                queu.offer(queu.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + queu.peek());
            } else {
                System.out.println("Removed " + queu.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queu.poll());
    }

    private static boolean isPrime(int cycle) {
        int temp;
        boolean isPrime = true;
        if (cycle == 1) {
            return false;
        }
        for (int i = 2; i <= cycle / 2 ; i++) {
            temp = cycle % i;
            if (temp == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
