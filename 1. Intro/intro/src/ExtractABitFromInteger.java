import java.util.Scanner;

public class ExtractABitFromInteger {
    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int bitPos = s.nextInt();

        int mask = num >> bitPos;
        int result = 1 & mask;
        System.out.println(result);
    }
}