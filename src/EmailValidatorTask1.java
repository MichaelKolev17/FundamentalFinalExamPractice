import java.util.Scanner;

public class EmailValidatorTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String emailInput = scan.nextLine();
        String command = scan.nextLine();

        while (!"Complete".equals(command)) {
            String[] tokens = command.split("\\s+");
            String commandToDo = tokens[0];
            switch (commandToDo) {
                case "Make":
                    String caseLetters = tokens[1];
                    if ("Upper".equals(caseLetters)) {
                        emailInput = emailInput.toUpperCase();
                        System.out.println(emailInput);
                    } else if ("Lower".equals(caseLetters)) {
                        emailInput = emailInput.toLowerCase();
                        System.out.println(emailInput);
                    }
                    break;
                case "GetDomain":
                    int count = Integer.parseInt(tokens[1]);
                    int stringLength = emailInput.length();
                    String substringOne = emailInput.substring(0, stringLength - count);
                    int beginIndex = substringOne.length();
                    String printSubstring = emailInput.substring(beginIndex);
                    System.out.println(printSubstring);
                    break;
                case "GetUsername":
                    StringBuilder sb = new StringBuilder();
                    int charInt = 0;
                    for (int i = 0; i < emailInput.length(); i++) {
                        if (emailInput.charAt(i) == '@') {
                            charInt = i;
                        }
                    }
                    if (charInt == 0) {
                        System.out.printf("The email %s doesn't contain the @ symbol.%n", emailInput);
                    } else {
                        String substringToPrint = emailInput.substring(0, charInt );
                        System.out.println(substringToPrint);
                    }
                    break;
                case "Replace":
                    String replacement = tokens[1];
                    char charToInsert = replacement.charAt(0);
                    emailInput = emailInput.replace(charToInsert, '-');
                    System.out.println(emailInput);
                    break;
                case "Encrypt":
                    for (int i = 0; i < emailInput.length(); i++) {
                        int charCurrent = emailInput.charAt(i);
                        System.out.print(charCurrent + " ");
                    }
                    break;
            }

            command = scan.nextLine();
        }

    }
}
