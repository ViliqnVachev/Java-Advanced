import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] line = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[] comand = s.nextLine().split(" ");

        int numbers = Integer.parseInt(comand[1]);
        String type = comand[2];
        List<Integer> result = new ArrayList<>();

        switch (type) {
            case "even":
                GetEvenNumbers(line, numbers, result);
                break;

            case "odd":
                GetOddNumbers(line, numbers, result);
                break;
        }

        for (int nums : result) {
            System.out.print(nums+" ");
        }


    }

    private static void GetEvenNumbers(int[] line, int numbers, List<Integer> result) {
        for (int i = 0; i < line.length; i++) {
            if (line[i] % 2 == 0) {
                result.add(line[i]);
            }
            if (result.size() == numbers) {
                return;
            }
        }
    }

    private static void GetOddNumbers(int[] line, int numbers, List<Integer> result) {
        for (int i = 0; i < line.length; i++) {
            if (line[i] % 2 != 0) {
                result.add(line[i]);
            }
            if (result.size() == numbers) {
                return;
            }
        }
    }
}
