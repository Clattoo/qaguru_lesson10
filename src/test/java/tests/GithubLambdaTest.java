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
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Owner("mashlemin")
@Severity(SeverityLevel.BLOCKER)
@DisplayName("Проверка Issues c Lambda")
public class GithubLambdaTest extends TestBase {

    @Test
    void issueCheckWithLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открытие главной страницы GitHub", () -> {
            open("https://github.com/");
        });
        step("Поиск репозитория " + repositoryName, () -> {
            $("[placeholder='Search or jump to...']").click();
            $("#query-builder-test").setValue(repositoryName).pressEnter();
        });
        step("Переход внутрь репозитория " + repositoryName + " по клику на ссылку", () -> {
            $("[data-testid='results-list'] a[href='/qa-guru/qa_guru_14_10']").click();
        });
        step("Клик по разделу Issue", () -> {
            $("#issues-tab").click();
        });
        step("Проверка наличия и ID Issue" + issue, () -> {
            $(withText("#" + issue)).should(Condition.exist);
        });
    }
}
