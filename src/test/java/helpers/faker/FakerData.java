package helpers.faker;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerData {
    private Faker rufaker = new Faker(new Locale("ru"));
    public String position = rufaker.job().position();
    public String phone = rufaker.phoneNumber().subscriberNumber(10);
}
