package onliner.tests;

import framework.BaseTest;
import framework.Browser;
import jdk.jfr.Description;
import jdk.jfr.Label;
import onliner.pageObject.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FiltrationAuto extends BaseTest {

    private static final String TEST = "//div[@class='vehicle-form__description vehicle-form__description_base vehicle-form__description_primary vehicle-form__description_transmission vehicle-form__description_condensed-other']";

    @Test
    @Description("Переход на страницу 'Автобарахолка'. Проверка работы фильтров.")
    void filtrationAutoTest() {
        MainPage mainPage = new MainPage();
        mainPage.navigateToAutoHeaderMenu();

        AutobarakholkaPage autobarakholkaPage = new AutobarakholkaPage();
        autobarakholkaPage.costFilter();
        autobarakholkaPage.vehicleFilter();
        autobarakholkaPage.engineFilter();

        WebDriver driver1 = Browser.getDriver();

        JavascriptExecutor js =(JavascriptExecutor) Browser.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        List<WebElement> labels = driver1.findElements(By.xpath(TEST));

                System.out.println(labels.size());
        ArrayList<WebElement> Automatic_offers_list = new ArrayList();
        for (
            WebElement a : labels
        ) {
            if(a.getText().contains("Автоматическая")) {
                Automatic_offers_list.add(a);
            }
        }
        Boolean result = false;
        if (labels.size() == Automatic_offers_list.size()) {
            result = true;
        }
        System.out.println(Automatic_offers_list.size());
        System.out.println(result);


       }
}


