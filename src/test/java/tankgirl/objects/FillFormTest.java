package tankgirl.objects;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FillFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1440x900";
    }

    @Test
    @DisplayName("Form filling in web-application")
    void fillForm() {
        Objects objects = new Objects();

        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue(objects.firstName);
        $("#lastName").setValue(objects.lastName);
        $("#userEmail").setValue(objects.email);
        $(".custom-radio:nth-child(1) .custom-control-label").click();
        $("#userNumber").setValue(objects.phone);

        $("#uploadPicture").uploadFile(new File("src/test/resoures/1.jpg"));
        $("#subjectsInput").setValue("Biology").pressEnter();
        $(".custom-checkbox:nth-child(1) .custom-control-label").click();
        $("#currentAddress").setValue(objects.address);
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();
        $("#submit").scrollTo().click();
        objects.inputDate("31","March","2000");
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(
                text(objects.firstName + " " + objects.lastName),
                text(objects.email),
                text("Male"),
                text(objects.phone),
                text("31 March,2000"),
                text("Biology"),
                text("Sports"),
                text("1.jpg"),
                text(objects.address),
                text("Rajasthan Jaipur"));
    }
}
