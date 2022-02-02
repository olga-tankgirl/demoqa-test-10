package qaguru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class HomeworkTest {

    private static final String URL = "https://github.com";
    private static final String ISSUE = "Issues";
    private static final String REPO = "eroshenkoam/allure-example";
    private static final int NUM = 68;

    @Attachment(value = "Screenshot", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }

    @AfterEach
    public void SaveSources() {
        attachPageSource();
    }

    @Test
    public void cleanSelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(URL);
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPO);
        $(".header-search-input").submit();

        $(By.linkText(REPO)).click();
        $(By.partialLinkText(ISSUE)).click();
        $(withText("#" + NUM)).should(Condition.visible);
    }

    @Test
    public void lambdaStepTest() {
        step("откр глав стр", () -> {
            open(URL);
        });
        step("ищем репо " + REPO, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPO);
            $(".header-search-input").submit();
        });
        step("перех в репо " + REPO, () -> {
            $(By.linkText(REPO)).click();
        });
        step("откр таб Issues", () -> {
            $(By.partialLinkText(ISSUE)).click();
        });
        step("пров Issue номер " + NUM, () -> {
            $(withText("#" + NUM)).should(Condition.visible);
        });
    }

    @Test
    public void annotatedStepsTest() {
        WebSteps steps = new WebSteps();
        steps.openPage();
        steps.searchRepo(REPO);
        steps.openRepoPage(REPO);
        steps.openIssuesTab();
        steps.assertIssueNum(NUM);
    }
}
