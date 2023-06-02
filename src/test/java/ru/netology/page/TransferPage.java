package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement header = $("[data-test-id=dashboard] ~h1");

    public TransferPage() {
        header.shouldBe(visible).shouldHave(Condition.text("Пополнение карты"));
    }

    private SelenideElement amountField = $("[data-test-id=amount] .input__control");
    private SelenideElement numberCardField = $("[data-test-id=from] .input__control");
    private SelenideElement buttonTransfer = $("[data-test-id=action-transfer]");
    private SelenideElement buttonCancel = $("[data-test-id=action-cancel]");

    public void fillInForm(Integer sum, DataHelper.CardValue card) {
        amountField.sendKeys(Keys.chord(Keys.CONTROL + "A"), Keys.DELETE);
        amountField.setValue(Integer.toString(sum));
        numberCardField.sendKeys(Keys.chord(Keys.CONTROL + "A"), Keys.DELETE);
        numberCardField.sendKeys(card.getCardNumber());
    }

    public DashboardPage replCardBalance(Integer sum, DataHelper.CardValue card) {
        fillInForm(sum, card);
        buttonTransfer.click();
        return new DashboardPage();
    }

    public DashboardPage replCardCancel(Integer sum, DataHelper.CardValue card) {
        fillInForm(sum, card);
        buttonCancel.click();
        return new DashboardPage();
    }
}