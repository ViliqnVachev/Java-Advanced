import java.util.Scanner;

public class ModifyABit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();                int bitPos=s.nextInt();
        int bitValue=s.nextInt();
int temp=n/10;
    int mask=~(temp<<bitPos);

        int result = n & mask;
        System.out.println(result);
    }
}
