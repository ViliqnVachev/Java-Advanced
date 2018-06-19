import java.math.BigInteger;
import java.util.Scanner;

public class ProductOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = n;
        int m = scanner.nextInt();
        BigInteger product = BigInteger.ONE;

        do {
            BigInteger number = new BigInteger("" + a);
            product = product.multiply(number);
            a++;;
        } while (a <= m);

        System.out.printf("product[%d..%d] = %d\n", n, m, product);

    }
}
