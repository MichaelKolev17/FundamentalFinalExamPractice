import java.util.Scanner;

public class UsernameTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String command = scan.nextLine();

        while (!"Sign up".equals(command)) {
            String[] tokens = command.split("\\s+");
            String commandToDo = tokens[0];

            switch (commandToDo) {
                case "Case":
                    String textCase = tokens[1];
                    if ("lower".equals(textCase)) {
                        input = input.toLowerCase();
                        System.out.println(input);
                    } else if ("upper".equals(textCase)) {
                        input = input.toUpperCase();
                        System.out.println(input);
                    }
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex > input.length() || endIndex > input.length()) {
                        break;
                    }
                    String substring = input.substring(startIndex, endIndex + 1);
                    StringBuilder sb = new StringBuilder();
                    for (int i = substring.length() - 1; i >= 0; i--) {
                        char current = substring.charAt(i);
                        sb.append(current);
                    }
                    System.out.println(sb);
                    break;
                case "Cut":
                    String cutSubstring = tokens[1];
                    if (input.contains(cutSubstring)) {
                        input = input.replaceAll(cutSubstring, "");
                        System.out.println(input);
                    } else {
                        System.out.printf("The word %s doesn't contain %s.%n", input, cutSubstring);
                    }
                    break;
                case "Replace":
                    String charInput = tokens[1];
                    char replacementChar = charInput.charAt(0);
                    input = input.replace(replacementChar, '*');
                    System.out.println(input);
                    break;
                case "Check":
                    String checkChar = tokens[1];
                    char validChar = checkChar.charAt(0);
                    boolean isValid = false;
                    for (int i = 0; i < input.length(); i++) {
                        char current = input.charAt(i);
                        if (current == validChar) {
                            isValid = true;
                        }
                    }
                    if (isValid) {
                        System.out.println("Valid");
                    } else {
                        System.out.printf("Your username must contain %s.%n", checkChar);
                    }
                    break;
            }
            command = scan.nextLine();
        }
    }
}
