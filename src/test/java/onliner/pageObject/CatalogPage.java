package onliner.pageObject;

import framework.BasePage;
import framework.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CatalogPage extends BasePage {
    private static final By PAGE_LOCATOR = By.xpath("//div[@class='catalog" +
            "-navigation_title' and text()='Каталог']");
    private static final String NAVIGATE_MENU = "//span[@class='catalog-navigation-classifier__item-title-wrapper' " +
            "and contains(text(),'%s')]";
    private static final Label NAV_SUBMENU_CATEGORY = new Label(By.xpath("//div[@class='catalog-navigation-list__category']" +
            "//span[@class='catalog-navigation-list__dropdown-title' and contains(text(),'Игровые ноутбуки')]"));
    private static final Label NAV_SUBMENU_ITEM = new Label(By.xpath("//div[@class='catalog-navigation-list__aside-title' and " +
            "contains(text(),'Ноутбуки, компьютеры, мониторы')]"));

    public CatalogPage() {
        super(PAGE_LOCATOR, "'Catalog' Page'");
    }


    @Step("Выбор заголовка 'Компьютеры и сети' в меню навигации.")
    public void navigateToComputers() {
        Label navMenuOnCatalogPage = new Label(By.xpath(String.format(NAVIGATE_MENU, "Компьютеры")));
        navMenuOnCatalogPage.click();
    }

    @Step("Наведение на 'Ноутбуки, компьютеры, мониторы' подменю.")
    public void navigateToSubmenuItem() {
        NAV_SUBMENU_ITEM.moveToElement();
    }

    @Step("Переход на страницу 'Игровые ноутбуки'.")
    public void navigateToSubmenuCategoryItem() {
        NAV_SUBMENU_CATEGORY.moveAndClickByAction();
    }

}
