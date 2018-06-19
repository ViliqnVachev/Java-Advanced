import java.util.Scanner;

public class FillMatrix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] comand = s.nextLine().split(", ");
        int a = Integer.parseInt(comand[0]);
        String type = comand[1];
        int temp = a * a;
        int[][] matrix = new int[a][a];

        if (type.equals("A")) {
            matrix = typeA(a, matrix);
        } else {
            matrix = typeB(a, matrix);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] typeB(int a, int[][] matrix) {
        int temporary = 1;

        for (int row = 0; row < a; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < a; col++) {
                    if (col + 1 > +a) {
                        break;
                    }
                    matrix[col][row] = temporary;
                    temporary++;
                }
            } else {
                for (int col = a - 1; col >= 0; col--) {
                    matrix[col][row] = temporary;
                    temporary++;
                }
            }
        }
        return matrix;
    }

    private static int[][] typeA(int a, int[][] matrix) {
        for (int row = 0; row < a; row++) {
            int temporary = row + 1;
            for (int col = 0; col < a; col++) {
                matrix[row][col] = temporary;
                temporary += a;
            }
        }
        return matrix;
    }

}
