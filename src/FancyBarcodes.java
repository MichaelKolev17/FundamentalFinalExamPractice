import java.util.Scanner;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countBarCodes = Integer.parseInt(scan.nextLine());
        char firstLetter = '@';
        char secondLetter = '#';

        for (int i = 0; i < countBarCodes; i++) {
            String barCode = scan.nextLine();
            StringBuilder symbols = new StringBuilder();
            StringBuilder text = new StringBuilder();
            boolean isInvalid = false;
            if (barCode.charAt(0) != firstLetter || barCode.charAt(1) != secondLetter) {
                System.out.println("Invalid barcode");
                continue;
            }

            for (int j = 2; j < barCode.length(); j++) {
                char currentChar = barCode.charAt(j);
                if (Character.isLetterOrDigit(currentChar) || currentChar == '@') {
                    text.append(currentChar);
                } else if (currentChar == '#') {
                    symbols.append(currentChar);
                } else {
                    System.out.println("Invalid barcode");
                    isInvalid = true;
                    break;
                }
            }
            if (isInvalid) {
                continue;
            }

            char upper = text.charAt(0);
            if (!Character.isUpperCase(upper)) {
                System.out.println("Invalid barcode");
                isInvalid = true;
                continue;
            }
            char lastCharIsUpper = text.charAt(text.length() - 2);
            if (!Character.isUpperCase(lastCharIsUpper)) {
                System.out.println("Invalid barcode");
                isInvalid = true;
                continue;
            }

            if (text.length() < 6) {
                System.out.println("Invalid barcode");
                isInvalid = true;
                continue;
            }

            char lastSymbol = text.charAt(text.length() - 1);
            if (lastSymbol != '@') {
                System.out.println("Invalid barcode");
                isInvalid = true;
                continue;
            }

            char checkLastSymbol = symbols.charAt(symbols.length() - 1);
            if (checkLastSymbol != '#') {
                System.out.println("Invalid barcode");
                isInvalid = true;
                continue;
            }

            StringBuilder productCode = new StringBuilder();
            for (int a = 0; a < text.length(); a++) {
                char currentChar = text.charAt(a);
                if (Character.isDigit(currentChar)) {
                    productCode.append(currentChar);
                }
            }
            if (productCode.length() == 0) {
                System.out.println("Product group: 00");
            } else {
                System.out.println("Product group: " + productCode);
            }
        }
    }
}