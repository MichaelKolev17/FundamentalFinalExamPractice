import java.util.Scanner;

public class NCharityTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String command = scan.nextLine();

        while (!"Finish".equals(command)) {
            String[] tokens = command.split("\\s+");
            String commandToDo = tokens[0];

            switch (commandToDo) {
                case "Replace":
                    String firstChar = tokens[1];
                    char currentChar = firstChar.charAt(0);
                    String secondChar = tokens[2];
                    char newChar = secondChar.charAt(0);

                    input = input.replace(currentChar, newChar);
                    System.out.println(input);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex < 0 || startIndex > input.length()) {
                        System.out.println("Invalid indexes!");
                        break;
                    } else if (endIndex < 0 || endIndex > input.length()) {
                        System.out.println("Invalid indexes!");
                        break;
                    }

                    StringBuilder sbSubstring = new StringBuilder();
                    for (int i = startIndex; i < input.length(); i++) {
                        char current = input.charAt(i);
                        sbSubstring.append(current);
                        if (i == endIndex) {
                            break;
                        }
                    }
                    input = input.replace(sbSubstring.toString(), "");
                    System.out.println(input);
                    break;
                case "Make":
                    if (tokens[1].equals("Upper")) {
                        input = input.toUpperCase();
                        System.out.println(input);
                    } else if (tokens[1].equals("Lower")) {
                        input = input.toLowerCase();
                        System.out.println(input);
                    }
                    break;
                case "Check":
                    String text = tokens[1];
                    if (input.contains(text)) {
                        System.out.println("Message contains " + text);
                    } else {
                        System.out.printf("Message doesn't contain %s%n", text);
                    }
                    break;
                case "Sum":
                    int start = Integer.parseInt(tokens[1]);
                    int end = Integer.parseInt(tokens[2]);

                    if (start < 0 || start > input.length()) {
                        System.out.println("Invalid indexes!");
                        break;
                    } else if (end < 0 || end > input.length()) {
                        System.out.println("Invalid indexes!");
                        break;
                    }

                    StringBuilder sumText = new StringBuilder();
                    for (int i = start; i < input.length(); i++) {
                        char current = input.charAt(i);
                        sumText.append(current);
                        if (i == end) {
                            break;
                        }
                    }

                    int sumSubstring = 0;
                    for (int i = 0; i < sumText.length(); i++) {
                        int currentSymbol = (int) sumText.charAt(i);
                        sumSubstring += currentSymbol;
                    }
                    System.out.println(sumSubstring);
                    break;
            }

            command = scan.nextLine();
        }
    }
}
