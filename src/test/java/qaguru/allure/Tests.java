package qaguru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class Tests extends TestBase {

    @Test
    @DisplayName("Тесты на чистом селениде")
    public void cleanSelenideTests() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        // Открываем главную страницу
        open(data.URL);
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(data.REPOSITORY);
        $(".header-search-input").submit();
        // Переходим в репозиторий
        $(linkText(data.REPOSITORY)).click();
        // Открываем таб + тест аттачмента
        $(partialLinkText(data.ISSUES)).click();
        Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
        // Проверяем наличие Issue с названием
        $(withText(data.ISSUENAME)).should(Condition.visible);
    }

    @Test
    @DisplayName("Лямбда тесты")
    public void lambdaTests() {
        step("Открываем главную страницу", () -> open(data.URL));
        step("Ищем репозиторий " + data.REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(data.REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + data.REPOSITORY, () -> $(linkText(data.REPOSITORY)).click());
        // Шаг с ипользованием аттачмента ниже
        step("Открываем таб " + data.ISSUES, () -> {
            Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
            $(partialLinkText(data.ISSUES)).click();
        });
        step("Проверяем наличие Issue с названием " + data.ISSUENAME, () -> {

            $(withText(data.ISSUENAME)).should(Condition.visible);
        });
    }

    @Test
    @DisplayName("Тесты с аннотациями")
    public void annotationTests() {
        page.openMainPage();
        page.searchForRepository(data.REPOSITORY);
        page.openRepositoryPage(data.REPOSITORY);
        page.openIssuesTab(data.ISSUES);
        page.shouldSeeIssueWithName(data.ISSUENAME);
    }

    // Сохраняем аттачмент после каждого теста
    @AfterEach
    public void saveSources() {
        page.attachPageSource();
    }
}
