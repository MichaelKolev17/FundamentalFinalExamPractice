import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class StringManipulatorTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputString = scan.nextLine();
        String command = scan.nextLine();

        while (!"Done".equals(command)) {
            String[] tokens = command.split("\\s+");
            String commandToDo = tokens[0];

            switch (commandToDo) {
                case "Change":
                    String charInput = tokens[1];
                    String charReplacement = tokens[2];
                    char oldChar = charInput.charAt(0);
                    char newChar = charReplacement.charAt(0);
                    inputString = inputString.replace(oldChar, newChar);
                    System.out.println(inputString);
                    break;
                case "Includes":
                    String includesString = tokens[1];
                    if (inputString.contains(includesString)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String endString = tokens[1];
                    int endStringLength = endString.length();
                    String checkEndString = inputString.substring(endStringLength);
                    if (checkEndString.equals(endString)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    inputString = inputString.toUpperCase();
                    System.out.println(inputString);
                    break;
                case "FindIndex":
                    String givenCharIndex = tokens[1];
                    char indexChar = givenCharIndex.charAt(0);
                    int index = 0;
                    for (int i = 0; i < inputString.length(); i++) {
                        char current = inputString.charAt(i);
                        if (current == indexChar) {
                            index += i;
                            break;
                        }
                    }
                    System.out.println(index);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    String cutSubstring = inputString.substring(startIndex, length + startIndex);
                    System.out.println(cutSubstring);
                    break;
            }

            command = scan.nextLine();
        }
    }
}
