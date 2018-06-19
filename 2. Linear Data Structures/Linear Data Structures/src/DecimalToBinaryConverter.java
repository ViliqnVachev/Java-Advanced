import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long input = Long.parseLong(s.nextLine());
            if(input==0){
                System.out.println("0");
                return;
            }
        ArrayDeque<Long> stack = new ArrayDeque<>();

        while (input != 0) {
            stack.push(input % 2);
            input /= 2;
        }

        while (stack.size() > 0) {
            System.out.print(stack.pop());
        }
    }
}
