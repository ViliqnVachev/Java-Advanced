import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Map<String, Integer> resources = new LinkedHashMap<>();

        String line = s.nextLine();
        int count = 1;
        String resource = "";
        while (!"stop".equals(line)) {
            if (count % 2 != 0) {
                resource = line;
                if (!resources.containsKey(resource)) {
                    resources.put(resource, 0);
                }
            } else {
                int quntity = Integer.parseInt(line);
                int oldQuantity = resources.get(resource);
                resources.put(resource, oldQuantity + quntity);
            }
            count++;
            line = s.nextLine();
        }
        printKeyValuePairs(resources);
    }

    private static void printKeyValuePairs(Map<String, Integer> resources) {
        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
