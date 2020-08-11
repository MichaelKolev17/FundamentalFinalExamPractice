import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PiratesTask3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Map<String, Integer> population = new LinkedHashMap<>();
        Map<String, Integer> gold = new LinkedHashMap<>();

        while (!"Sail".equals(input)) {
            String[] parts = input.split("[|\\\\]");
            String cityName = parts[0];
            int populationInput = Integer.parseInt(parts[2]);
            int goldInput = Integer.parseInt(parts[4]);

            population.putIfAbsent(cityName, 0);
            int currentPopulation = population.get(cityName);
            int totalPopulation = currentPopulation + populationInput;
            population.put(cityName, totalPopulation);

            gold.putIfAbsent(cityName, 0);
            int currentGold = gold.get(cityName);
            int totalGold = currentGold + goldInput;
            gold.put(cityName, totalGold);

            input = scan.nextLine();
        }

        String command = scan.nextLine();
        while (!"End".equals(command)) {
            String[] tokens = command.split("=>");
            String commandTodo = tokens[0];

            switch (commandTodo) {
                case "Plunder":
                    String town = tokens[1];
                    int people = Integer.parseInt(tokens[2]);
                    int receivedGold = Integer.parseInt(tokens[3]);

                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, receivedGold, people);

                    int currentPopulation = population.get(town);
                    int currentGold = gold.get(town);
                    population.put(town, currentPopulation - people);
                    gold.put(town, currentGold - receivedGold);

                    if (population.get(town) <= 0) {
                        System.out.printf("%s has been wiped off the map!%n", town);
                        population.remove(town);
                        gold.remove(town);
                    } else if (gold.get(town) <= 0) {
                        System.out.printf("%s has been wiped off the map!%n", town);
                        gold.remove(town);
                        population.remove(town);
                    }
                    break;
                case "Prosper":
                    town = tokens[1];
                    receivedGold = Integer.parseInt(tokens[2]);

                    if (receivedGold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    } else {
                        int currentGoldSum = gold.get(town);
                        int total = currentGoldSum + receivedGold;
                        gold.put(town, total);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", receivedGold, town, total);
                    }
                    break;

            }

            command = scan.nextLine();
        }

        int countSettlements = population.size();
        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", countSettlements);

        gold
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(t -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", t.getKey(), population.get(t.getKey()), t.getValue()));

    }
}
