package atygaeva.autotests.tests;

import atygaeva.autotests.config.Project;
import atygaeva.autotests.helpers.AllureAttachments;
import atygaeva.autotests.helpers.DriverSettings;
import atygaeva.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static atygaeva.autotests.pages.PostMainPage.MAIN_PAGE_URL;
import static com.codeborne.selenide.Selenide.open;


@ExtendWith({AllureJunit5.class})
public class BaseTest {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }

    @BeforeEach
    @Step("Open main page '{MAIN_PAGE_URL}'")
    void openMainPage() {
        //open(MAIN_PAGE_URL);
        open("https://www.pochta.ru/");
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
//        AllureAttachments.attachNetwork(); // todo
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}
