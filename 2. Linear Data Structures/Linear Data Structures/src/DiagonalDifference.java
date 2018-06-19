import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = Integer.parseInt(s.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            String[] numbers = s.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                int number = Integer.parseInt(numbers[col]);
                matrix[row][col] = number;
            }
        }

        //first diagonal
        int firstDiagonalSum = 0;
        for (int col = 0; col < size; col++) {
            int diagonal = matrix[col][col];
            firstDiagonalSum += diagonal;
        }

        //second diagonal
        int secondDiagonalSum = 0;
        for (int col = 0; col < size; col++) {
            int diagonal = matrix[col][size - 1 - col];
            secondDiagonalSum += diagonal;
        }
        System.out.println(Math.abs(secondDiagonalSum - firstDiagonalSum));
    }
}
