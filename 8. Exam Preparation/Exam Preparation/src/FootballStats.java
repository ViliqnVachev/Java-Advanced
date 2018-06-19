import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Pair<String, String>>> teams = new LinkedHashMap<>();

        String line = reader.readLine();
        while (!"Season End".equals(line)) {
            String[] tokens = line.split("[-|\\s+]+");
            String firstTeam = tokens[0];
            String secondTeam = tokens[1];
            StringBuilder result = new StringBuilder(tokens[3]);

            if (!teams.containsKey(firstTeam)) {

                List<Pair<String, String>> temp = new ArrayList<>();
                Pair<String, String> helper = new Pair<>(secondTeam, result.toString());
                temp.add(helper);
                teams.put(firstTeam, temp);

                if (!teams.containsKey(secondTeam)) {
                    List<Pair<String, String>> temp2 = new ArrayList<>();
                    helper = new Pair<>(firstTeam, result.reverse().toString());
                    temp2.add(helper);
                    teams.put(secondTeam, temp2);
                } else {
                    helper = new Pair<>(firstTeam, result.reverse().toString());
                    teams.get(secondTeam).add(helper);
                }
            } else {
                Pair<String, String> helper = new Pair<>(secondTeam, result.toString());
                teams.get(firstTeam).add(helper);
                if (!teams.containsKey(secondTeam)) {
                    List<Pair<String, String>> temp2 = new ArrayList<>();
                    helper = new Pair<>(firstTeam, result.reverse().toString());
                    temp2.add(helper);
                    teams.put(secondTeam, temp2);
                } else {
                    helper = new Pair<>(firstTeam, result.reverse().toString());
                    teams.get(secondTeam).add(helper);
                }
            }
            line = reader.readLine();
        }
        String[] printTeams = reader.readLine().split(", ");

        for (int i = 0; i < printTeams.length; i++) {
            String team = printTeams[i];
            if (teams.containsKey(team)) {
                teams.entrySet().stream().filter(kv->kv.getKey().equals(team)).forEach(kv -> {
                    String fteam = kv.getKey();
                    kv.getValue().stream().sorted((t1, t2) -> t1.getKey().compareTo(t2.getKey()))
                            .forEach(t -> System.out.println(String.format("%s - %s -> %s", fteam, t.getKey(), t.getValue())));
                });
            }
        }
    }
}
