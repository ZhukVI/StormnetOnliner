package onliner.tests;

import framework.BaseTest;
import jdk.jfr.Description;
import onliner.pageObject.pages.AutobarakholkaPage;
import onliner.pageObject.pages.MainPage;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FiltrationAutoTest extends BaseTest {

    @Test
    @Description("Переход на страницу 'Автобарахолка'. Проверка работы фильтров.")
    void filtrationAutoTest() {
        MainPage mainPage = new MainPage();
        mainPage.navigateHeaderMenu("Автобарахолка");

        AutobarakholkaPage autobarakholkaPage = new AutobarakholkaPage();
        autobarakholkaPage.currencyFilter("USD");
        autobarakholkaPage.costFilter("100000");
        autobarakholkaPage.vehicleFilter("Седан");
        autobarakholkaPage.engineFilter("Автоматическая");
        autobarakholkaPage.checkEngineFilter();


    }
}


