import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslatorTask2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        String regex = "!(?<command>[A-Z][a-z]{3,})!:\\[(?<message>[A-Za-z]{8,}+)]";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < number; i++) {
            String input = scan.nextLine();

            Matcher matcher = pattern.matcher(input);

            List<Integer> numbersList = new ArrayList<>();

            if (matcher.find()) {
                String command = matcher.group("command");
                String message = matcher.group("message");

                for (int j = 0; j <message.length() ; j++) {
                    int charCurrent = message.charAt(j);
                    numbersList.add(charCurrent);
                }

                System.out.println(command + ": " + numbersList.toString().replace("[", "").replace(",","").replace("]", ""));
            } else {
                System.out.println("The message is invalid");
            }



        }
    }
}
