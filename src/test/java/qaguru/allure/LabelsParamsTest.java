package qaguru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsParamsTest {

    @Test
    public void lambdaLabelTest(){
        Allure.label("owner", "me");
        Allure.feature("Issues");
        Allure.story("созд Issue для авториз польз");
        Allure.label("severity", SeverityLevel.BLOCKER.value());
        Allure.link("GitHub", "https://github.com");
        Allure.parameter("Птица", "Пингвин");
        Allure.parameter("Рыба", "Дельфин");
    }

    @Test
    @Owner("you")
    @Feature("Issues")
    @Story("созд Issue для авториз польз")
    @DisplayName("созд Issue для авториз польз")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "GitHub", url="https://github.com")
    public void annotatedLabelsTest() {

    }

}
