import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<String> te = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            te.add(i + "");
        }

        for (int i = 0; i < 2; i++) {
            te.remove(i);
        }
    }
}
