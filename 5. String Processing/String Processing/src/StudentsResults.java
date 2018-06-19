import java.util.Scanner;

public class StudentsResults {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] input = s.nextLine().split("[-,\\s]+");
        String name = input[0];
        double avg = (Double.parseDouble(input[1]) + Double.parseDouble(input[2]) + Double.parseDouble(input[3])) / 3;

        System.out.printf("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|%n", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        System.out.printf("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|", name, Double.parseDouble(input[1]), Double.parseDouble(input[2]), Double.parseDouble(input[3]), avg);

    }
}
