package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

        public class test_2 {

        @BeforeAll
        static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        System.setProperty("selenide.browser", "firefox");
        }

        @Test
        void successTest() {
        open("https://demoqa.com/automation-practice-form");


        }
        }
