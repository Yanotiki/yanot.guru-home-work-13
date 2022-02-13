package atygaeva.autotests.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static atygaeva.autotests.pages.PostMainPage.MAIN_PAGE_URL;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class TrackingPage {

    public static String TRACKING_PAGE_URL = "https://www.pochta.ru/tracking#";

    public SelenideElement trackNumber(String trackNumber) {
        return $x("//*[@id='tracking-card-portal']//span[text()='" + trackNumber + "']");
    }

    @Step("Open tracking page for 'trackNumber' tracking number")
    public static TrackingPage openTrackingPage(String trackNumber) {
        open(MAIN_PAGE_URL + "tracking#" + trackNumber);
        return new TrackingPage();
    }

    @Step("Copy track number by clicking on it")
    public String copyTrackNumber(String trackNumber) {
        trackNumber(trackNumber)
                .shouldBe(visible)
                .click();
        return Selenide.clipboard().getText();
    }

    @Step("Verify Track Page url is 'https://www.pochta.ru/tracking#{trackNumber}'")
    public void verifyTrackPageUrl(String trackNumber) {
        webdriver().shouldHave(url(TRACKING_PAGE_URL + trackNumber));
    }
}
