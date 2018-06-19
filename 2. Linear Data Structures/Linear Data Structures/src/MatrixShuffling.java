import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] size = s.nextLine().split(" ");
        int a = Integer.parseInt(size[0]);
        int b = Integer.parseInt(size[1]);
        String[][] matrix = new String[a][b];
        matrix = fillTheMatrix(s, a, b, matrix);

        String[] comands = s.nextLine().split(" ");

        while (!comands[0].equals("END")) {
            if (comands.length > 5) {
                System.out.println("Invalid input!");
                comands = s.nextLine().split(" ");
                continue;
            }
            if (!comands[0].equals("swap")) {
                System.out.println("Invalid input!");
                comands = s.nextLine().split(" ");
                continue;
            }
            int row1 = Integer.parseInt(comands[1]);
            int col1 = Integer.parseInt(comands[2]);
            int row2 = Integer.parseInt(comands[3]);
            int col2 = Integer.parseInt(comands[4]);

            if (row1 < a && row2 < a) {
                if (col1 < b && col2 < b) {
                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;

                    for (String[] aMatrix : matrix) {
                        for (String anAMatrix : aMatrix) {
                            System.out.print(anAMatrix + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            comands = s.nextLine().split(" ");
        }
    }

    private static String[][] fillTheMatrix(Scanner s, int a, int b, String[][] matrix) {
        for (int row = 0; row < a; row++) {
            String[] line = s.nextLine().split(" ");
            for (int col = 0; col < b; col++) {
                String data = line[col];
                matrix[row][col] = data;
            }
        }
        return matrix;
    }
}
