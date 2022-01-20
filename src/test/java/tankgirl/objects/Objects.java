package tankgirl.objects;

import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.$;

public class Objects {
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String address = faker.address().fullAddress();
    String phone = faker.number().digits(10);

    public void inputDate(String d, String m, String y){
        $("#dateOfBirthInput").scrollTo().click();
        $("[class*='month-select']").selectOption(m);
        $("[class*='year-select']").selectOption(y);
        $("[class*='day--031']").click();
    }


    }
