import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BattleManagerTask3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Map<String, Integer> healthMap = new LinkedHashMap<>();
        Map<String, Integer> energyMap = new LinkedHashMap<>();

        while (!"Results".equals(input)) {
            String[] tokens = input.split(":");
            String commandToDo = tokens[0];
            switch (commandToDo) {
                case "Add":
                    String personName = tokens[1];
                    int health = Integer.parseInt(tokens[2]);
                    int energy = Integer.parseInt(tokens[3]);

                    if (healthMap.containsKey(personName)) {
                        int currentHealth = healthMap.get(personName);
                        healthMap.put(personName, health + currentHealth);
                    } else {
                        healthMap.put(personName, health);
                    }
                    energyMap.putIfAbsent(personName, energy);
                    break;
                case "Attack":
                    String attackerName = tokens[1];
                    String defenderName = tokens[2];
                    int damage = Integer.parseInt(tokens[3]);

                    if (healthMap.containsKey(attackerName) && healthMap.containsKey(defenderName)) {
                        int defenderHealth = healthMap.get(defenderName);
                        healthMap.put(defenderName, defenderHealth - damage);
                        int checkHealth = healthMap.get(defenderName);
                        if (checkHealth == 0 || checkHealth < 0) {
                            healthMap.remove(defenderName);
                            energyMap.remove(defenderName);
                            System.out.println(String.format("%s was disqualified!", defenderName));
                        }

                        int currentEnergy = energyMap.get(attackerName);
                        energyMap.put(attackerName, currentEnergy - 1);
                        int checkEnergy = energyMap.get(attackerName);
                        if (checkEnergy == 0) {
                            energyMap.remove(attackerName);
                            healthMap.remove(attackerName);
                            System.out.println(String.format("%s was disqualified!", attackerName));
                        }
                    }
                    break;
                case "Delete":
                    String username = tokens[1];
                    if ("All".equals(username)) {
                        healthMap.clear();
                        energyMap.clear();
                    } else if (healthMap.containsKey(username)) {
                        healthMap.remove(username);
                        energyMap.remove(username);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        int peopleCount = healthMap.size();
        System.out.println("People count: " + peopleCount);

        healthMap
                .entrySet()
                .stream()
                .sorted((a,b) -> {
                    int first = a.getValue();
                    int second = b.getValue();
                    if (first == second) {
                        return a.getKey().compareTo(b.getKey());
                    } else {
                        return Integer.compare(second, first);
                    }
                })
                .forEach(p -> System.out.printf("%s - %d - %d%n", p.getKey(), p.getValue(), energyMap.get(p.getKey())));

    }
}
