import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

public class LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> stones = new ArrayDeque<>();
        Deque<Integer> gold = new ArrayDeque<>();
        for (int i : input) {
            stones.add(i);
        }
        String line = reader.readLine();
        while (!"Revision".equals(line)) {
            String[] tokens = line.split("\\s+");
            String type = tokens[0];
            int acid = Integer.parseInt(tokens[2]);

            switch (type) {
                case "Apply":
                    if(stones.isEmpty()){
                        break;
                    }
                    for (int i = 0; i < acid; i++) {
                        if(stones.isEmpty()){
                            break;
                        }
                        int currentStone = stones.remove() - 1;
                        if (currentStone == 0) {
                            gold.push(currentStone);
                        } else {
                            stones.add(currentStone);
                        }
                    }
                    break;

                case "Air":
                    if (gold.isEmpty()) {
                        break;
                    }
                    int currentGold = gold.pop() + acid;
                    stones.add(currentGold);
                    break;
            }

            line = reader.readLine();
        }
        for (Integer stone : stones) {
            System.out.print(stone + " ");
            stones.remove();
        }
        System.out.println();
        System.out.println(gold.size());
    }
}
