package onliner.steps;

import framework.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import onliner.pageObject.pages.*;

public class FiltrationSteps extends BaseTest {
    @Then("Click {string} button")
    public void clickButton(String arg0) {
        MainPage mainPage = new MainPage();
        mainPage.navigateHeaderMenu("Автобарахолка");
    }

    @And("Input {string} in the fielg")
    public void inputInTheFielg(String currency, String COST_FIELD_XPATH) {
        AutobarakholkaPage autobarakholkaPage = new AutobarakholkaPage();
        autobarakholkaPage.costFilter(currency, COST_FIELD_XPATH);
    }

    @Then("Choose {string} at vehicle checkbox")
    public void chooseAtVehicleCheckbox(String arg0) {
        AutobarakholkaPage autobarakholkaPage = new AutobarakholkaPage();
        autobarakholkaPage.vehicleFilter("Седан");
    }

    @Then("Choose {string} at engine checkbox")
    public void chooseAtEngineCheckbox(String arg0) {
        AutobarakholkaPage autobarakholkaPage = new AutobarakholkaPage();
        autobarakholkaPage.engineFilter("Автоматическая");
    }

    @Then("Check the correct operation by engine filter")
    public void checkTheCorrectOperationByEngineFilter() {
        AutobarakholkaPage autobarakholkaPage = new AutobarakholkaPage();
        autobarakholkaPage.checkEngineFilter();
    }
}
