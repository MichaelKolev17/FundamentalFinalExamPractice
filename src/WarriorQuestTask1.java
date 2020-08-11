import java.util.Scanner;

public class WarriorQuestTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String skillInput = scan.nextLine();
        String command = scan.nextLine();

        while (!"For Azeroth".equals(command)) {
            String[] tokens = command.split("\\s+");
            String commandToDo = tokens[0];

            switch (commandToDo) {
                case "GladiatorStance":
                    skillInput = skillInput.toUpperCase();
                    System.out.println(skillInput);
                    break;
                case "DefensiveStance":
                    skillInput = skillInput.toLowerCase();
                    System.out.println(skillInput);
                    break;
                case "Dispel":
                    int indexDispel = Integer.parseInt(tokens[1]);
                    String letter = tokens[2];
                    StringBuilder sb = new StringBuilder();
                    if (indexDispel > skillInput.length()) {
                        System.out.println("Dispel too weak.");
                    } else {
                        for (int i = 0; i < skillInput.length(); i++) {
                            char current = skillInput.charAt(i);
                            if (indexDispel == i) {
                                sb.append(letter);
                                continue;
                            }
                            sb.append(current);
                        }
                        System.out.println("Success!");
                        skillInput = sb.toString();
                    }
                    break;
                case "Target":
                    String operation = tokens[1];

                    if ("Change".equals(operation)) {
                        String substring = tokens[2];
                        String secondSubstring = tokens[3];
                        skillInput = skillInput.replace(substring, secondSubstring);
                        System.out.println(skillInput);
                    } else if ("Remove".equals(operation)) {
                        String substring = tokens[2];
                        skillInput = skillInput.replace(substring, "");
                        System.out.println(skillInput);
                    }
                    break;
                default:
                    System.out.println("Command doesn't exist!");
            }

            command = scan.nextLine();
        }

    }
}
