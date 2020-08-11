import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEncryptionTask2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        String regex = "([@*])(?<tag>[A-Z][a-z]{2,})(\\1): \\[(?<a>[A-Za-z])]\\|\\[(?<b>[A-Za-z])]\\|\\[(?<c>[A-Za-z])]\\|$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < number; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String tag = matcher.group("tag");
                String a = matcher.group("a");
                String b = matcher.group("b");
                String c = matcher.group("c");

                int numberA = a.charAt(0);
                int numberB = b.charAt(0);
                int numberC = c.charAt(0);

                System.out.printf("%s: %d %d %d%n", tag, numberA, numberB, numberC);

            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
