import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Map<String, double[]> data = new TreeMap<>();

        int students = Integer.parseInt(s.nextLine());

        for (int i = 0; i < students; i++) {
            String name = s.nextLine();

            double[] grade = Arrays.stream(s.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            if (!data.containsKey(name)) {
                data.put(name, grade);
            }
        }

        for (Map.Entry<String, double[]> entry : data.entrySet()) {
            double avr = 0;
            double sum = 0;

            for (double grade : entry.getValue()) {
                sum += grade;
            }
            avr = sum / entry.getValue().length;

            System.out.printf("%s is graduated with %s%n", entry.getKey(), avr);
        }
    }
}
