package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Owner("mashlemin")
@Severity(SeverityLevel.BLOCKER)
@DisplayName("Проверка Issues c Listener")
public class GithubListenerTest extends TestBase {

    @Test
    void issueCheckWithListenerTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");

        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue(repositoryName).pressEnter();

        $("[data-testid='results-list'] a[href='/qa-guru/qa_guru_14_10']").click();
        $("#issues-tab").click();
        $(withText("#2")).should(Condition.exist);
    }
}
