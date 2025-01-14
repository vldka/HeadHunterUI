package tests;

import helpers.faker.FakerData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchPage;

@DisplayName("Проверки на Главной форме")
public class SearchPageTests extends UiTestBase {
    FakerData faker = new FakerData();

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @Test
    @DisplayName("Проверка вхождения хотя бы 1 записи в выдаче по поиску")
    void checkSearchTest() {
        searchPage.openPageSearch();
        mainPage.setSearch(faker.position);
        searchPage.clickSearch();
        searchPage.checkSearchList(faker.position);
    }

    @Test
    @DisplayName("Проверка подсказки при поиске")
    void checkOperationFilterTest() {
        searchPage.openPageSearch();
        mainPage.setSearch("Менеджер");
        searchPage.checkhelpSearchList();
    }
}
