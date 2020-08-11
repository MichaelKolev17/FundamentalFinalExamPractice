import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FollowersTask3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Map<String, Integer> mapUsers = new LinkedHashMap<>();

        while (!"Log out".equals(input)) {
            String[] tokens = input.split(": ");
            String command = tokens[0];

            switch (command) {
                case "New follower":
                    String username = tokens[1];
                    mapUsers.putIfAbsent(username, 0);
                    break;
                case "Like":
                    username = tokens[1];
                    int count = Integer.parseInt(tokens[2]);
                    if (!mapUsers.containsKey(username)) {
                        mapUsers.put(username, count);
                    } else {
                        int current = mapUsers.get(username);
                        mapUsers.put(username,current + count);
                    }
                    break;
                case "Comment":
                    username = tokens[1];
                    if (mapUsers.containsKey(username)) {
                        int current = mapUsers.get(username);
                        mapUsers.put(username, current + 1);
                    } else {
                        mapUsers.put(username, 1);
                    }
                    break;
                case "Blocked":
                    username = tokens[1];
                    if (mapUsers.containsKey(username)) {
                        mapUsers.remove(username);
                    } else {
                        System.out.printf("%s doesn't exist.%n", username);
                    }
                    break;
            }

            input = scan.nextLine();
        }

        System.out.println(String.format("%d followers", mapUsers.size()));

        mapUsers
                .entrySet()
                .stream()
                .sorted((a,b) -> {
                    int first = a.getValue();
                    int second = b.getValue();
                    if (a == b) {
                        return a.getKey().compareTo(b.getKey());
                    } else {
                        return Integer.compare(second, first);
                    }
                })
                .forEach(u -> System.out.printf("%s: %d%n", u.getKey(), u.getValue()));

    }
}
