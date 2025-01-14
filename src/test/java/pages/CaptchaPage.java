package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CaptchaPage {

    @Step("Проверка капчи телефона")
    public void checkCapcha() {
        $(".content--reM1oYm0VqQRkbB0").$(".bloko-text").shouldHave(text("Чтобы подтвердить, что вы не робот, введите текст с картинки:"));
    }
}
