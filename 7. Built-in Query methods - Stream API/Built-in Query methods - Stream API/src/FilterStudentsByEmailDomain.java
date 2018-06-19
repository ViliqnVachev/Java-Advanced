import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> students = new LinkedHashMap<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String studentFirstName = line.split(" ")[0];
            String studentLastName = line.split(" ")[1];
            String email = line.split(" ")[2];
            StringBuilder name =new StringBuilder();
            name = name.append(studentFirstName).append(" ").append(studentLastName);
            students.put(name.toString(), email);
            line = reader.readLine();
        }

        students.entrySet().stream().filter(kv -> kv.getValue().contains("@gmail"))
                .forEach(kv -> System.out.println(kv.getKey()));
    }
}
