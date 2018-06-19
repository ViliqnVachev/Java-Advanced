import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Map<String, Map<String, Long>> map = new LinkedHashMap<>();
        String line;

        while (!"report".equals(line = s.nextLine())) {

            String[] tokens = line.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            Map<String, Long> helper = new LinkedHashMap<>();
            helper.put(city, population);
            if (!map.containsKey(country)) {
                map.put(country, helper);
            } else {
                map.get(country).put(city, population);
            }
        }

        Map<String, Map<String, Long>> sortedMap = map.entrySet().stream()
                .sorted((a, b) -> {
                    long populatrion1 = a.getValue()
                            .values()
                            .stream()
                            .mapToLong(Long::valueOf)
                            .sum();
                    long populatrion2 = b.getValue()
                            .values()
                            .stream()
                            .mapToLong(Long::valueOf)
                            .sum();
                    return Long.compare(populatrion2, populatrion1);
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        for (Map.Entry<String, Map<String, Long>> entry : sortedMap.entrySet()) {
            long totalPopulation = 0;
            Map<String, Long> cities = entry.getValue().entrySet()
                    .stream()
                    .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
            StringBuilder temp = new StringBuilder();
            for (Map.Entry<String, Long> city : cities.entrySet()) {
                totalPopulation += city.getValue();
                temp.append("=>").append(city.getKey()).append(": ").append(city.getValue()).append("\n");

            }
            System.out.printf("%s (total population: %d)%n", entry.getKey(), totalPopulation);
            System.out.print(temp);
        }

        System.out.println();
    }
}
