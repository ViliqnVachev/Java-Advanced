import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, String>> students = new ArrayList<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String firstName = line.split(" ")[0];
            String lastName = line.split(" ")[1];
            Pair<String, String> student = new Pair<>(firstName, lastName);
            students.add(student);
            line = reader.readLine();
        }

        students.stream().sorted((a1, a2) -> {
            int compByLastName = a1.getValue().compareTo(a2.getValue());
            if (compByLastName != 0) {
                return compByLastName;
            }
            int compByName = a2.getKey().compareTo(a1.getKey());
            return compByName;
    }).

    forEach(kv ->System.out.println(kv.getKey()+" "+kv.getValue()));

}
}
