import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] data = s.nextLine().split(" ");
        int a = Integer.parseInt(data[0]);
        int b = Integer.parseInt(data[1]);
        String[][] matrix = new String[a][b];

        matrix = fillMatrix(a, b, matrix);

        printMatrix(a, b, matrix);
    }

    private static void printMatrix(int a, int b, String[][] matrix) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static String[][] fillMatrix(int a, int b, String[][] matrix) {
        for (int row = 0; row < a; row++) {
            for (int col = 0; col < b; col++) {
                int firstLeter = 'a' + row;
                int middleLeter = 'a' + row + col;
                int lastLeter = 'a' + row;
                char f = (char) firstLeter;
                char m = (char) middleLeter;
                char l = (char) lastLeter;

                String temp = String.valueOf(f) + m + l;
                matrix[row][col] = temp;
            }
        }
        return matrix;
    }
}
