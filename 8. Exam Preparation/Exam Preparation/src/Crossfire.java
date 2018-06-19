import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] size = reader.readLine().split("\\s+");
        int a = Integer.parseInt(size[0]);
        int b = Integer.parseInt(size[1]);
        int count = 1;

        //fill the matrix
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < b; j++) {
                temp.add(count++);
            }
            matrix.add(temp);
        }

        String line = reader.readLine();
        while (!"Nuke it from orbit".equals(line)) {
            String[] tokens = line.split("\\s+");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);


            int startRow = row - radius;
            int endRow = row + radius;


            if (endRow > a) {
                endRow = a;
            }
            if (startRow < 0) {
                startRow = 0;
            }
            int startRadius = col - radius;
            if (startRadius < 0) {
                startRadius = 0;
            }
            int endRadius = col + radius;
            if (endRadius > b) {
                endRadius = b;
            }

            for (int i = startRow; i < endRow; i++) {
                if (i == row) {
                    if (matrix.get(i).size() < endRadius) {
                        endRadius = matrix.get(i).size();
                    }
                    for (int j = startRadius; j < endRadius; j++) {

                        matrix.get(i).remove(j);
                        j--;
                        endRadius--;
                    }
                } else {
                    for (int j = col; j < col + 1; j++) {
                        if (matrix.get(i).size() < j) {
                            break;
                        }
                        matrix.get(i).remove(j);
                    }
                }

            }


            line = reader.readLine();
        }
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }

        //NB check the row and col ??
    }

    public static String[][] createAndFillMatrix(int a, int b) {
        String[][] matrix = new String[a][b];
        int temp = 1;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                matrix[i][j] = String.valueOf(temp++);
            }
        }
        return matrix;
    }
}
