package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static tests.TestBase.issue;
import static tests.TestBase.repositoryName;

public class WebSteps {

    @Step("Открываем главную страницу GitHub")
    public WebSteps openMainPage() {
        open("https://github.com/");
        return this;
    }

    @Step("Вводим в поле поиска " + repositoryName)
    public WebSteps searchRepository() {
        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue(repositoryName).pressEnter();
        return this;
    }

    @Step("Переходим внутрь репозитория " + repositoryName)
    public WebSteps openRepositoryPage() {
        $(linkText(repositoryName)).click();
        return this;
    }

    @Step("Открываем раздел Issue для репозитория " + repositoryName)
    public WebSteps openIssueTab () {
        $("#issues-tab").click();
        return this;
    }

    @Step("Проверяем наличие требуемого ID Issue внутри раздела")
    public WebSteps checkIssueID () {
        $(withText("#" + issue)).should(Condition.exist);
        return this;
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
