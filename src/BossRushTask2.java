import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRushTask2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scan.nextLine());

        String regex = "\\|(?<bossName>[A-Z]{4,})\\|:#(?<bossTitle>[A-Za-z]+\\s[A-Za-z]+)#";
        Pattern pattern = Pattern.compile(regex);

        Map<String, String> bossNameAndTitle = new LinkedHashMap<>();
        int strength = 0;
        int armour = 0;
        for (int i = 0; i < numberOfInputs; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String bossName = matcher.group("bossName");
                String title = matcher.group("bossTitle");
                strength = strength + bossName.length();
                armour += title.length();
                bossNameAndTitle.put(bossName, title);

                for (Map.Entry<String, String> stringStringEntry : bossNameAndTitle.entrySet()) {
                    System.out.println(stringStringEntry.getKey() + ", The " + stringStringEntry.getValue());
                    System.out.println(">> Strength: " + strength);
                    System.out.println(">> Armour: " + armour);
                }
            } else {
                System.out.println("Access denied!");
            }
        }

    }
}
