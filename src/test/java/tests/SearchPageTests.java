package tests;

import helpers.faker.FakerData;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchPage;

@Feature("HeadHunter")
@Story("SearchPage")
@Tags({@Tag("CRITICAL"), @Tag("REGRESS"), @Tag("HeadHunt")})
@Owner("Vlad Kashkarov")
@DisplayName("Проверки Поисковой страницы")
public class SearchPageTests extends UiTestBase {
    FakerData faker = new FakerData();

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @Test
    @AllureId("35747")
    @DisplayName("Проверка вхождения хотя бы 1 записи в выдаче по поиску")
    void checkSearchTest() {
        searchPage.openPageSearch();
        mainPage.setSearch(faker.position);
        searchPage.clickSearch();
        searchPage.checkSearchList(faker.position);
    }

    @Test
    @AllureId("35746")
    @DisplayName("Проверка подсказки при поиске")
    void checkOperationFilterTest() {
        searchPage.openPageSearch();
        mainPage.setSearch("Менеджер");
        searchPage.checkhelpSearchList();
    }
}
