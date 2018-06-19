import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> cities = new LinkedHashMap<>();
        String[] input = reader.readLine().split(" ");
        int populationBound = Integer.parseInt(reader.readLine());

        for (String s : input) {
            String city = s.split(":")[0];
            int district = Integer.parseInt(s.split(":")[1]);

            if (!cities.containsKey(city)) {
                cities.put(city, new ArrayList<>());
            }
            cities.get(city).add(district);
        }

        cities.entrySet().stream().filter(kv -> {
            int sum = kv.getValue().stream()
                    .mapToInt(Integer::valueOf)
                    .sum();
            return sum > populationBound;
        })
                .sorted((kv1, kv2) -> {
                    int sum1 = kv1.getValue().stream()
                            .mapToInt(Integer::valueOf)
                            .sum();
                    int sum2 = kv2.getValue().stream()
                            .mapToInt(Integer::valueOf)
                            .sum();
                    return Integer.compare(sum2, sum1);
                })
                .forEach(kv -> {
                    System.out.print(kv.getKey() + ": ");

                    kv.getValue().stream()
                            .sorted((v1, v2) -> {
                                return Integer.compare(v2, v1);
                            }).limit(5).forEach(v -> System.out.print(v + " "));
                    System.out.println();
                });
        System.out.println();
    }
}
