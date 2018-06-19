import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int operation = Integer.parseInt(s.nextLine());

        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<String> stackText = new ArrayDeque<>();
        try {
            for (int i = 0; i < operation; i++) {
                String[] comand = s.nextLine().split("\\s+");
                int typeComand = Integer.parseInt(comand[0]);

                switch (typeComand) {
                    //append text
                    case 1:
                        String text = comand[1];
                        sb.append(text);
                        stack.push(typeComand);
                        stackText.push(sb.toString());
                        break;

                    //erases
                    case 2:
                        int count = Integer.parseInt(comand[1]);
                        String helper = sb.toString();
                        helper = helper.substring(0, helper.length() - count);
                        sb = new StringBuilder(helper);
                        stack.push(typeComand);
                        stackText.push(sb.toString());
                        break;

                    //print
                    case 3:
                        int index = Integer.parseInt(comand[1]);
                        System.out.println(sb.charAt(index - 1));
                        break;

                    //undoes comands
                    case 4:
                        stack.pop();
                        stackText.pop();
                        String temp = stackText.pop();
                        sb = new StringBuilder(temp);
                        stackText.push(sb.toString());
                        break;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

