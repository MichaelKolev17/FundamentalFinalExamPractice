import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rawActivationKey = scan.nextLine();
        String instructions = scan.nextLine();

        for (int i = 0; i < rawActivationKey.length(); i++) {
            char current = rawActivationKey.charAt(i);
            if (!Character.isLetterOrDigit(current)) {
                return;
            }
        }

        while (!"Generate".equals(instructions)) {
            String[] tokens = instructions.split(">>>");
            String command = tokens[0];

            switch (command) {
                case "Contains":
                    String substring = tokens[1];
                    if (rawActivationKey.contains(substring)) {
                        System.out.printf("%s contains %s.", rawActivationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperOrLower = tokens[1];
                    if ("Upper".equals(upperOrLower)) {
                        int startIndex = Integer.parseInt(tokens[2]);
                        int endIndex = Integer.parseInt(tokens[3]);
                        String upperCase = rawActivationKey.substring(startIndex, endIndex).toUpperCase();
                        String firstPart = rawActivationKey.substring(0, startIndex);
                        String secondPart = rawActivationKey.substring(endIndex);
                        rawActivationKey = firstPart + upperCase + secondPart;
                        System.out.println(rawActivationKey);
                    } else {
                        int startIndex = Integer.parseInt(tokens[2]);
                        int endIndex = Integer.parseInt(tokens[3]);
                        String toLowerCase = rawActivationKey.substring(startIndex, endIndex).toLowerCase();
                        String firstPart = rawActivationKey.substring(0, startIndex);
                        String secondPart = rawActivationKey.substring(endIndex);
                        rawActivationKey = firstPart + toLowerCase + secondPart;
                        System.out.println(rawActivationKey);
                    }
                    break;
                case "Slice":
                    int startSliceIndex = Integer.parseInt(tokens[1]);
                    int endSliceIndex = Integer.parseInt(tokens[2]);
                    String deleteText = rawActivationKey.substring(startSliceIndex, endSliceIndex);
                    String firstPartNewText = rawActivationKey.substring(0, startSliceIndex);
                    String secondPartNewText = rawActivationKey.substring(endSliceIndex);
                    rawActivationKey = firstPartNewText + secondPartNewText;
                    System.out.println(rawActivationKey);
                    break;
            }

            instructions = scan.nextLine();
        }
        System.out.println("Your activation key is: " + rawActivationKey);
    }
}
