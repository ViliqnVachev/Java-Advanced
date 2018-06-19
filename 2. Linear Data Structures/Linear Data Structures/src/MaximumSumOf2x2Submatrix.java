import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] line = s.nextLine().split(", ");
        int row = Integer.parseInt(line[0]);
        int col = Integer.parseInt(line[1]);

        int[][] matrix = fillatrix(s, row, col);
        int a = 0;
        int b = 0;
        int bestSum = Integer.MIN_VALUE;

        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                int currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    a = i;
                    b = j;
                }
            }
        }
        System.out.println(matrix[a][b] + " " + matrix[a][b + 1]);
        System.out.println(matrix[a + 1][b] + " " + matrix[a+1][b + 1]);
        System.out.println(bestSum);
    }

    private static int[][] fillatrix(Scanner s, int row, int col) {
        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            int[] numbers = Arrays.stream(s.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < col; j++) {
                matrix[i][j] = numbers[j];
            }
        }
        return matrix;
    }


}
