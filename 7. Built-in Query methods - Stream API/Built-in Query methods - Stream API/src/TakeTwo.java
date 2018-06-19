import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String [] numbers=reader.readLine().split(" ");

       Arrays.stream(numbers).map(Integer::parseInt).filter(x->x>=10&&x<=20).distinct().limit(2)
               .forEach(x-> System.out.print(x+" "));
    }
}
