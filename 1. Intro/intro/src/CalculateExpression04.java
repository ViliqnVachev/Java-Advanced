import java.util.Scanner;

public class CalculateExpression04 {
    public static void main(String[] args) {
        double f1, f2, f3;
        double f1b, f1e, f2b, f2e;
        double a, b, c;
        Scanner scan = new Scanner(System.in);
        a = scan.nextDouble();
        b = scan.nextDouble();
        c = scan.nextDouble();
        f1b = ((a * a) + (b * b)) / ((a * a) - (b * b));
        f1e = (a + b + c) / (Math.sqrt(c));
        f1 = Math.pow(f1b, f1e);
        f2b = (a * a) + (b * b) - (c * c * c);
        f2e = (a - b);
        f2 = Math.pow(f2b, f2e);
        f3 = Math.abs(((a + b + c) / 3) - ((f1 + f2) / 2));
        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, f3);
    }
}
