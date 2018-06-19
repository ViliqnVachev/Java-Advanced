import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] size = s.nextLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);

        long[][] matrix = new long[n][m];

        // fill the matrix
        for (int row = 0; row < n; row++) {
            String[] numbers = s.nextLine().split(" ");
            for (int col = 0; col < m; col++) {
                long number = Long.parseLong(numbers[col]);
                matrix[row][col] = number;
            }
        }


        long a = 0;
        long b = 0;
        long c = 0;
        long d = 0;
        long e = 0;
        long f = 0;
        long g = 0;
        long h = 0;
        long i = 0;
        long bestSum = Long.MIN_VALUE;
        int rowTemp = 0;
        int colTemp = 0;

        for (int row = 0; row < n; row++) {
            if (row + 2 >=n) {
                break;
            }
            for (int col = 0; col < m; col++) {
                if (col + 2 >= m) {
                    break;
                }
                long sum = 0;
                a = matrix[row][col];
                b = matrix[row + 1][col];
                c = matrix[row + 2][col];
                d = matrix[row][col + 1];
                e = matrix[row + 1][col + 1];
                f = matrix[row + 2][col + 1];
                g = matrix[row][col + 2];
                h = matrix[row + 1][col + 2];
                i = matrix[row + 2][col + 2];

                sum = a + b + c + d + e + f + g + h + i;

                if (bestSum < sum) {
                    bestSum = sum;
                    rowTemp = row;
                    colTemp = col;
                }
            }
        }
        //print
        System.out.println("Sum = " + bestSum);
        for (int row = rowTemp; row < rowTemp + 3; row++) {
            for (int col = colTemp; col < colTemp + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
