import java.util.*;

public class PlantDiscoveryTask3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        Map<String, Integer> plantsRarityMap = new LinkedHashMap<>();
        Map<String, List<Double>> ratingMap = new LinkedHashMap<>();

        for (int i = 0; i < number; i++) {
            String inputPlants = scan.nextLine();
            String[] tokens = inputPlants.split("<->");
            String plantName = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);

            plantsRarityMap.put(plantName, rarity);
            ratingMap.put(plantName, new ArrayList<>());
        }

        String command = scan.nextLine();
        while (!"Exhibition".equals(command)) {
            String[] tokens = command.split("\\s+");
            String commandToDo = tokens[0];

            switch (commandToDo) {
                case "Rate:":
                    String plantReceived = tokens[1];
                    double rating = Double.parseDouble(tokens[3]);
                    if (plantsRarityMap.containsKey(plantReceived)) {
                        List<Double> ratings = ratingMap.get(plantReceived);
                        ratings.add(rating);
                        ratingMap.put(plantReceived, ratings);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update:":
                    String updatePlant = tokens[1];
                    int newRarity = Integer.parseInt(tokens[3]);
                    if (plantsRarityMap.containsKey(updatePlant)) {
                        plantsRarityMap.put(updatePlant, newRarity);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset:":
                    String resetPlant = tokens[1];
                    if (ratingMap.containsKey(resetPlant)) {
                        List<Double> removedRatings = ratingMap.get(resetPlant);
                        removedRatings.clear();
                        ratingMap.put(resetPlant, removedRatings);
                    } else {
                        System.out.println("error");
                    }
                    break;
            }

            command = scan.nextLine();
        }

        Map<String, Double> averageMap = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> stringListEntry : ratingMap.entrySet()) {
            String username = stringListEntry.getKey();
            double average = stringListEntry.getValue().stream().mapToDouble(val -> val).average().orElse(0.0);
            averageMap.put(username, average);
        }




        System.out.println("Plants for the exhibition:");

        plantsRarityMap
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    int first = a.getValue();
                    int second = b.getValue();
                    if (first == second) {
                        return b.getKey().compareTo(a.getKey());
                    } else {
                        return Integer.compare(second, first);
                    }
                })
                .forEach(p -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", p.getKey(), p.getValue(), averageMap.get(p.getKey())));
    }
}


//    }
//}
