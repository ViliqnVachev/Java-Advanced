import java.util.Scanner;

public class ReadInput {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String firstWord= s.next();
        String secondWord= s.next();
        int first=s.nextInt();
        int second=s.nextInt();
        int third=s.nextInt();
        String thirdWord= s.next();
        int sum=first+second+third;

        System.out.printf("%s %s %s %d",firstWord,secondWord,thirdWord,sum);

    }
}
