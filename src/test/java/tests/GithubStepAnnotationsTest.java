package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("mashlemin")
@Severity(SeverityLevel.BLOCKER)
@DisplayName("Проверка Issues c Step Annotation")
public class GithubStepAnnotationsTest extends TestBase {

    @Test
    void issueCheckWithStepAnnotationTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage()
                .searchRepository()
                .openRepositoryPage()
                .openIssueTab()
                .openIssueTab()
                .checkIssueID()
                .takeScreenshot();
    }
}
