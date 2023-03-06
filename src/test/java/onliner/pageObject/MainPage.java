package onliner.pageObject;

import framework.BasePage;
import framework.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MainPage extends BasePage {

    private static final Label PAGE_LOCATOR = new Label(By.xpath("//img[@class='onliner_logo']"));
    private static final String NAV_MENU_ITEM = "//span[@class='b-main-navigation__text' and text()='%s']";
    private static final By pageLocator = By.xpath("//img[@class='onliner_logo']");

    public MainPage() {
        super(pageLocator, "'Main' Page");
    }

    @Step("Проверка загрузившейся страницы.")
    public void isPageOpened() {
        Assert.assertTrue(PAGE_LOCATOR.isDisplayed(), "ERROR: Страница 'Main Page' не была загружена!!!");
    }

    @Step("Переход на страницу 'Каталог'.")
    public void navigateToCatalogHeaderMenu() {
        Label navMenu = new Label(By.xpath(String.format(NAV_MENU_ITEM, "Каталог")));
        navMenu.clickAndWait();
    }

    @Step("Переход на страницу 'Автобарахолка'.")
    public void navigateToAutoHeaderMenu() {
        Label navMenu = new Label(By.xpath(String.format(NAV_MENU_ITEM, "Автобарахолка")));
        navMenu.clickAndWait();
    }

}
