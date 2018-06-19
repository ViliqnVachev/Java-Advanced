import java.util.*;
import java.util.stream.Collectors;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Map<String, Integer> resources = new TreeMap<>();
        resources.put("shards", 0);
        resources.put("fragments", 0);
        resources.put("motes", 0);
        Map<String, Integer> junk = new TreeMap<>();
        boolean isShadowmourne = false;
        boolean isValanyr = false;
        boolean isDragonwrath = false;
        String shards = "shards";
        String fragments = "fragments";
        String motes = "motes";

        System.out.println();
        while (isDragonwrath == false && isShadowmourne == false && isValanyr == false) {
            String[] line = s.nextLine().toLowerCase().split("\\s+");
            List<String> tokens = new ArrayList<>();
            Collections.addAll(tokens, line);

            for (int i = 0; i < tokens.size(); i++) {
                int qunatity = Integer.parseInt(tokens.get(i));
                tokens.remove(i);
                String material = tokens.get(i);
                tokens.remove(i);
                i--;

                if (resources.containsKey(material)) {
                    int oldQuantity = resources.get(material);
                    resources.put(material, qunatity + oldQuantity);
                } else {
                    if (!junk.containsKey(material)) {
                        junk.put(material, qunatity);
                    } else {
                        int oldQunatity = junk.get(material);
                        junk.put(material, qunatity + oldQunatity);
                    }
                }
                int tempQuantity = 0;
                if (resources.get(shards) >= 250) {
                    isShadowmourne = true;
                    System.out.println("Shadowmourne obtained!");
                    tempQuantity = resources.get(shards);
                    resources.put(shards, tempQuantity - 250);
                    break;
                } else if (resources.get(fragments) >= 250) {
                    isValanyr = true;
                    System.out.println("Valanyr obtained!");
                    tempQuantity = resources.get(fragments);
                    resources.put(fragments, tempQuantity - 250);
                    break;
                } else if (resources.get(motes) >= 250) {
                    isDragonwrath = true;
                    System.out.println("Dragonwrath obtained!");
                    tempQuantity = resources.get(motes);
                    resources.put(motes, tempQuantity - 250);
                    break;
                }

            }
        }

        Map<String, Integer> sortedResources = resources.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        for (Map.Entry<String, Integer> entry : sortedResources.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }


    }
}

