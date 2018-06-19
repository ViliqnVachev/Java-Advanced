import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Map<String, String> phonebook = new LinkedHashMap<>();

        String[] line = s.nextLine().split("-");

        while (!"search".equals(line[0])) {
            String name = line[0];
            String number = line[1];
            phonebook.put(name, number);
            line = s.nextLine().split("-");
        }
        String searchLine = s.nextLine();
        while (!"stop".equals(searchLine)) {

            if (!phonebook.containsKey(searchLine)) {
                System.out.printf("Contact %s does not exist.%n", searchLine);
            } else {
                String number = phonebook.get(searchLine);
                System.out.printf("%s -> %s%n", searchLine, number);
            }
            searchLine=s.nextLine();
        }

    }
}
