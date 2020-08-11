import java.util.*;

public class InboxManagerTask3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Map<String, List<String>> users = new HashMap<>();


        while (!"Statistics".equals(input)) {
            String[] tokens = input.split("->");
            String commandToDo = tokens[0];

            switch (commandToDo) {
                case "Add":
                    String username = tokens[1];
                    if (users.containsKey(username)) {
                        System.out.printf("%s is already registered%n", username);
                    } else {
                        users.put(username, new ArrayList<>());
                    }
                    break;
                case "Send":
                    username = tokens[1];
                    String email = tokens[2];

                    List<String> userEmail = users.get(username);
                    if (!userEmail.contains(email)) {
                        userEmail.add(email);
                    }
                    users.put(username, userEmail);
                    break;
                case "Delete":
                    username = tokens[1];
                    if (users.containsKey(username)) {
                        users.remove(username);
                    } else {
                        System.out.printf("%s not found!%n", username);
                    }
                    break;
            }

            input = scan.nextLine();
        }

        System.out.println(String.format("Users count: %s",users.size()));
        users
                .entrySet()
                .stream()
                .sorted((a,b) -> {
                    int result = b.getValue().size() - a.getValue().size();
                    if (result == 0) {
                        return a.getKey().compareTo(b.getKey());
                    } else {
                        return result;
                    }
                })
                .forEach(u -> {
                    System.out.println(u.getKey());
                    for (String z: u.getValue()) {
                        System.out.println(String.format(" - %s", z));
                    }
                });

    }


}
