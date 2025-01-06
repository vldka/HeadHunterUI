package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    @Step("Открытие главной страницы")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Открытие главной страницы, без регистрации при поиске")
    public MainPage openPageSearch() {
        open("/search/vacancy?text=&area=2&hhtmFrom=main&hhtmFromLabel=vacancy_search_line");
        return this;
    }

    @Step("Открытие страницы поиска")
    public MainPage openSearchPage() {
        open("/");
        $(".main-content").shouldHave(text("Работа найдётся для каждого"));
        return this;
    }

    @Step("Заполненение поиска")
    public MainPage setSearch(String value) {
        $("#supernova_search_form").$(".magritte-input___LVTID_7-0-7 magritte-with-icon___TPBe2_7-0-7").setValue(value);

        return this;
    }

    @Step("Заполненение телефона")
    public MainPage setPhone(String value) {
        $(By.name("login")).setValue(value);
        $(By.xpath("//button[@class='bloko-button bloko-button_kind-primary bloko-button_stretched']")).scrollTo().click();
        return this;
    }

    public MainPage clickButton() {

        $(".magritte-button__label___zplmt_5-2-9").scrollTo().click();

        return this;
    }

    public MainPage clickButtonMainPage() {

        $("span.supernova-logo.supernova-logo_inversed.supernova-logo_hh-ru").shouldBe(visible);
        $(By.cssSelector("span.supernova-logo.supernova-logo_inversed.supernova-logo_hh-ru")).click();
        return this;
    }

    @Step("Проверка Регистрации при первом поиске")
    public MainPage checkMainFirstSearch() {
        $("div.wrapper--T6aYg8_AcEQnGymd").$("div.bloko-text.bloko-text_large.bloko-text_strong").shouldHave(text("Зарегистрируйтесь — работодатели смогут найти вас и пригласить на работу"));
        return this;
    }

    @Step("Проверка блока Вакансий")
    public MainPage checkBlockVakancy() {
        $(".dashboard-tiles-item__title").shouldHave(text("Вакансии дня"));
        return this;
    }

    @Step("Проверка капчи телефона")
    public MainPage checkCapcha() {
        $(".content--reM1oYm0VqQRkbB0").$(".bloko-text").shouldHave(text("Чтобы подтвердить, что вы не робот, введите текст с картинки:"));
        return this;
    }

    @Step("Проверка Главной страницы")
    public MainPage checkMainPage() {
        $(".main-content").shouldHave(text("Работа найдётся для каждого"));
        return this;
    }
}
