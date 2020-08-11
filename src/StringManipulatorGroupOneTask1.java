import java.util.Scanner;

public class StringManipulatorGroupOneTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputLine = scan.nextLine();
        String command = scan.nextLine();

        while (!"End".equals(command)) {
            String[] tokens = command.split("\\s+");
            String commandToDo = tokens[0];
            switch (commandToDo) {
                case "Translate":
                    String charInput = tokens[1];
                    String charReplacementInput = tokens[2];
                    char oldChar = charInput.charAt(0);
                    char newChar = charReplacementInput.charAt(0);
                    inputLine = inputLine.replace(oldChar, newChar);
                    System.out.println(inputLine);
                    break;
                case "Includes":
                    String stringIncludesInput = tokens[1];
                    if (inputLine.contains(stringIncludesInput)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    String startString = tokens[1];
                    int startStringLength = startString.length();
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < inputLine.length(); i++) {
                        if (i == startStringLength) {
                            break;
                        }
                        sb.append(inputLine.charAt(i));
                    }
                    if (sb.toString().equals(startString)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    inputLine = inputLine.toLowerCase();
                    System.out.println(inputLine);
                    break;
                case "FindIndex":
                     String indexCharInput = tokens[1];
                     char indexChar = indexCharInput.charAt(0);
                     int indexNeeded = 0;
                    for (int i = inputLine.length() - 1; i >= 0 ; i--) {
                        if (inputLine.charAt(i) == indexChar) {
                            indexNeeded = i;
                            break;
                        }
                    }
                    System.out.println(indexNeeded);
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int count = Integer.parseInt(tokens[2]);

                    String removedParts = inputLine.substring(startIndex, count);
                    inputLine = inputLine.replace(removedParts, "");
                    System.out.println(inputLine);
                    break;
            }

            command = scan.nextLine();
        }
    }
}
