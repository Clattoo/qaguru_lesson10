package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void setUp () {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    public static final String repositoryName = "qa_guru_14_10";
    public static final int issue = 2;

    @AfterAll
    static void closeAllWindows() {
        Selenide.closeWebDriver();
    }
}
