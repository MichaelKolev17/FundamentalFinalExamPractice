import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeedTask3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scan.nextLine());

        Map<String, Integer> carDistanceMap = new LinkedHashMap<>();
        Map<String, Integer> carFuelMap = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] inputCars = scan.nextLine().split("\\|");
            String car = inputCars[0];
            int mileage = Integer.parseInt(inputCars[1]);
            int fuel = Integer.parseInt(inputCars[2]);

            carDistanceMap.putIfAbsent(car, 0);
            carDistanceMap.put(car, mileage);

            carFuelMap.putIfAbsent(car, 0);
            carFuelMap.put(car, fuel);
        }

        String command = scan.nextLine();

        while (!"Stop".equals(command)) {
            String[] tokens = command.split(" : ");
            String commandToDo = tokens[0];

            switch (commandToDo) {
                case "Drive":
                    String car = tokens[1];
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);

                    if (carFuelMap.get(car) < fuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        int currentMileage = carDistanceMap.get(car);
                        int newMileage = currentMileage + distance;
                        carDistanceMap.put(car, newMileage);
                        System.out.println(String.format("%s driven for %d kilometers. %d liters of fuel consumed.", car, distance, fuel));
                        if (carDistanceMap.get(car) > 100_000) {
                            System.out.printf("Time to sell the %s!%n", car);
                            carDistanceMap.remove(car);
                            break;
                        }

                        int currentFuel = carFuelMap.get(car);
                        int newFuel = currentFuel - fuel;
                        carFuelMap.put(car, newFuel);

                    }
                    break;
                case "Refuel":
                    String carForFuel = tokens[1];
                    int fuelToRefuel = Integer.parseInt(tokens[2]);

                    if (carFuelMap.containsKey(carForFuel)) {
                        int currentFuel = carFuelMap.get(carForFuel);
                        int totalFuel = currentFuel + fuelToRefuel;
                        if (carFuelMap.get(carForFuel) + fuelToRefuel >= 75) {
                            int fuelToFit = 75 - carFuelMap.get(carForFuel);
                            carFuelMap.put(carForFuel, 75);
                            System.out.printf("%s refueled with %d liters%n", carForFuel, fuelToFit);
                            break;
                        }
                        carFuelMap.put(carForFuel, totalFuel);
                    }
                    System.out.println(String.format("%s refueled with %d liters", carForFuel, fuelToRefuel));
                    break;
                case "Revert":
                    String carToRevert = tokens[1];
                    int kilometersToRevert = Integer.parseInt(tokens[2]);
                    int currentKilometers = carDistanceMap.get(carToRevert);
                    int revertedKm = currentKilometers - kilometersToRevert;
                    carDistanceMap.put(carToRevert, revertedKm);
                    if (carDistanceMap.get(carToRevert) < 10_000) {
                        carDistanceMap.put(carToRevert, 10_000);
                        break;
                    }
                    System.out.println(String.format("%s mileage decreased by %d kilometers", carToRevert, kilometersToRevert));
                    break;
            }

            command = scan.nextLine();
        }

        carDistanceMap
                .entrySet()
                .stream()
                .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                .forEach(c -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt. %n", c.getKey(), c.getValue(), carFuelMap.get(c.getKey())));

    }
}
