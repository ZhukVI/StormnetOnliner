package onliner.pageObject;

import framework.BasePage;
import framework.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CatalogPage extends BasePage {
    private static final By PAGE_LOCATOR = By.xpath("//div[@class='catalog" +
            "-navigation_title' and text()='Каталог']");
    private static final String NAVIGATE_MENU = "//span[@class='catalog-navigation-classifier__item-title-wrapper' " +
            "and contains(text(),'%s')]";
    private static final String NAV_SUBMENU_CATEGORY = "//div[@class='catalog-navigation-list__category']" +
            "//span[@class='catalog-navigation-list__dropdown-title' and contains(text(),'%s')]";
    private static final String NAV_SUBMENU_ITEM = "//div[@class='catalog-navigation-list__aside-title' and " +
            "contains(text(),'%s')]";

    public CatalogPage() {
        super(PAGE_LOCATOR, "'Catalog' Page'");
    }


    @Step("Выбор заголовка 'Компьютеры и сети' в меню навигации.")
    public void navigateToMainMenuItem(String compMenuItem) {
        Label navMenuOnCatalogPage = new Label(By.xpath(String.format(NAVIGATE_MENU, compMenuItem)));
        navMenuOnCatalogPage.click();
    }

    @Step("Наведение на 'Ноутбуки, компьютеры, мониторы' подменю.")
    public void navigateToSubmenuItem(String compSubmenuItems) {
        Label navSubmenuItem = new Label(By.xpath(String.format(NAV_SUBMENU_ITEM, compSubmenuItems)));
        navSubmenuItem.moveToElement();
    }

    @Step("Переход на страницу 'Игровые ноутбуки'.")
    public void navigateToSubmenuCategoryItem(String compSubmenuCategory) {
        Label navSubmenuCategory = new Label(By.xpath(String.format(NAV_SUBMENU_CATEGORY, compSubmenuCategory)));
        navSubmenuCategory.moveAndClickByAction();
    }

}
