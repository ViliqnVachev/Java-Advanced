import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(3%2);
        char[] symbols = scanner.nextLine().toCharArray();
        Deque<Integer> roundParenthesis = new ArrayDeque<>();
        Deque<Integer> squareParenthesis = new ArrayDeque<>();
        Deque<Integer> curlyParenthesis = new ArrayDeque<>();

        for (int i = 0; i < symbols.length; i++) {
            char parenthesi = symbols[i];
            Integer startIndex = -1;

            switch (parenthesi) {
                case '{':
                    curlyParenthesis.push(i);
                    break;
                case '[':
                    squareParenthesis.push(i);
                    break;
                case '(':
                    roundParenthesis.push(i);
                    break;


                case '}':
                    startIndex = curlyParenthesis.poll();
                    if (startIndex == null || (startIndex + i) % 2 != 1) {
                        System.out.println("NO");
                        return;
                    }
                    break;

                case ']':
                    startIndex = squareParenthesis.poll();
                    if (startIndex == null || (startIndex + i) % 2 != 1) {
                        System.out.println("NO");
                        return;
                    }
                    break;


                case ')':
                    startIndex = roundParenthesis.poll();
                    if (startIndex == null || (startIndex + i) % 2 != 1) {
                        System.out.println("NO");
                        return;
                    }
                    break;
            }
        }
        if (roundParenthesis.isEmpty() && squareParenthesis.isEmpty() && curlyParenthesis.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
