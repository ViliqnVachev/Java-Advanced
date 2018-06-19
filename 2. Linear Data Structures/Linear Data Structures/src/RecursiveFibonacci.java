import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        Deque<Long> queue = new ArrayDeque<>();
        long a = 0;
        long b = 0;
        long c = 0;

        if (n == 1) {
            System.out.println(1);
            return;

        } else if (n == 2) {
            System.out.println(1);
            return;

        } else {
            a = 1;
            b = 1;
        }
        queue.add(c);
        for (int i = 2; i < n + 1; i++) {
            c = queue.poll();
            c = a + b;
            a = b;
            b = c;
            queue.add(c);
        }
        System.out.println(queue.poll());

    }
}
