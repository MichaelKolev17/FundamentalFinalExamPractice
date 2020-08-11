import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        final    Pattern pattern = Pattern.compile("^([\\D]+)\\>(?<numbers>[0-9]{3})\\|(?<low>[a-z]{3})\\|(?<up>[A-Z]{3})\\|(?<symbols>[^<>]{3})<(\\1)$");

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String encryptedPassword = matcher.group("numbers") +
                        matcher.group("low") +
                        matcher.group("up") +
                        matcher.group("symbols");
                System.out.println("Password: " + encryptedPassword);
            } else if (!matcher.find()){
                System.out.println("Try another password!");
            }
        }
    }
}