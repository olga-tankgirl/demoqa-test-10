package tankgirl.objects;

import com.github.javafaker.Faker;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Objects {
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String address = faker.address().fullAddress();
    String phone = faker.number().digits(10);

    public Objects openTestPage(String uri) {
        open(uri);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public Objects inputDate(String d, String m, String y){
        $("#dateOfBirthInput").scrollTo().click();
        $("[class*='month-select']").selectOption(m);
        $("[class*='year-select']").selectOption(y);
        $("[class*='day--031']").click();
        return this;
    }

    public Objects inputPersonalData(){
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        // gender
        $(".custom-radio:nth-child(1) .custom-control-label").click();
        //photo
        $("#uploadPicture").uploadFile(new File("src/test/resoures/1.jpg"));
        return this;
    }

    public Objects inputContacts(){
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(phone);
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();
        return this;
    }

    public Objects inputSchoolStuff(){
        $("#subjectsInput").setValue("Biology").pressEnter();
        $(".custom-checkbox:nth-child(1) .custom-control-label").click();
        return this;
    }

    public Objects submitForm(){
        $("#submit").scrollTo().click();
        return this;
    }

    public void assertForm(){
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(
                text(firstName + " " + lastName),
                text(email),
                text("Male"),
                text(phone),
                text("31 March,2000"),
                text("Biology"),
                text("Sports"),
                text("1.jpg"),
                text(address),
                text("Rajasthan Jaipur"));
    }
}
