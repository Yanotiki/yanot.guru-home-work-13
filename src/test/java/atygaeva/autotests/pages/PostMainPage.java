package atygaeva.autotests.pages;

import atygaeva.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.Condition.visible;
import static org.assertj.core.api.Assertions.assertThat;

public class PostMainPage {

    public static String MAIN_PAGE_URL = "https://www.pochta.ru/";

    SelenideElement trackNumberField = $x("//input[@id='barcode']");

    SelenideElement calculateButton = $x("//button[span[text()='Рассчитать']]");

    SelenideElement actualServices = $x("//div[h3[text()='Актуальные сервисы']]");

    ElementsCollection services = $$x("//div[h3[text()='Актуальные сервисы']]//div[contains(@class, 'Header')]");

    @Step("Scroll to '{label}'")
    public SelenideElement scrollTo(String label) {
        return $x("//label[text()='" + label + "']");
    }


    @Step("Set Track Number Field with value '{trackNumber}'")
    public TrackingPage setTrackNumberField(String trackNumber) {
        trackNumberField
                .shouldBe(Condition.visible)
                .setValue(trackNumber)
                .pressEnter();

        return new TrackingPage();
    }

    @Step("Click calculate button")
    public ParcelsPage clickCalculateButton() {
        calculateButton.click();
        return new ParcelsPage();
    }

    private void setAddressWithValue(String destination, String value) {
        $x("//input[@id='" + destination + "']")
                .setValue(value)
                .click();
        $x("//*[@id='" + destination + "']//div[@role='listbox']/div")
                .shouldBe(visible)
                .click();
    }

    @Step("Set Address From field with value '{value}'")
    public void setAddressFromFieldWithValue(String value) {
        setAddressWithValue("addressFrom", value);
    }

    @Step("Set Address To field with value '{value}'")
    public void setAddressToFieldWithValue(String value) {
        setAddressWithValue("addressTo", value);
    }

    @Step("Scroll to actual Services")
    public void scrollToActualServices() {
        actualServices.scrollTo();
    }

    @Step("Verify that barcode field has text '{text}'")
    public void verifyBarcodeFieldHasText(String text) {
        trackNumberField
                .shouldBe(Condition.visible)
                .shouldHave(Condition.attribute("placeholder", text));
    }

    @Step("Verify Post Main Page url is 'MAIN_PAGE_URL'")
    public void verifyPostMainPageUrl() {
        webdriver().shouldHave(url(MAIN_PAGE_URL));
    }

    @Step("Verify that the list of actual services is equal to {mainPageActualServices}")
    public void verifyThatActualServicesEqualTo(List<String> mainPageActualServices) {
        Assertions.assertThat(services.texts()).isEqualTo(mainPageActualServices);
    }

    @Step("Verify that page title have text 'Почта России'")
    public void verifyPageTitleHasText(String pageTitle) {
        String actualTitle = title();
        assertThat(actualTitle).isEqualTo(pageTitle);
    }

    @Step("Console logs should not contain text 'SEVERE'")
    public void verifyThatConsoleLogDoesNotContainError(String errorText) {
        String consoleLogs = DriverUtils.getConsoleLogs();
        assertThat(consoleLogs).doesNotContain(errorText);
    }
}
