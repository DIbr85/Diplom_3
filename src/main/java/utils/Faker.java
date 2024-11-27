package utils;


public class Faker {
    public static String fakerName() {
        com.github.javafaker.Faker faker = new com.github.javafaker.Faker();
        return faker.name().fullName();
    }

    public static String fakerEmail() {
        com.github.javafaker.Faker faker = new com.github.javafaker.Faker();
        return faker.internet().emailAddress();
    }

    public static String fakerValidPassword() {
        com.github.javafaker.Faker faker = new com.github.javafaker.Faker();
        return faker.internet().password(6, 8);
    }

    public static String fakerNotValidPassword() {
        com.github.javafaker.Faker faker = new com.github.javafaker.Faker();
        return faker.internet().password(1, 5);

    }
}
