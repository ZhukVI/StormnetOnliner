package onliner.tests;

import framework.BaseTest;
import io.qameta.allure.Description;
import onliner.pageObject.*;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    @Description("Переход на страницу 'Ноутбуки, компьютеры, мониторы'. Ожидаемый результат: " +
            "Страница 'Ноутбуки, компьютеры, мониторы' загружена.")
    public void navigationMenuTest() {
        MainPage mainPage = new MainPage();
        mainPage.navigateToCatalogHeaderMenu();

        CatalogPage catalogPage = new CatalogPage();
        catalogPage.navigateToComputers();
        catalogPage.navigateToSubmenuItem();
        catalogPage.navigateToSubmenuCategoryItem();
    }
}
