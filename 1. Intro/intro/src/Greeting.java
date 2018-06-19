import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String first= s.nextLine();
        String second= s.nextLine();

        if (first.isEmpty()){
            first="*****";
        }
        if(second.isEmpty()){
            second="*****";
        }

        System.out.printf("Hello, %s %s!",first,second);
    }
}
