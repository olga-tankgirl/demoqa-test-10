package tankgirl.objects;

import com.github.javafaker.Faker;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PractiveFormPage {


    public PractiveFormPage openTestPage(String uri) {
        open(uri);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public PractiveFormPage inputDate(String d, String m, String y) {
        $("#dateOfBirthInput").scrollTo().click();
        $("[class*='month-select']").selectOption(m);
        $("[class*='year-select']").selectOption(y);
        $("[class*='day--0" + d + "']").click();
        return this;
    }

    public PractiveFormPage inputPersonalData(String firstName, String lastName, String gender, String photo) {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        // gender
        $("#genterWrapper").$(byText(gender)).click();
        //photo
        $("#uploadPicture").uploadFile(new File(photo));
        return this;
    }

    public PractiveFormPage inputContacts(String email, String phone, String address, String state, String city) {
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(phone);
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }

    public PractiveFormPage inputSchoolStuff(String subject, String hobby) {
        $("#subjectsInput").setValue(subject).pressEnter();
        $(".custom-checkbox:nth-child(" + hobby + ") .custom-control-label").click();
        return this;
    }

    public PractiveFormPage submitForm() {
        $("#submit").scrollTo().click();
        return this;
    }

    public PractiveFormPage assertFormSubmitted() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public PractiveFormPage assertForm(String ass) {
        $(".modal-content").shouldHave(text(ass));
        return this;
    }
}
