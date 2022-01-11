package ru.tank.girl;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WikiTest {
@Test
void wiki () {

    open("https://github.com/selenide/selenide");
    $("#wiki-tab").click();
    $(".js-wiki-more-pages-link").click();
    $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
    $("#wiki-pages-box").$(byText("SoftAssertions")).click();
    $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
}








}