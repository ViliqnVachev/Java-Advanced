import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class AverageOfDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OptionalDouble avr =Arrays.stream(reader.readLine().split(" "))
                .filter(x->x.length()>0)
                .mapToDouble(Double::parseDouble)
                .average();
        if(avr.isPresent()){

            System.out.println(String.format("%.2f",avr.getAsDouble()));
        }else {
            System.out.println("No match");
        }
    }
}
