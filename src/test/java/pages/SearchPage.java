package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

public class SearchPage {

    @Step("Открытие главной страницы, без регистрации при поиске")
    public void openPageSearch() {
        open("/search/vacancy?text=&area=2&hhtmFrom=main&hhtmFromLabel=vacancy_search_line");
    }

    @Step("Клик по поиску")
    public void clickSearch() {
        $(".submit-button--YyoPruejFyoUIdjl").click();
    }

    public void checkSearchList(String experience) {
        $(".vacancy-serp-content").shouldBe(text(experience));
    }

    public void checkhelpSearchList() {

        $$(xpath("//div[@data-qa='suggest-item-cell']")).shouldHave(size(10));
    }
}
