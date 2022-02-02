package qaguru.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsTest {

    private static final String REPO = "eroshenkoam/allure-example";
    private static final int NUM = 69;

    @Test
    public void lambdaStepTest() {
        step("откр глав стр", () -> {
            open("https://github.com");
        });
        step("ищем репо " + REPO, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPO);
            $(".header-search-input").submit();
        });
        step("перех в репо " + REPO, () -> {
            $(By.linkText(REPO)).click();
        });
        step("откр таб Issues",()->{
            $(By.partialLinkText("Issues")).click();
        });
        step("пров Issue номер "+NUM, () -> {
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
