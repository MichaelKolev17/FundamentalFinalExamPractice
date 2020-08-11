import java.util.*;

public class NMealTask3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, List<String>> likedMeals = new LinkedHashMap<>();

        int unlikeCount = 0;
        while (!"Stop".equals(input)) {
            String[] tokens = input.split("-");
            String commandTodo = tokens[0];
            switch (commandTodo) {
                case "Like":
                    String guest = tokens[1];
                    String food = tokens[2];

                    likedMeals.putIfAbsent(guest, new ArrayList());
                    List<String> guestMeals = likedMeals.get(guest);

                    if (!guestMeals.contains(food)) {
                        guestMeals.add(food);
                    }
                    likedMeals.put(guest, guestMeals);
                    break;
                case "Unlike":
                    guest = tokens[1];
                    food = tokens[2];

                    if (!likedMeals.containsKey(guest)) {
                        System.out.printf("%s is not at the party.%n", guest);
                    } else {
                        List<String> meals = likedMeals.get(guest);
                        if (!meals.contains(food))  {
                            System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, food);
                        } else {
                            unlikeCount++;
                            meals.remove(food);
                            likedMeals.put(guest, meals);
                            System.out.printf("%s doesn't like the %s.", guest, food);
                        }
                    }

                    break;
            }

            input = scan.nextLine();
        }

        likedMeals
                .entrySet()
                .stream()
                .sorted((a,b) -> {
                    int res = b.getValue().size() - a.getValue().size();
                    if (res == 0) {
                        return a.getKey().compareTo(b.getKey());
                    } else {
                        return res;
                    }

                })
                .forEach(g -> System.out.println(g.getKey() + ": " + printList(g.getValue())));

        System.out.println("Unliked meals: " + unlikeCount);
    }

    private static String printList(List<String> value) {
        return value.toString().replaceAll("\\[]", "");
    }
}
