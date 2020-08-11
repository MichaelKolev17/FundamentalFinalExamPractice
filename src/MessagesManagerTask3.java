import java.util.*;

public class MessagesManagerTask3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int capacity = Integer.parseInt(scan.nextLine());
        Map<String, Integer> sentMessagesMap = new TreeMap<>();
        Map<String, Integer> receivedMessagesMap = new TreeMap<>();
        String command = scan.nextLine();

        while (!"Statistics".equals(command)) {
            String[] tokens = command.split("=");
            String commandToDo = tokens[0];

            switch (commandToDo) {
                case "Add":
                    String username = tokens[1];
                    int sent = Integer.parseInt(tokens[2]);
                    int received = Integer.parseInt(tokens[3]);
                    if (!sentMessagesMap.containsKey(username)) {
                        sentMessagesMap.put(username, sent);
                        receivedMessagesMap.put(username, received);
                    }
                    break;
                case "Message":
                    String sender = tokens[1];
                    String receiver = tokens[2];
                    if (sentMessagesMap.containsKey(sender) && sentMessagesMap.containsKey(receiver)) {
                        int currentSentSender = sentMessagesMap.get(sender);
                        sentMessagesMap.put(sender, currentSentSender + 1);
                        int currentReceivedMessages = receivedMessagesMap.get(receiver);
                        receivedMessagesMap.put(receiver, currentReceivedMessages + 1);

                        int checkAmountSentMessages = sentMessagesMap.get(sender);
                        if (checkAmountSentMessages >= capacity) {
                            sentMessagesMap.remove(sender);
                            receivedMessagesMap.remove(sender);
                            System.out.printf("%s reached the capacity!%n", sender);
                            break;
                        }
                    }
                    int checkAmountReceivedMessages = receivedMessagesMap.get(receiver);
                    if (checkAmountReceivedMessages >= capacity) {
                        receivedMessagesMap.remove(receiver);
                        sentMessagesMap.remove(receiver);
                        System.out.printf("%s reached the capacity!%n", receiver);
                        break;
                    }
                    int amountSent = sentMessagesMap.get(sender);
                    int amountReceived = receivedMessagesMap.get(sender);
                    int total = amountSent + amountReceived;
                    if (total >= capacity) {
                        sentMessagesMap.remove(sender);
                        receivedMessagesMap.remove(sender);
                        System.out.printf("%s reached the capacity!%n", sender);
                        break;
                    }

                    int numberReceived = receivedMessagesMap.get(receiver);
                    int numberSent = sentMessagesMap.get(receiver);
                    int totalMessages = numberReceived + numberSent;
                    if (totalMessages >= capacity) {
                        sentMessagesMap.remove(receiver);
                        receivedMessagesMap.remove(receiver);
                        System.out.printf("%s reached the capacity!%n", receiver);
                        break;
                    }
                    break;
                case "Empty":
                    String emptyUsername = tokens[1];
                    if (emptyUsername.equals("All")) {
                        sentMessagesMap.clear();
                        receivedMessagesMap.clear();
                    }

                    if (sentMessagesMap.containsKey(emptyUsername)) {
                        sentMessagesMap.remove(emptyUsername);
                        receivedMessagesMap.remove(emptyUsername);
                    }
                    break;
            }

            command = scan.nextLine();
        }

        int userCount = sentMessagesMap.size();
        System.out.printf("Users count: %d%n", userCount);

        receivedMessagesMap
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
                .forEach(u -> System.out.printf("%s - %d%n", u.getKey(), u.getValue() + sentMessagesMap.get(u.getKey())));
    }
}
