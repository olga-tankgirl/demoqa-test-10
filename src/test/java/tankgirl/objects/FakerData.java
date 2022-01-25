package tankgirl.objects;

import com.github.javafaker.Faker;

public class FakerData {
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String address = faker.address().fullAddress();
    String phone = faker.number().digits(10);
}
