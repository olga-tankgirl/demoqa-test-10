package tankgirl.objects;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        FakerData fakerData = new FakerData();
        new PractiveFormPage().openTestPage("https://demoqa.com/automation-practice-form")
        .inputPersonalData(fakerData.firstName, fakerData.lastName, "Male","src/test/resoures/1.jpg")
        .inputContacts(fakerData.email, fakerData.phone, fakerData.address, "Rajasthan", "Jaipur")
        .inputSchoolStuff("Biology", "1")
        .inputDate("31","March","2000")
        .submitForm()
        .assertForm(fakerData.firstName,
                fakerData.lastName,
                fakerData.email,
                "Male",
                fakerData.phone,
                "31 March,2000",
                "Biology",
                "Sports",
                "1.jpg",
                fakerData.address,
                "Rajasthan",
                "Jaipur");
    }
}
