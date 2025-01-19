package tests;

import com.codeborne.selenide.Selenide;
import helpers.faker.FakerData;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.CaptchaPage;
import pages.MainPage;
import pages.SearchPage;
@Feature("HeadHunter")
@Story("MainPage")
@Tags({@Tag("CRITICAL"), @Tag("REGRESS"),@Tag("HeadHunt")})
@Owner("Vlad Kashkarov")
@DisplayName("Проверки на Главной форме")
public class MainPageTests extends UiTestBase {
    FakerData faker = new FakerData();
    MainPage mainPage = new MainPage();
    CaptchaPage captchaPage = new CaptchaPage();
    SearchPage searchPage = new SearchPage();

    @Test
    @AllureId("35744")
    @DisplayName("Проверка открытия Главной страницы")
    void successfulOpenTest() {
        mainPage
                .openPage()
                .checkMainPage();
    }

    @Test
    @AllureId("35743")
    @DisplayName("Проверка регистрации при поиске на главной странице")
    void successfulSearchRegistrationTest() {
        mainPage
                .openPage()
                .clickButton()
                .checkMainFirstSearch();
    }

    @Test
    @AllureId("35741")
    @DisplayName("Проверка Блока Вакансии из топ 12")
    void successfulCheckBlockTest() {
        String position = "Менеджер";
        mainPage
                .openPage()
                .checkBlock(position);
    }

    @Test
    @AllureId("35742")
    @DisplayName("Переход на главную страницу из страницы поиска")
    void successfulSearchTest() {
        searchPage.openPageSearch();
        mainPage
                .clickButtonMainPage()
                .checkMainPage();
    }

    @Test
    @AllureId("35745")
    @DisplayName("Проверка капчи при вводе номера телефона с главной страницы")
    void successfulCheckPhoneSetTest() {
        mainPage.openPage();
        Selenide.sleep(60000);
        mainPage.setPhone(faker.phone);
        captchaPage.checkCapcha();
    }
}
