import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        String[][] matrix = new String[size][size];
        List<String> moves = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());
        int countFood = 0;
        int startCol = 0;
        int startRow = 0;
        for (int i = 0; i < size; i++) {
            String[] tokens = reader.readLine().split(" ");

            for (int j = 0; j < size; j++) {
                if (tokens[j].equals("f")) {
                    countFood++;
                }
                if (tokens[j].equals("s")) {
                    startCol = j;
                    startRow = i;
                }
                matrix[i][j] = tokens[j] + " ";
            }
        }

        int length = 1;
        while (!moves.isEmpty()) {
            String command = moves.get(0);

            switch (command) {
                case "up":
                    matrix[startRow][startCol] = "* ";
                    startRow = startRow - 1;
                    if (startRow < 0) {
                        startRow = size-1;
                    }
                    if (matrix[startRow][startCol].equals("f ")) {
                        countFood--;
                        length++;
                    } else if (matrix[startRow][startCol].equals("e ")) {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    } else {
                        matrix[startRow][startCol] = "s ";
                    }
                    break;
                case "down":
                    matrix[startRow][startCol] = "* ";
                    startRow = startRow + 1;
                    if (startRow >= matrix.length) {
                        startRow = 0;
                    }
                    if (matrix[startRow][startCol].equals("f ")) {
                        countFood--;
                        length++;
                    } else if (matrix[startRow][startCol].equals("e ")) {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    } else {
                        matrix[startRow][startCol] = "s ";
                    }
                    break;

                case "right":
                    matrix[startRow][startCol] = "* ";
                    startCol = startCol + 1;
                    if (startCol >= size) {
                        startCol = 0;
                    }
                    if (matrix[startRow][startCol].equals("f ")) {
                        countFood--;
                        length++;
                    } else if (matrix[startRow][startCol].equals("e ")) {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    } else {
                        matrix[startRow][startCol] = "s ";
                    }
                    break;
                case "left":
                    matrix[startRow][startCol] = "* ";
                    startCol = startCol - 1;
                    if (startCol < 0) {
                        startCol = size-1;
                    }
                    if (matrix[startRow][startCol].equals("f ")) {
                        countFood--;
                        length++;
                    } else if (matrix[startRow][startCol].equals("e ")) {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    } else {
                        matrix[startRow][startCol] = "s ";
                    }
                    break;
            }
            if (countFood == 0) {
                System.out.println("You win! Final snake length is " + length);
                return;
            }

            moves.remove(0);
        }

        if (moves.isEmpty()) {
            System.out.printf("You lose! There is still %d food to be eaten.", countFood);
        }

       // System.out.println(countFood);
    }
}
