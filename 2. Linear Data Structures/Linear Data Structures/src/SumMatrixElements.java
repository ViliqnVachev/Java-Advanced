import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] line = s.nextLine().split(", ");
        int row = Integer.parseInt(line[0]);
        int col = Integer.parseInt(line[1]);

        int[][] matrix = new int[row][col];
        int sumMatrix = 0;

        for (int i = 0; i < row; i++) {
            int[] numbers = Arrays.stream(s.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < col; j++) {
                matrix[i][j] = numbers[j];
                sumMatrix += numbers[j];
            }
        }
        System.out.println(row);
        System.out.println(col);
        System.out.println(sumMatrix);
    }
}
