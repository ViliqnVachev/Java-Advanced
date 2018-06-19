import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<String> parking = new HashSet<>();

        String line = s.nextLine();
        while (!"END".equals(line)) {

            String[] tokens = line.split(", ");
            String type = tokens[0];
            String plate = tokens[1];

            if ("IN".equals(type)) {
                parking.add(plate);
            } else {
                parking.remove(plate);
            }
            line = s.nextLine();
        }
        if(parking.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        else {
            for (String s1 : parking) {
                System.out.println(s1);
            }
        }

    }
}
