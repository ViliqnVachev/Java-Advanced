import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = new ArrayList<>();


        String line = reader.readLine();
        while (!"END".equals(line)) {
            names.add(line);
            line = reader.readLine();
        }

        names.stream().filter(n -> {
            String fName = n.split(" ")[0];
            String lName = n.split(" ")[1];
            return fName.compareTo(lName) < 0;

        }).forEach(System.out::println);
    }
}
