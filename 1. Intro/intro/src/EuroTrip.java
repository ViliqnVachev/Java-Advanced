import java.math.BigDecimal;
import java.util.Scanner;

public class EuroTrip {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double quantity= Double.parseDouble(s.nextLine());
        double lv= 1.2;
        BigDecimal fullPriceInLv=new BigDecimal(quantity*lv);
        BigDecimal marksPerLv=new BigDecimal(4210500000000.0);
        BigDecimal marks=fullPriceInLv.multiply(marksPerLv);

        System.out.printf("%.2f marks",marks);

    }
}
