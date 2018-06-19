import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DHARMASupplies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern patternCrate = Pattern.compile("\\[.*?]");

        String line = reader.readLine();
        StringBuilder sb = new StringBuilder();
        int lines = 0;
        int match = 0;
        while (!"Collect".equals(line)) {
            lines++;
            Matcher matcher = patternCrate.matcher(line);
            while (matcher.find()) {
                match++;
            }
            sb.append(line).append(System.lineSeparator());
            line = reader.readLine();
        }
        int n = match / lines;

        Pattern crate = Pattern.compile("\\[(#(\\d{" + n + "}|[a-z]{" + n + "}))([A-Za-z0-9\\s]+)(\\1)]");

        Matcher matcher = crate.matcher(sb.toString());
        int count = 0;
        int countFoods = 0;
        int countDrinks = 0;
        while (matcher.find()) {
            String crates = matcher.group();
            String supplyTag = matcher.group(2);
            String body = matcher.group(3);
            count++;
            if (Character.isDigit(supplyTag.charAt(0))) {
                countFoods += (body.chars().distinct().sum() * supplyTag.length());

            } else {
                countDrinks += (body.chars().distinct().sum() * supplyTag.chars().sum());
            }
        }

        if (count == 0) {
            System.out.println("No supplies found!");
        } else {
            System.out.println("Number of supply crates: " + count);
            System.out.println("Amount of food collected: "+countFoods);
            System.out.println("Amount of drinks collected: "+countDrinks);
        }

    }
}
