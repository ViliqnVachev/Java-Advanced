import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> students = new LinkedHashMap<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String studentFirstName = line.split(" ")[0];
            String studentLastName = line.split(" ")[1];
            int age = Integer.parseInt(line.split(" ")[2]);
            String student = studentFirstName + " " + studentLastName;
            students.put(student, age);
            line = reader.readLine();
        }

        students.entrySet().stream().filter(kv -> kv.getValue() >= 18 && kv.getValue() <= 24)
                .forEach(kv -> System.out.println(kv.getKey() + " " + kv.getValue()));
    }
}
