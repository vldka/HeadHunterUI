package tests.web;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import java.util.Locale;

@DisplayName("Проверки на Главной форме")
@Tag("main")
public class MainPageTests extends UiTestBase {
    Faker rufaker = new Faker(new Locale("ru"));
    String phone = rufaker.phoneNumber().subscriberNumber(10);
    MainPage MainPage = new MainPage();

    @Test
    @DisplayName("Проверка открытия Главной страницы")
    void successfulOpenTest() {
        MainPage
                .openPage()
                .checkMainPage();
    }

    @Test
    @DisplayName("Проверка регистрации при поиске на главной странице")
    void successfulSearchRegistrationTest() {
        MainPage
                .openPage()
                .clickButton()
                .checkMainFirstSearch();
    }

    @Test
    @DisplayName("Проверка регистрации при поиске на главной странице")
    void successfulCheckBlockTest() {
        MainPage
                .openPage()
                .checkBlockVakancy();
    }

    @Test
    @DisplayName("Переход на Главную страницу через страницу Поиска")
    void successfulSearchTest() {
        MainPage
                .openPageSearch()
                .clickButtonMainPage()
                .checkMainPage();
    }

    @Test
    @DisplayName("Проверка капчи")
    void successfulCheckPhoneSetTest() {
        MainPage.openPage();
        Selenide.sleep(60000);

        MainPage
                .setPhone(phone)
                .checkCapcha();
    }
}
