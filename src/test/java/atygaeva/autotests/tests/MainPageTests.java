package atygaeva.autotests.tests;

import atygaeva.autotests.pages.ParcelsPage;
import atygaeva.autotests.pages.PostMainPage;
import atygaeva.autotests.pages.TrackingPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static atygaeva.autotests.pages.TrackingPage.openTrackingPage;


public class MainPageTests extends BaseTest {

    private PostMainPage mainPage = new PostMainPage();

    @Test
    @DisplayName("Main page should contain track option")
    void trackOptionTest() {
        mainPage.verifyBarcodeFieldHasText("Введите трек-номер");
    }

    @ParameterizedTest
    @ValueSource(strings = {"35005145009747", "CA123456789RU"})
    @DisplayName("Track option field should consume a valid track number for Russian or International delivery")
    void trackOptionValidNumbersTest(String trackNumber) {
        mainPage.scrollTo("Отследить");
        TrackingPage trackingPage = mainPage.setTrackNumberField(trackNumber);
        trackingPage.verifyTrackPageUrl(trackNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3500514509747", "CA123456789RUT", "(5005145009747}"})
    @DisplayName("Track Option field should not consume invalid track number")
    void trackOptionInvalidNumbersTest(String trackNumber) {
        mainPage.scrollTo("Отследить");
        mainPage.setTrackNumberField(trackNumber);
        mainPage.verifyPostMainPageUrl();
    }

    @Test
    @DisplayName("Track number should be copied by clicking on it")
    void copyTrackNumberTest() {
        String trackNumber = "35005145009747";
        mainPage.scrollTo("Отследить");
        TrackingPage trackingPage = openTrackingPage(trackNumber);
        String copiedNumber = trackingPage.copyTrackNumber(trackNumber);
        Assertions.assertThat(copiedNumber).isEqualTo(trackNumber);
    }

    @Test
    @DisplayName("Shipping address and receiving address should be saved according to inputted values")
    void sendPackageTest() {
        mainPage.scrollTo("Отправить посылку");
        mainPage.setAddressFromFieldWithValue("Владивосток");
        mainPage.setAddressToFieldWithValue("Москва");
        ParcelsPage parcelsPage = mainPage.clickCalculateButton();
        parcelsPage.verifyParcelsPageHeader();
        parcelsPage.verifyThatFieldHasValue("Город или адрес отправителя", "Владивосток");
        parcelsPage.verifyThatFieldHasValue("Город или страна или телефон получателя", "Москва");
    }

    @Test
    @DisplayName("Verification of actual services on main page")
    void mainPageActualServicesTest() {
        List<String> mainPageActualServices = Arrays.asList(
                "Бонусная программа",
                "Оформление писем онлайн",
                "Доставка на дом",
                "Почтоматы",
                "Электронное заказное письмо",
                "Подписка на печатные или электронные издания"
        );

        mainPage.scrollToActualServices();
        mainPage.verifyThatActualServicesEqualTo(mainPageActualServices);
    }

    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
        mainPage.verifyPageTitleHasText("Почта России");
    }

    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        mainPage.verifyThatConsoleLogDoesNotContainError("SEVERE");
    }
}