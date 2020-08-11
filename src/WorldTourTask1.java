import java.util.Scanner;

public class WorldTourTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputStops = scan.nextLine();
        String command = scan.nextLine();

        while (!"Travel".equals(command)) {
            String[] tokens = command.split(":");
            String commandToDo = tokens[0];
            switch (commandToDo) {
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    String stringGiven = tokens[2];
                    if (index >= 0 && index <= inputStops.length()) {
                        String firstSubstring = inputStops.substring(0, index);
                        String secondSubstring = inputStops.substring(index);
                        inputStops = firstSubstring + stringGiven + secondSubstring;
                        System.out.println(inputStops);
                    } else {
                        System.out.println(inputStops);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (endIndex < startIndex) {
                        System.out.println(inputStops);
                        break;
                    }
                    if (startIndex >= 0 && startIndex <= inputStops.length() && endIndex <= inputStops.length()) {
                        String substringToRemove = inputStops.substring(startIndex, endIndex + 1);
                        if (inputStops.contains(substringToRemove)) {
                            inputStops = inputStops.replace(substringToRemove, "");
                            System.out.println(inputStops);
                        }
                    } else {
                        System.out.println(inputStops);
                    }
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    if (inputStops.contains(oldString)) {
                        inputStops = inputStops.replaceAll(oldString, newString);
                    }
                    System.out.println(inputStops);
                    break;
            }

            command = scan.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s", inputStops);
    }
}
