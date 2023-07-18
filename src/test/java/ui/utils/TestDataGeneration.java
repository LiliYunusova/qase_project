package ui.utils;
import com.github.javafaker.Faker;

public class TestDataGeneration {

    private static Faker faker = new Faker();

    public static String getName() {
        return  faker.bothify("????");
    }

    public static String getPassword() {
        return  faker.bothify("####+?Ff????");
    }

    public static String getEmail(){
        return faker.internet().emailAddress();
    }


}
