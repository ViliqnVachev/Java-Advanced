import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] roomSize = reader.readLine().split("\\s+");
        int a = Integer.parseInt(roomSize[0]);
        int b = Integer.parseInt(roomSize[1]);

        int[][] room = new int[a][b];


        String line = reader.readLine();
        while (!"Here We Go".equals(line)) {
            String[] tokens = line.split("\\s+");
            int startRow = Integer.parseInt(tokens[0]);
            int startIndex = Integer.parseInt(tokens[1]);
            int endRow = Integer.parseInt(tokens[2]);
            int endIndex = Integer.parseInt(tokens[3]);

            for (int i = startRow; i <= endRow; i++) {
                for (int j = startIndex; j <= endIndex; j++) {
                    room[i][j]++;
                }
            }

            line = reader.readLine();
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(room[i][j]+" ");
            }
            System.out.println();
        }
    }
}
