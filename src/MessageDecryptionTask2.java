import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecryptionTask2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        String regex = "^([$%])(?<tag>[A-Z][a-z]{2,})(\\1): \\[(?<first>\\d+)]\\|\\[(?<second>\\d+)]\\|\\[(?<third>\\d+)]\\|$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < number; i++) {
            String input = scan.nextLine();

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String tag = matcher.group("tag");
                String first = matcher.group("first");
                String second = matcher.group("second");
                String third = matcher.group("third");

                int firstNumber = Integer.parseInt(first);
                int secondNumber = Integer.parseInt(second);
                int thirdNumber = Integer.parseInt(third);
                char charOne = (char) firstNumber;
                char charTwo = (char) secondNumber;
                char charThree = (char) thirdNumber;

                System.out.printf("%s: %c%c%c%n", tag, charOne, charTwo, charThree);

            } else {
                System.out.println("Valid message not found!");
            }
        }


    }
}
