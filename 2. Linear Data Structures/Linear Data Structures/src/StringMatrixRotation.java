import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String comand = s.nextLine();
        int first = comand.indexOf('(');
        int second = comand.indexOf(')');
        int temp = second - first;
        String number = comand.substring(first+1, comand.length()-1);
        int degrees = Integer.parseInt(number);

        List<String> temo = new ArrayList<>();

        int maxLenght = 0;
        int rows = 0;
        String input = s.nextLine();
        while (!input.equals("END")) {
            rows++;
            temo.add(input);
            if (input.length() > maxLenght) {
                maxLenght = input.length();
            }
            input = s.nextLine();
        }

        char[][] matrix = new char[rows][maxLenght];
        int index = 0;
        int item = 0;

        for (int row = 0; row < matrix.length; row++) {
            String word = temo.get(item);
            int itemLength = word.length();
            for (int col = 0; col < matrix[row].length; col++) {
                if (index == itemLength) {
                    while (index < maxLenght) {
                        matrix[row][col] = ' ';
                        index++;
                        col++;
                    }
                    index = 0;
                    break;
                } else {
                    matrix[row][col] = word.charAt(index);
                    index++;
                }
            }
            item++;
            index = 0;
        }

        rotateMatrix(matrix, degrees);

    }

    private static void rotateMatrix(char[][] matrix, int degrees) {
        switch (degrees) {
            case 90:
                for (int col = 0; col < matrix.length; col++) {
                    for (int row = matrix[col].length - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int r = matrix.length - 1; r >= 0; r--) {
                    for (int c = matrix[r].length - 1; c >= 0; c--) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = matrix.length - 1; col >= 0; col--) {
                    for (int row = 0; row <= matrix[col].length - 1; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 360:
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }

    }
}
