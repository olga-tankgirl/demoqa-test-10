package qaguru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
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
    @Owner("Me")
    @Story("Современный подход")
    @Severity(SeverityLevel.BLOCKER)
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
    @Owner("Me")
    @Story("Ручное объявление шагов")
    @Severity(SeverityLevel.CRITICAL)
    public void lambdaStepTest() {
        step("открывание главной страницы гитхаба", () -> open(URL));
        step("искание искомого репо " + REPO, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPO);
            $(".header-search-input").submit();
        });
        step("переход в искомый репо " + REPO, () -> $(By.linkText(REPO)).click());
        step("открывание таба с жалобами", () -> $(By.partialLinkText(ISSUE)).click());
        step("проверяние жалобы с номером " + NUM, () -> {
            $(withText("#" + NUM)).should(Condition.visible);
        });
    }

    @Test
    @Owner("Me")
    @Story("Вынос шагов в отдельный класс")
    @Severity(SeverityLevel.MINOR)
    public void annotatedStepsTest() {
        WebSteps steps = new WebSteps();
        steps.openPage();
        steps.searchRepo(REPO);
        steps.openRepoPage(REPO);
        steps.openIssuesTab();
        steps.assertIssueNum(NUM);
    }
}
