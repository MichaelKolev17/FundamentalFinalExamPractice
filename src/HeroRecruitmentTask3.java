import java.util.*;

public class HeroRecruitmentTask3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, List> heroes = new LinkedHashMap<>();
        List<String> spellNames = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Enroll":
                    String name = tokens[1];
                    if (heroes.containsKey(name)) {
                        System.out.printf("%s is already enrolled.%n", name);
                        break;
                    }
                    heroes.putIfAbsent(name, spellNames);
                    break;
                case "Learn":
                    name = tokens[1];
                    String spellName = tokens[2];

                    if (heroes.containsKey(name)) {
                        if (spellNames.contains(spellName)) {
                            System.out.printf("%s has already learnt %s.%n", name, spellName);
                        } else {
                            spellNames.add(spellName);
                            heroes.put(name, spellNames);
                        }
                    } else {
                        System.out.printf("%s doesn't exist.%n", name);
                    }
                    break;
                case "Unlearn":
                    name = tokens[1];
                    String spellNameUnlearn = tokens[2];
                    if (!heroes.containsKey(name)) {
                        System.out.printf("%s doesn't exist.%n", name);
                        break;
                    }
                    if (spellNames.contains(spellNameUnlearn)) {
                        spellNames.remove(spellNameUnlearn);
                    } else {
                        System.out.printf("%s doesn't know %s.%n", name, spellNameUnlearn);
                    }
                    break;
            }

            input = scan.nextLine();
        }

        System.out.println("Heroes:");
        heroes
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getKey().compareTo(a.getKey()))
                .sorted((p, k) -> p.getKey().compareTo(k.getKey()))
                .forEach(h -> System.out.println("== " + h.getKey() + ":" + h.getValue().toString().replace("[", " ").replace("]", "")));
    }
}
