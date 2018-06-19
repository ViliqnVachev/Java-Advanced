import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] comands = s.nextLine().split(" ");
        int numbersForStack = Integer.parseInt(comands[0]);
        int popNumbersCount = Integer.parseInt(comands[1]);
        int checkElement = Integer.parseInt(comands[2]);

        String[] data = s.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int temp;
        //push elements in the stack
        for (int i = 0; i < numbersForStack; i++) {
            temp = Integer.parseInt(data[i]);
            stack.push(temp);
        }
        //pop elements from stack
        for (int i = 0; i < popNumbersCount; i++) {
            stack.pop();
        }
        if (stack.contains(checkElement)) {
            System.out.println(true);
        } else if (stack.size() == 0) {
            System.out.println(0);
        } else {
            Integer[] arr = new Integer[stack.size()];
            arr = stack.toArray(arr);
            int smalestElement = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                int currentElement = arr[i];
                if (currentElement < smalestElement) {
                    smalestElement = currentElement;
                }
            }
            System.out.println(smalestElement);
        }
    }
}
