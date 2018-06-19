import java.util.Scanner;

public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double first=s.nextDouble();
        double second=s.nextDouble();
        double third=s.nextDouble();

        double average = (first+second+third)/3;
        System.out.printf("%.2f",average);
    }
}
