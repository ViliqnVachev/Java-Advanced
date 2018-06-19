import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> results = new LinkedHashMap<>();

        String line = reader.readLine();
        Pattern pattern = Pattern.compile("([!@#$?A-za-z]*[A-Za-z]+[!@#$?A-Za-z]*)=([0-9]+)--([0-9]+)<<([A-Za-z]+)");

        while (!"Stop!".equals(line)) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String name = matcher.group(1);
                int lengthOfTheName = Integer.parseInt(matcher.group(2));
                int countOfGenes = Integer.parseInt(matcher.group(3));
                String organism = matcher.group(4);

                name = name.replaceAll("[!@#$?]", "");

                if (name.length() != lengthOfTheName) {
                    line = reader.readLine();
                    continue;
                } else {
                    if (!results.containsKey(organism)) {
                        results.put(organism, countOfGenes);
                    } else {
                        int temp = results.get(organism);
                        results.put(organism, countOfGenes + temp);
                    }
                }
            }

            line = reader.readLine();
        }

        results.entrySet().stream().sorted((kv1,kv2)->kv2.getValue().compareTo(kv1.getValue()))
                .forEach(kv-> System.out.printf("%s has genome size of %d%n",kv.getKey(),kv.getValue()));
    }
}
