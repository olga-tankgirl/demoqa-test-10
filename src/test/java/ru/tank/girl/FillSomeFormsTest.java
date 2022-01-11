package ru.tank.girl;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FillSomeFormsTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1440x900";
    }

    @Test
    void fillForm() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Testname");
        $("#lastName").setValue("Testlastname");
        $("#userEmail").setValue("testmail@mail.ru");
        $(".custom-radio:nth-child(1) .custom-control-label").click();
        $("#userNumber").setValue("3322332233");
        $("#dateOfBirthInput").scrollTo().click();
        $("[class*='month-select']").selectOption("March");
        $("[class*='year-select']").selectOption("2000");
        $("[class*='day--031']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resoures/1.jpg"));
        $("#subjectsInput").setValue("Biology").pressEnter();
        $(".custom-checkbox:nth-child(1) .custom-control-label").click();
        $("#currentAddress").setValue("Testaddress");
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();
        $("#submit").scrollTo().click();
        $(".modal-content").shouldHave(
                text("Testname Testlastname"),
                text("testmail@mail.ru"),
                text("Male"),
                text("3322332233"),
                text("31 March,2000"),
                text("Biology"),
                text("Sports"),
                text("1.jpg"),
                text("Testaddress"),
                text("Rajasthan Jaipur"));
    }
}
