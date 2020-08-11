import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicTask3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberHeroes = Integer.parseInt(scan.nextLine());
        Map<String, Integer> hpMap = new LinkedHashMap<>();
        Map<String, Integer> mpMap = new LinkedHashMap<>();

        for (int i = 0; i < numberHeroes; i++) {
            String input = scan.nextLine();
            String[] parts = input.split("\\s+");
            String heroName = parts[0];
            int hitPoints = Integer.parseInt(parts[1]);
            int mPoints = Integer.parseInt(parts[2]);

            hpMap.putIfAbsent(heroName, hitPoints);
            mpMap.putIfAbsent(heroName, mPoints);
        }

        String command = scan.nextLine();
        while (!"End".equals(command)) {
            String[] tokens = command.split(" - ");
            String commandToDo = tokens[0];

            switch (commandToDo) {
                case "CastSpell":
                    String name = tokens[1];
                    int mpNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];

                    if (mpMap.get(name) >= mpNeeded) {
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", name, spellName, mpMap.get(name) - mpNeeded);
                        mpMap.put(name, mpMap.get(name) - mpNeeded);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", name, spellName);
                    }
                    break;
                case "TakeDamage":
                    name = tokens[1];
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];

                    int currentHealth = hpMap.get(name) - damage;
                    if (currentHealth > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", name, damage, attacker, currentHealth);
                        hpMap.put(name, hpMap.get(name) - damage);
                    } else {
                        System.out.printf("%s has been killed by %s!%n", name, attacker);
                        hpMap.remove(name);
                        mpMap.remove(name);
                    }
                    break;
                case "Recharge":
                    name = tokens[1];
                    int amount = Integer.parseInt(tokens[2]);

                    int currentMPoints = mpMap.get(name);
                    if (currentMPoints + amount > 200) {
                        int pointsFit = 200 - mpMap.get(name);
                        mpMap.put(name, 200);
                        System.out.printf("%s recharged for %d MP!%n", name, pointsFit);
                    } else {
                        mpMap.put(name, currentMPoints + amount);
                        System.out.printf("%s recharged for %d MP!%n", name, amount);
                        mpMap.put(name, currentMPoints + amount);
                    }
                    break;
                case "Heal":
                    name = tokens[1];
                    int healAmount = Integer.parseInt(tokens[2]);

                    int currentHealPoints = hpMap.get(name);
                    if (currentHealPoints + healAmount > 100) {
                        int pointsToFit = 100 - currentHealPoints;
                        hpMap.put(name, 100);
                        System.out.printf("%s healed for %d HP!%n", name , pointsToFit);
                        break;
                    } else {
                        hpMap.put(name, currentHealPoints + healAmount);
                        System.out.printf("%s healed for %d HP!%n", name, healAmount);
                    }
                    break;
            }
            command = scan.nextLine();
        }

        hpMap
                .entrySet()
                .stream()
                .sorted((a , b) -> b.getValue().compareTo(a.getValue()))
                .forEach(h -> System.out.printf("%s%n  HP: %d%n  MP: %d%n", h.getKey(), h.getValue(), mpMap.get(h.getKey())));


    }
}
