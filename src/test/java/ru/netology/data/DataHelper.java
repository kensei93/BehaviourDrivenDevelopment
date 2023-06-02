package ru.netology.data;

import lombok.Value;

import java.util.Random;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    @Value
    public static class CardValue {
        String cardNumber;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static VerificationCode getVerificationCode(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    public static CardValue getFirstCardNumber() {
        return new CardValue("5559 0000 0000 0001");
    }

    public static CardValue getSecondCardNumber() {
        return new CardValue("5559 0000 0000 0002");
    }

    public static int getTransfer(int balance) {
        return new Random().nextInt(balance) + 1;
    }

    public static int getImpossibleTransfer(int balance) {
        return Math.abs(balance) + new Random().nextInt(balance);
    }
}