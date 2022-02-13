package atygaeva.autotests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class ParcelsPage {

    public SelenideElement header = $x("//h1[text()='Посылки']");

    public SelenideElement cityFromOrToField(String field) {
        return $x("//div[label[text()='" + field + "']]//input");
    }

    @Step("Verify parcels page header")
    public void verifyParcelsPageHeader() {
        header.shouldBe(Condition.visible);
    }

    @Step("Verify that field '{field}' has value '{city}'")
    public void verifyThatFieldHasValue(String field, String city) {
        SelenideElement cityField = cityFromOrToField(field);
        Assertions.assertThat(cityField.getValue()).contains(city);
    }
}
