import java.util.Scanner;

public class SecretChatTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String command = scan.nextLine();

        while (!"Reveal".equals(command)) {
            String[] tokens = command.split(":\\|:");
            String instruction = tokens[0];

            StringBuilder sbText = new StringBuilder();

            switch (instruction) {
                case "InsertSpace":
                    int indexInsert = Integer.parseInt(tokens[1]);
                    for (int i = 0; i < input.length(); i++) {
                        if (i == indexInsert) {
                            sbText.append(" ");
                        }
                        char current = input.charAt(i);
                        sbText.append(current);
                    }
                    input = sbText.toString();
                    System.out.println(input);
                    break;
                case "Reverse":
                    String substring = tokens[1];
                    StringBuilder reversedText = new StringBuilder();
                    for (int i = substring.length() - 1; i >= 0 ; i--) {
                        reversedText.append(substring.charAt(i));
                    }
                    if (input.contains(substring)) {
                        int startIndex = substring.indexOf(substring);
                        int lastIndex = substring.lastIndexOf(substring);
                       input = input.replace(substring, reversedText);
                        System.out.println(input);
                    } else {
                        System.out.println("error");
                }
                    break;
                case "ChangeAll":
                    String substringChange = tokens[1];
                    String replacement = tokens[2];
                    input = input.replace(substringChange, replacement);
                    System.out.println(input);
                    break;
            }

            command = scan.nextLine();
        }

        System.out.println("You have a new text message: " + input);
    }
}
