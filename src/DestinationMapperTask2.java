import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapperTask2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String regex = "([=/])(?<city>[A-Z][A-Za-z]{2,})(\\1)";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);
        List<String> cities = new ArrayList<>();

        int travelPoints = 0;

        while (matcher.find()) {

            String city = matcher.group("city");
            travelPoints += city.length();
            cities.add(city);

        }

        if (cities.size() == 0) {
            System.out.println("Destinations:" + cities.toString().replace("[", "").replace("]", ""));
        } else {
            String joined = String.join(", ", cities);
            System.out.println("Destinations: " + joined);
        }
        System.out.println("Travel Points: " + travelPoints);
    }
}
