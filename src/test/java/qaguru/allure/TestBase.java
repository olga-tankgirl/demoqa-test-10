package qaguru.allure;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    public void AfterEach() {
    }

    Page page = new Page();
    Data data = new Data();
}
