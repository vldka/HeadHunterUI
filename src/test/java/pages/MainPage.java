package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.By.xpath;

public class MainPage {
    @Step("Открытие главной страницы")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Заполненение поиска")
    public void setSearch(String value) {
        $("#supernova_search_form").$("#a11y-search-input").setValue(value);
    }

    @Step("Заполненение телефона")
    public void setPhone(String value) {
        $(By.name("login")).setValue(value);
        $(xpath("//button[@class='bloko-button bloko-button_kind-primary bloko-button_stretched']"))
                .scrollTo().click();
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
    public void checkMainFirstSearch() {
        $("div.wrapper--T6aYg8_AcEQnGymd")
                .$("div.bloko-text.bloko-text_large.bloko-text_strong")
                .shouldHave(text("Зарегистрируйтесь — работодатели смогут найти вас и пригласить на работу"));
    }

    @Step("Проверка блока Вакансий")
    public void checkBlock(String position) {
        boolean hasText = $(".dashboard-tiles-content.dashboard-tiles-content_scroll")
                .$$(".dashboard-tiles-item__title")
                .stream().map(SelenideElement::getText).anyMatch(s -> s.contains(position));
        assertTrue(hasText);
    }

    @Step("Проверка Главной страницы")
    public void checkMainPage() {
        $(".main-content").shouldHave(text("Работа найдётся для каждого"));
    }
}
