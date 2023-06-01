package test.automation.utils;

import com.github.javafaker.Faker;

public class FakerUtil {
    private static Faker faker = new Faker();

    public static String getFakeName() {
        return faker.name().fullName();
    }

    public static String getFakeAccountNumber() {
        return faker.number().digits(12);
    }

    public static String getFakeAddress() {
        return faker.address().fullAddress();
    }

    public static String getChuckNorrisFact() {
        return faker.chuckNorris().fact();
    }

    public static String getFakeEmail() {
        return faker.internet().emailAddress();
    }

    public static String getFakePhoneNumberl(String prefix, int digits) {
        return prefix + faker.number().digits(digits);
    }
}
