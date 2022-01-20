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
    @DisplayName("Tank is an object of war")
    void fillForm() {
        new Objects().openTestPage("https://demoqa.com/automation-practice-form")
        .inputPersonalData()
        .inputContacts()
        .inputSchoolStuff()
        .inputDate("31","March","2000")
        .submitForm()
        .assertForm();
    }
}
