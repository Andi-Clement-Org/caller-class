package banker.services;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Utils {

    public Scanner scanner() {
        return new Scanner(System.in);
    }

    public static String generateRandomAlphaNumeric() {
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();
        return random
                .ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static Integer generateUuid(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static String generateCustomerEmailAddress(String full_name, String provider) {
        full_name = full_name.replaceAll(" ", "-").toLowerCase().trim();
        return full_name + "@" + provider + ".com";
    }

    public static String pickEmailProvider() {
        Random random = new Random();
        return Constants.EMAIL_PROVIDERS[random.nextInt(Constants.EMAIL_PROVIDERS.length)];
    }

    public static boolean isEmailAddress(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

}
