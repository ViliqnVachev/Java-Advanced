import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] userNames = s.nextLine().split("[\\\\,()\\/\\s]+");
        Pattern pattern = Pattern.compile("^[A-Za-z][\\w]{2,24}");
        List<String> validUserNames = new ArrayList<>();


        for (String userName : userNames) {
            Matcher matcher = pattern.matcher(userName);
            if (matcher.find() && userName.length() >= 3 && userName.length() <= 25) {
                validUserNames.add(userName);
            }
        }
        int position = 0;
        int sum = 0;

        for (int i = 0; i < validUserNames.size() - 1; i++) {
            if (validUserNames.get(i).length() + validUserNames.get(i + 1).length() > sum) {
                position = i;
                sum = validUserNames.get(i).length() + validUserNames.get(i + 1).length();
            }
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(validUserNames.get(position + i));
        }

    }
}
