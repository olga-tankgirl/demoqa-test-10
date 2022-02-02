package qaguru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    private static final String URL = "https://github.com";
    private static final String ISSUE = "Issues";
    private static final String REPO = "eroshenkoam/allure-example";
    private static final int NUM = 68;

    @Step("откр глав стр")
    public void openPage() {
        open("https://github.com");
    }

    @Step("ищем репо {REPO}")
    public void searchRepo(String REPO) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPO);
        $(".header-search-input").submit();
    }

    @Step("перех в репо {REPO}")
    public void openRepoPage(String REPO) {
        $(By.linkText(REPO)).click();
    }

    @Step("откр таб Issues")
    public void openIssuesTab() {
        $(By.partialLinkText(ISSUE)).click();
    }

    @Step("пров Issue номер {NUM}")
    public void assertIssueNum(int NUM) {
        $(withText("#" + NUM)).should(Condition.visible);
    }

}
