package qaguru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest {

    private static final String REPO = "eroshenkoam/allure-example";
    private static final int NUM = 69;

    @Test
    public void lambdaAttachmentTest() {
        step("откр глав стр", () -> {
            open("https://github.com");
        });
        step("ищем репо " + REPO, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPO);
            attachPageSource();
            $(".header-search-input").submit();
        });
        step("перех в репо " + REPO, () -> {
            attachPageSource();
            $(By.linkText(REPO)).click();
        });
        step("откр таб Issues", () -> {
            $(By.partialLinkText("Issues")).click();
        });
    }

    @Attachment(value = "Screenshot", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }

    @AfterEach
    public void SaveSources() {
        attachPageSource();
    }
}
