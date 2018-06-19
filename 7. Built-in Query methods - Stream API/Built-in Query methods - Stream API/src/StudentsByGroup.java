import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> students = new LinkedHashMap<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String studentFirstName = line.split(" ")[0];
            String studentLastName = line.split(" ")[1];
            int group = Integer.parseInt(line.split(" ")[2]);
            String student = studentFirstName + " " + studentLastName;
            students.put(student, group);
            line = reader.readLine();
        }

        students.entrySet().stream().filter(kv -> kv.getValue() == 2).sorted((kv1, kv2) -> {
            return kv1.getKey().compareTo(kv2.getKey());
        }).forEach(kv -> {
            System.out.println(kv.getKey());
        });

    }
}
