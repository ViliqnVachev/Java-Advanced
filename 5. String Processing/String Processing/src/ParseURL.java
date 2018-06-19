import java.util.Scanner;

public class ParseURL {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] url = s.nextLine().split("://");
        if (url.length != 2) {
            System.out.println("Invalid URL");
            return;
        }
        String protocol = url[0];

        String[] temp = url[1].split("/");
        String server = temp[0];

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < temp.length; i++) {
            if (i == temp.length - 1) {
                sb.append(temp[i]);
            } else {
                sb.append(temp[i]).append("/");
            }
        }

        System.out.println("Protocol = " + protocol);
        System.out.println("Server = " + server);
        System.out.println("Resources = " + sb);
    }
}
