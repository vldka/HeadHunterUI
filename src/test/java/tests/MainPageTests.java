package tests;

import com.codeborne.selenide.Selenide;
import helpers.faker.FakerData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CaptchaPage;
import pages.MainPage;
import pages.SearchPage;

@DisplayName("Проверки на Главной форме")
public class MainPageTests extends UiTestBase {
    FakerData faker = new FakerData();
    MainPage mainPage = new MainPage();
    CaptchaPage captchaPage = new CaptchaPage();
    SearchPage searchPage = new SearchPage();

    @Test
    @DisplayName("Проверка открытия Главной страницы")
    void successfulOpenTest() {
        mainPage
                .openPage()
                .checkMainPage();
    }

    @Test
    @DisplayName("Проверка регистрации при поиске на главной странице")
    void successfulSearchRegistrationTest() {
        mainPage
                .openPage()
                .clickButton()
                .checkMainFirstSearch();
    }

    @Test
    @DisplayName("Проверка Блока Вакансии из топ 12")
    void successfulCheckBlockTest() {
        String position = "Менеджер";
        mainPage
                .openPage()
                .checkBlock(position);
    }

    @Test
    @DisplayName("Переход на главную страницу из страницы поиска")
    void successfulSearchTest() {
        searchPage.openPageSearch();
        mainPage
                .clickButtonMainPage()
                .checkMainPage();
    }

    @Test
    @DisplayName("Проверка капчи при вводе номера телефона с главной страницы")
    void successfulCheckPhoneSetTest() {
        mainPage.openPage();
        mainPage.setPhone(faker.phone);
        captchaPage.checkCapcha();
    }
}
