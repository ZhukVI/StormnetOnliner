package onliner.tests;

import framework.BaseTest;
import jdk.jfr.Description;
import onliner.pageObject.pages.AutobarakholkaPage;
import onliner.pageObject.pages.MainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FiltrationAuto extends BaseTest {

    private static final String TEST = "//div[@class='vehicle-form__description vehicle-form__description_base vehicle-form__description_primary vehicle-form__description_transmission vehicle-form__description_condensed-other']";

    @Parameters({"currency", "COST_FIELD_XPATH"})
    @Test
    @Description("Переход на страницу 'Автобарахолка'. Проверка работы фильтров.")
    void filtrationAutoTest(String currency, String COST_FIELD_XPATH) {
        MainPage mainPage = new MainPage();
        mainPage.navigateHeaderMenu("Автобарахолка");

        AutobarakholkaPage autobarakholkaPage = new AutobarakholkaPage();
        autobarakholkaPage.costFilter(currency, COST_FIELD_XPATH);
        autobarakholkaPage.vehicleFilter("Седан");
        autobarakholkaPage.engineFilter("Автоматическая");
        autobarakholkaPage.checkEngineFilter();


    }
}


