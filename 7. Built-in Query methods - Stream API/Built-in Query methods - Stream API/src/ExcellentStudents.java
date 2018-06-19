import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> students = new LinkedHashMap<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String studentFirstName = line.split(" ")[0];
            String studentLastName = line.split(" ")[1];

            StringBuilder name = new StringBuilder();
            name = name.append(studentFirstName).append(" ").append(studentLastName);
            List<Integer> grades = new ArrayList<>();
            String[] tokens = line.split(" ");
            for (int i = 2; i < tokens.length; i++) {
                grades.add(Integer.parseInt(tokens[i]));
            }
            students.put(name.toString(), grades);
            line = reader.readLine();
        }

        students.entrySet().stream().filter(kv -> kv.getValue().contains(6))
                .forEach(kv -> System.out.println(kv.getKey()));
    }
}
