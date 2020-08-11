import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationTask2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        String regex = "U\\$(?<username>[A-Z][a-z]{2,})U\\$P@\\$(?<password>[A-Za-z]{5,}[0-9]+)P@\\$";
       final Pattern pattern = Pattern.compile(regex);

        int countSuccess = 0;
        for (int i = 0; i < number; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String username = matcher.group("username");
                String password = matcher.group("password");

                System.out.println("Registration was successful");
                countSuccess++;
                System.out.printf("Username: %s, Password: %s%n", username, password);
            } else {
                System.out.println("Invalid username or password");
            }
        }

        System.out.println("Successful registrations: " + countSuccess);
    }
}
