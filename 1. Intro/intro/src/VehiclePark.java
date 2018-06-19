import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehiclePark {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] line = s.nextLine().split(" ");
        List<String> cars = new ArrayList<>();
        int soldCars = 0;
        for (String car : line) {
            cars.add(car);
        }
        int price = 0;
        String searchingCar = s.nextLine();

        while (!searchingCar.equals("End of customers!")) {

            String car = searchingCar.split(" ")[0].toLowerCase();
            int searchingSeats = Integer.parseInt(searchingCar.split(" ")[2]);
            char ch = car.charAt(0);
            boolean isMatch = false;

            for (int i = 0; i < cars.size(); i++) {

                String tempCar = cars.get(i);
                char temp = tempCar.charAt(0);
                tempCar = tempCar.substring(1);


                int seats = Integer.parseInt(tempCar);
                if (ch == temp && searchingSeats == seats) {
                    isMatch = true;
                    price = temp * seats;

                    cars.remove(i);
                    soldCars++;
                    i--;
                    break;
                }


            }
            if (isMatch) {
                System.out.printf("Yes, sold for %d$%n", price);
            } else {
                System.out.println("No");
            }
            searchingCar = s.nextLine();
        }

        System.out.println("Vehicles left: " + String.join(", ", cars));
        System.out.println("Vehicles sold: " + soldCars);
    }
}
