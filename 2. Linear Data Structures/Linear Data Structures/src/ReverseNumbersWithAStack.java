import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] numbers = Arrays.stream(s.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        //fill the stack
        for (int number : numbers) {
            stack.push(number);
        }

        while (stack.size() > 0) {
            System.out.print(stack.pop() + " ");
        }
    }
}
