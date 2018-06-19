import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, String> students = new LinkedHashMap<>();
        String line = reader.readLine();

        while (!"END".equals(line)) {
            String fName = line.split(" ")[0];
            String lName = line.split(" ")[1];
            Integer group = Integer.parseInt(line.split(" ")[2]);
            StringBuilder name = new StringBuilder();
            name = name.append(fName).append(" ").append(lName);
            if (!students.containsKey(group)) {
                students.put(group, name.toString());
            } else {
                StringBuilder temp = new StringBuilder(students.get(group)).append(", ").append(name);
                students.put(group, temp.toString());
            }
            line = reader.readLine();
        }

        students.entrySet().stream()
                .sorted((kv1, kv2) -> kv1.getKey().compareTo(kv2.getKey()))
                .forEach(kv -> {
                    System.out.print(kv.getKey() + " - ");
                    System.out.println(kv.getValue() + " ");
                });
    }
}
