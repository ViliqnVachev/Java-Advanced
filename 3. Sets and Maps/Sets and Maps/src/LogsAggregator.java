import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        TreeMap<String, TreeMap<String, Integer>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = s.nextLine().split("\\s+");
            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]); // check for long

            if (!map.containsKey(user)) {
                TreeMap<String, Integer> helper = new TreeMap<>();
                helper.put(ip, duration);
                map.put(user, helper);
            } else {
                if (!map.get(user).containsKey(ip)) {
                    map.get(user).put(ip, duration);
                } else {
                    int oldValue = map.get(user).get(ip);
                    map.get(user).put(ip, duration + oldValue);
                }
            }
        }

        for (Map.Entry<String, TreeMap<String, Integer>> entry : map.entrySet()) {
            int total = 0;
            List<String> helper = new ArrayList<>();
            for (Map.Entry<String, Integer> dur : entry.getValue().entrySet()) {
                String temp = dur.getKey();
                total += dur.getValue();
                helper.add(temp);
            }
            System.out.printf("%s: %d [",entry.getKey(),total);
            System.out.println(String.join(", ",helper)+"]");
        }

    }
}
