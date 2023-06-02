package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {
    private SelenideElement header = $("[data-test-id=dashboard]");
    private ElementsCollection cards = $$(".list__item div");
    private String button = "[data-test-id=action-deposit]";
    private String balanceStart = "баланс:";
    private String balanceFinish  = " р.";

    public DashboardPage() {
        header.shouldBe(visible);
    }

    public int extractBalance(String text) {
        String cardValue = cards.get(Integer.parseInt(text)).text();
        val start = cardValue.indexOf(balanceStart);
        val finish = cardValue.lastIndexOf(balanceFinish);
        val value  = cardValue.substring(start + balanceStart.length(), finish).trim();
        return Integer.parseInt(value);
    }

    public TransferPage pressReplCard(int index) {
        SelenideElement buttonReplCard = cards.get(index).find(button);
        buttonReplCard.click();
        return new TransferPage();
    }
}