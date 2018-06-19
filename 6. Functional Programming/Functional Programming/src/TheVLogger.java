import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class TheVLogger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Set<String>> vloggerFollowing = new LinkedHashMap<>();
        Map<String, Set<String>> vloggerAntFollowers = new LinkedHashMap<>();

        String line = reader.readLine();
        while (!"Statistics".equals(line)) {
            String[] tokens = line.split("\\s+");

            //join to V-Logger
            if (tokens.length == 4) {
                String vloggerName = tokens[0];
                if (!vloggerAntFollowers.containsKey(vloggerName)) {
                    vloggerFollowing.put(vloggerName, new HashSet<>());
                    vloggerAntFollowers.put(vloggerName, new TreeSet<>());
                }


            } else if (tokens.length == 3) {
                String vloggerName = tokens[0];
                String followedVloger = tokens[2];
                if (!followedVloger.equals(vloggerName) && vloggerFollowing.containsKey(vloggerName) && vloggerFollowing.containsKey(followedVloger)) {
                    vloggerFollowing.get(vloggerName).add(followedVloger);
                    vloggerAntFollowers.get(followedVloger).add(vloggerName);
                }

            }
            line = reader.readLine();
        }

        System.out.println(String.format("The V-Logger has a total of %d vloggers in its logs.", vloggerFollowing.size()));
        List<String> sortedNames = vloggerAntFollowers.keySet()
                .stream()
                .sorted(Comparator.comparing((String x) -> vloggerAntFollowers.get(x).size(), Comparator.reverseOrder())
                        .thenComparing(x -> vloggerFollowing.get(x).size()))
                .collect(Collectors.toList());

        int counter = 1;
        for (String name : sortedNames) {
            System.out.printf("%d. %s : %d followers, %d following%n",
                    counter, name, vloggerAntFollowers.get(name).size(), vloggerFollowing.get(name).size());
            if (counter == 1) {
                vloggerAntFollowers.get(name).forEach(x -> System.out.printf("*  %s%n", x));
            }
            counter++;
        }
    }
}
