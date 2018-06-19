import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Problem04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> contests = new LinkedHashMap<>();

        String line = reader.readLine();
        while (!"end of contests".equals(line)) {
            String[] tokens = line.split(":");
            String contest = tokens[0];
            String password = tokens[1];

            if (!contests.containsKey(contest)) {
                contests.put(contest, password);
            }
            line = reader.readLine();
        }
        Map<String, Map<String, Integer>> results = new LinkedHashMap<>();

        line = reader.readLine();

        while (!"end of submissions".equals(line)) {
            String[] tokens = line.split("=>");
            String contest = tokens[0];
            String password = tokens[1];
            String name = tokens[2];
            int points = Integer.parseInt(tokens[3]);

            if (contests.containsKey(contest)) {
                String passwordContest = contests.get(contest);
                if (passwordContest.equals(password)) {
                    if (!results.containsKey(name)) {
                        Map<String, Integer> temp = new LinkedHashMap<>();
                        temp.put(contest, points);
                        results.put(name, temp);
                    } else {
                        if (!results.get(name).containsKey(contest)) {
                            results.get(name).put(contest, points);
                        } else {
                            int lastPoints = results.get(name).get(contest);
                            if (points > lastPoints) {
                                results.get(name).put(contest, points);
                            }
                        }
                    }
                }
            }

            line = reader.readLine();
        }
        int bestPoints = 0;
        String bestName = null;
        for (Map.Entry<String, Map<String, Integer>> entry : results.entrySet()) {
            int tempPoints = 0;
            for (Map.Entry<String, Integer> s : entry.getValue().entrySet()) {
                tempPoints += s.getValue();
            }
            if (tempPoints > bestPoints) {
                bestPoints = tempPoints;
                bestName = entry.getKey();
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n", bestName, bestPoints);
        System.out.println("Ranking: ");

        results.entrySet().stream().sorted((kv1, kv2) -> kv1.getKey().compareTo(kv2.getKey()))
                .forEach(kv -> {
                    System.out.println(kv.getKey());

                    kv.getValue().entrySet().stream().sorted((kv1, kv2) -> kv2.getValue().compareTo(kv1.getValue()))
                            .forEach(v -> System.out.printf("#  %s -> %d%n", v.getKey(), v.getValue()));
                });
    }
}
