import java.security.SecureRandom;
import java.util.*;

public class Main {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_+=<>?/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        System.out.print("Enter the minimum password length: ");
        int minLength = scanner.nextInt();
        System.out.print("Enter the maximum password length: ");
        int maxLength = scanner.nextInt();

        if (minLength > maxLength) {
            System.out.println("Invalid input! Minimum length can't be greater than maximum length.");
            return;
        }

        System.out.print("Include lowercase letters? (y/n): ");
        boolean useLowercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean useUppercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include digits? (y/n): ");
        boolean useDigits = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include symbols? (y/n): ");
        boolean useSymbols = scanner.next().equalsIgnoreCase("y");

        String password = generatePassword(random, minLength, maxLength, useLowercase, useUppercase, useDigits, useSymbols);
        System.out.println("Generated Password: " + password);

        String strength = checkPasswordStrength(password);
        System.out.println("Password Strength: " + strength);
    }

    private static String generatePassword(SecureRandom random, int minLength, int maxLength,
                                           boolean useLowercase, boolean useUppercase, boolean useDigits, boolean useSymbols) {

        StringBuilder characterSet = new StringBuilder();
        if (useLowercase) characterSet.append(LOWERCASE);
        if (useUppercase) characterSet.append(UPPERCASE);
        if (useDigits) characterSet.append(DIGITS);
        if (useSymbols) characterSet.append(SYMBOLS);

        if (characterSet.length() == 0) {
            System.out.println("Invalid: At least one character type must be selected.");
            return "";
        }

        int length = random.nextInt(maxLength - minLength + 1) + minLength;

        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(randomIndex));
        }

        return password.toString();
    }

    private static String checkPasswordStrength(String password) {
        int length = password.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSymbol = false;

        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) hasLower = true;
            if (Character.isUpperCase(ch)) hasUpper = true;
            if (Character.isDigit(ch)) hasDigit = true;
            if (SYMBOLS.contains(String.valueOf(ch))) hasSymbol = true;
        }

        int score = 0;
        if (length >= 8) score++;
        if (hasLower) score++;
        if (hasUpper) score++;
        if (hasDigit) score++;
        if (hasSymbol) score++;

        if (score <= 1) {
            return "Weak";
        } else if (score <= 3) {
            return "Moderate";
        } else {
            return "Strong";
        }
    }
}
