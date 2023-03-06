package onliner.steps;

import framework.BaseTest;
import framework.PropertyReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import onliner.pageObject.pages.CatalogPage;
import onliner.pageObject.pages.MainPage;

public class NavigationSteps extends BaseTest {
    @Given("Go to {string}")
    public void goTo(String arg0) {
        driver.navigate(PropertyReader.getProperty("base.URL"));
    }

    @When("I navigate to the {string} page")
    public void iNavigateToThePage(String arg0) {
        MainPage mainPage = new MainPage();
        mainPage.navigateHeaderMenu("Каталог");
    }

    @And("Select {string} from the navigation menu")
    public void selectFromTheNavigationMenu(String arg0) {
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.navigateToMainMenuItem("Компьютеры");
    }

    @And("In the submenu navigate to {string}")
    public void inTheSubmenuNavigateTo(String arg0) {
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.navigateToSubmenuItem("Ноутбуки, компьютеры, мониторы");

    }

    @And("Go to the {string}")
    public void goToThe(String arg0) {
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.navigateToSubmenuCategoryItem("Игровые ноутбуки");
    }
}
