import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNames = reader.readLine().split("\\s+");
        List<String> guests = new ArrayList<>();
        Collections.addAll(guests, inputNames);

        String line = reader.readLine();
        while (!"Party!".equals(line)) {

            String[] commandTokens = line.split("\\s+");
            String command = commandTokens[0];
            String predicateType = commandTokens[1];
            String parameter = commandTokens[2];


            line = reader.readLine();
            switch (command) {
                case "Double":
                    List<String> additionalGuests = new ArrayList<>();
                    for (String guest : guests) {
                        if (getPredicate(predicateType, parameter).test(guest)) {
                            additionalGuests.add(guest);
                        }
                        additionalGuests.add(guest);
                    }
                    guests = additionalGuests;
                    break;

                case "Remove":
                    guests.removeIf(getPredicate(predicateType, parameter));
                    break;
            }
        }
        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(String.format("%s are going to the party!", String.join(", ", guests)));
        }
    }

    private static Predicate<String> getPredicate(String predicateType, String parameter) {
        switch (predicateType) {
            case "StartsWith":
                return (guest) -> guest.startsWith(parameter);
            case "EndsWith":
                return (guest) -> guest.endsWith(parameter);
            default:
                return (guest) -> guest.length() == Integer.parseInt(parameter);
        }
    }
}
