package onliner.tests;

import framework.BaseTest;
import io.qameta.allure.Description;
import onliner.pageObject.pages.CatalogPage;
import onliner.pageObject.pages.MainPage;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    @Description("Переход на страницу 'Ноутбуки, компьютеры, мониторы'. Ожидаемый результат: " +
            "Страница 'Ноутбуки, компьютеры, мониторы' загружена.")
    public void navigationMenuTest() {
        MainPage mainPage = new MainPage();
        mainPage.navigateHeaderMenu("Каталог");

        CatalogPage catalogPage = new CatalogPage();
        catalogPage.navigateToMainMenuItem("Компьютеры");
        catalogPage.navigateToSubmenuItem("Ноутбуки, компьютеры, мониторы");
        catalogPage.navigateToSubmenuCategoryItem("Игровые ноутбуки");
    }
}
