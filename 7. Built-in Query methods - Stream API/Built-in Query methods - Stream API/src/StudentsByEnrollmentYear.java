import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentsByEnrollmentYear {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> students = new LinkedHashMap<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String facNumber = line.split(" ")[0];
            StringBuilder grades = new StringBuilder();
            String[] tokens = line.split(" ");
            for (int i = 1; i < tokens.length; i++) {
                grades.append(tokens[i]).append(" ");
            }
            students.put(facNumber, grades.toString());
            line = reader.readLine();
        }

        students.entrySet().stream().filter(kv -> kv.getKey().endsWith("14") || kv.getKey().endsWith("15"))
                .forEach(kv -> System.out.println(kv.getValue()));

    }
}
