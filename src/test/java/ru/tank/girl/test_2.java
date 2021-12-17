package ru.tank.girl;

import jdk.jfr.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

        public class test_2 {

        @BeforeAll
        static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        }

        @Test
        void successTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Test");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("test@gmail.com");
        $(".custom-radio:nth-child(1) .custom-control-label").click();
        $("#userNumber").setValue("1231231231");
        $("#dateOfBirthInput").click();
        $("[class*='month-select']").selectOption("May");
        $("[class*='year-select']").selectOption("1995");
        $("[class*='day--010']").click();
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/2021-12-10_12-50-29.png"));
        $("#subjectsInput").setValue("Arts").pressEnter();
        $(".custom-checkbox:nth-child(2) .custom-control-label").click();
        $("#currentAddress").setValue("Test");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").scrollTo().click();

        $(".modal-content").shouldHave(
        text("Test Test"),
        text("test@gmail.com"),
        text("Male"),
        text("1231231231"),
        text("10 May,1995"),
        text("Arts"),
        text("Reading"),
        text("2021-12-10_12-50-29.png"),
        text("Test"),
        text("Haryana Karnal"));
        }
        }
