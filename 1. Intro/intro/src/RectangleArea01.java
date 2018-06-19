import java.util.Scanner;

public class RectangleArea01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double a =s.nextDouble();
        double b =s.nextDouble();

        double rectangleArea=a*b;
        System.out.printf("%.2f",rectangleArea);
    }
}
