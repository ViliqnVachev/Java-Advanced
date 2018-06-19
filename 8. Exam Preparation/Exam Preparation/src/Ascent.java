import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        Map<String, String> memorize = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("[,|_][A-Za-z]+[0-9]");

        while (!"Ascend".equals(text)) {

            for (Map.Entry<String, String> pair : memorize.entrySet()) {

                text = text.replaceAll(pair.getKey(), pair.getValue());
            }


            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                String word = matcher.group();
                StringBuilder encodingWord = new StringBuilder();


                if (word.startsWith(",")) {
                    int number = Integer.parseInt(word.substring(word.length() - 1, word.length()));

                    for (int i = 1; i < word.length() - 1; i++) {
                        char ch = word.charAt(i);
                        int n = 0;
                        n = ch + number;
                        ch = (char) n;
                        encodingWord.append(ch);
                    }
                    text = text.replaceAll(word, encodingWord.toString());

                } else if (word.startsWith("_")) {
                    int number = Integer.parseInt(word.substring(word.length() - 1, word.length()));
                    for (int i = 1; i < word.length() - 1; i++) {
                        char ch = word.charAt(i);
                        int n = 0;
                        n = ch - number;
                        ch = (char) n;
                        encodingWord.append(ch);
                    }
                    text = text.replaceAll(word, encodingWord.toString());
                }
                // word=word.substring(1);
                //Pair<String, String> temp = new Pair<>(word, encodingWord.toString());
                memorize.put(word,encodingWord.toString());
            }
            System.out.println(text);

            text = reader.readLine();
        }
    }
}
