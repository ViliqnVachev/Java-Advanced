import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] input = s.nextLine().split(" ");

        ArrayDeque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack, input);

        while (stack.size() > 1) {
            int a = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int b = Integer.parseInt(stack.pop());

            if (op.equals("+")) {
                String sum = a + b + "";
                stack.push(sum);
            } else {
                String sum = a - b + "";
                stack.push(sum);
            }
        }
        System.out.println(stack.peek());
    }
}
