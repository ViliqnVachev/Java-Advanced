import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();
        String[] line = s.nextLine().split("\\s+");

        while (!"end".equals(line[0])) {
            String[] nameTokens = line[2].split("user=");
            String name = nameTokens[1];

            String[] ipTokens = line[0].split("IP=");
            String ip = ipTokens[1];

            if (!map.containsKey(name)) {
                LinkedHashMap<String, Integer> temp = new LinkedHashMap<>();
                if (!temp.containsKey(ip)) {
                    temp.put(ip, 1);
                } else {
                    temp.put(ip, temp.get(ip) + 1);
                }
                map.put(name, temp);
            } else {
                if (!map.get(name).containsKey(ip)) {
                    map.get(name).put(ip, 1);
                } else {
                    map.get(name).put(ip, map.get(name).get(ip) + 1);
                }
            }

            line = s.nextLine().split("\\s+");
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey()+":");
            List<String> helper = new LinkedList<>();
            for (Map.Entry<String, Integer> item : entry.getValue().entrySet()) {
                String temp = item.getKey() + " => " + item.getValue();
                helper.add(temp);
            }
            System.out.println(String.join(", ", helper) + ".");
        }
    }
}
