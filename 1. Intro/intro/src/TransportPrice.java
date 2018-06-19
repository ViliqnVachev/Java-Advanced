import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int km = Integer.parseInt(s.nextLine());
        String dayTime = s.nextLine();
        double taxiTax = 0.70;
        double result=0.0;

        if (km < 20) {
            if (dayTime.equals("day")) {
                double dayTax = 0.79;
                result=(dayTax*km)+taxiTax;
            }else {
                double nightTax = 0.90;
                result=(nightTax*km)+taxiTax;
            }
        }else if (km>=20 &&km<100){
            double busTax = 0.09;
            result=(busTax*km);
        }else if (km>=100){
            double trainTax = 0.06;
            result=(trainTax*km);
        }
        System.out.printf("%.2f",result);
    }
}
