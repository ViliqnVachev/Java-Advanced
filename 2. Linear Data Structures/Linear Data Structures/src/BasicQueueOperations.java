import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] comands = s.nextLine().split("\\s+");
        int numbersForQeue = Integer.parseInt(comands[0]);
        int pollNumbersCount = Integer.parseInt(comands[1]);
        int checkElement = Integer.parseInt(comands[2]);

        String[] numbers = s.nextLine().split("\\s+");
        Queue<Integer> que = new ArrayDeque<>();

        //fill qeue
        int temp;
        for (int i = 0; i < numbersForQeue; i++) {
            temp = Integer.parseInt(numbers[i]);
            que.add(temp);
        }

        //remove elemenets
        for (int i = 0; i < pollNumbersCount; i++) {
            que.poll();
        }

        if (que.contains(checkElement)) {
            System.out.println(true);
        } else if (que.size() == 0) {
            System.out.println(0);
        } else {
            Integer[] arr = new Integer[que.size()];
            arr = que.toArray(arr);
            int smallestElement = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                int currentElement = arr[i];
                if (smallestElement > currentElement) {
                    smallestElement = currentElement;
                }
            }
            System.out.println(smallestElement);
        }

    }
}
