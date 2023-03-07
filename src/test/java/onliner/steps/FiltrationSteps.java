package onliner.steps;

import framework.BaseTest;
import framework.PropertyReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import onliner.pageObject.pages.*;


public class FiltrationSteps extends BaseTest {
    @Given("Go to {string}")
    public void goTo(String arg0) {
        driver.getInstance();
        driver.windowMaximize();
        driver.navigate(PropertyReader.getProperty("base.URL"));
    }

    @When("I navigate to the {string} page")
    public void iNavigateToThePage(String arg0) {
        MainPage mainPage = new MainPage();
        mainPage.navigateHeaderMenu("Автобарахолка");
    }

    @And("Click button {string}")
    public void clickCurrencyButton(String arg0) {
        AutobarakholkaPage autobarakholkaPage = new AutobarakholkaPage();
        autobarakholkaPage.currencyFilter("USD");
    }

    @And("In the field input {string}")
    public void inTheFieldInput(String arg0) {
        AutobarakholkaPage autobarakholkaPage = new AutobarakholkaPage();
        autobarakholkaPage.costFilter("100000");
    }


    @And("Choose {string} at vehicle checkbox")
    public void chooseAtVehicleCheckbox(String arg0) {
        AutobarakholkaPage autobarakholkaPage = new AutobarakholkaPage();
        autobarakholkaPage.vehicleFilter("Седан");
    }

    @And("Choose {string} at engine checkbox")
    public void chooseAtEngineCheckbox(String arg0) {
        AutobarakholkaPage autobarakholkaPage = new AutobarakholkaPage();
        autobarakholkaPage.engineFilter("Автоматическая");
    }

    @And("Check the correct operation by engine filter")
    public void checkTheCorrectOperationByEngineFilter() {
        AutobarakholkaPage autobarakholkaPage = new AutobarakholkaPage();
        autobarakholkaPage.checkEngineFilter();
    }



}
