import java.util.Arrays;
import java.util.Scanner;

public class OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] line = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (line.length % 2 != 0) {
            System.out.println("invalid length");
            return;
        }

        for (int i = 0; i < line.length; i++) {
            int temp = i * 2;
            if (temp + 1 >= line.length) {
                return;
            }

            if (line[temp] % 2 == 0 && line[temp + 1] % 2 == 0) {
                System.out.printf("%d, %d -> both are even%n", line[temp], line[temp + 1]);
            } else if (line[temp] % 2 != 0 && line[temp + 1] % 2 != 0) {
                System.out.printf("%d, %d -> both are odd%n", line[temp], line[temp + 1]);
            } else {
                System.out.printf("%d, %d -> different%n", line[temp], line[temp + 1]);
            }

        }
    }
}
