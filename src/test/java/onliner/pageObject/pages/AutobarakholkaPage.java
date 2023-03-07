package onliner.pageObject.pages;

import framework.BasePage;
import framework.Browser;
import framework.elements.*;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class AutobarakholkaPage extends BasePage {

    private static final By PAGE_LOCATOR = By.xpath("//h1[contains(text(),'Автобарахолка')]");
    private static final String CURRENCY_BUTTON_LOCATOR = "//a[@class='vehicle-form__link vehicle-form__link_primary vehicle-form__link_base'][contains(text(),'%s')]";
    private static final String COST_FIELD_XPATH = "//div[@class='vehicle-form" +
            "__row vehicle-form__row_condensed-alter']//input[@placeholder='до']";
    private static final String TYPE_VEHICLE_CHECKBOX_XPATH = "//div[contains(text(),'%s')]/../../..";
    private static final String TYPE_ENGINE_CHECKBOX_XPATH = "//label[@class='vehicle-form__checkbox-label']//div[@class='i-checkbox vehicle-form__checkbox vehicle-form__checkbox_base']//div[@class='vehicle-form__checkbox-text']//div[contains(text(),'%s')]/../../..";
    private static final Label COLOR_XPATH = new Label(By.xpath("//div[contains(text(),'Цвет')]"));
    private static final String TEST = "//div[@class='vehicle-form__description vehicle-form__description_base vehicle-form__description_primary vehicle-form__description_transmission vehicle-form__description_condensed-other']";

    public AutobarakholkaPage() {
        super(PAGE_LOCATOR, "'Autobarakholka' Page");
    }

    @Step("Фильтрация по валюте.")
    public void currencyFilter(String currency) {
        Button currencyButton = new Button(By.xpath(String.format(CURRENCY_BUTTON_LOCATOR, currency)));
        currencyButton.scrollToElementViaJS();
        currencyButton.click();
    }

    @Step("Фильтрация по цене.")
    public void costFilter(String cost) {
        TextBox costField = new TextBox(By.xpath(COST_FIELD_XPATH));
        costField.click();
        costField.sendKeys(cost);
    }



    @Step("Фильтрация по типу кузова.")
    public void vehicleFilter(String vehicleType) {
        CheckBox typeVehicle = new CheckBox(By.xpath(String.format(TYPE_VEHICLE_CHECKBOX_XPATH, vehicleType)));
        typeVehicle.click();
    }

    @Step("Фильтрация по типу двигателя.")
    public void engineFilter(String typeEngine) {
        COLOR_XPATH.moveToElement();
        Label typeEngineCheckbox = new Label(By.xpath(String.format(TYPE_ENGINE_CHECKBOX_XPATH, typeEngine)));
        typeEngineCheckbox.click();
    }

    @Step("Проверка работа фильтра по типу кузова.")
    public void checkEngineFilter() {
    WebDriver driver1 = Browser.getDriver();

    JavascriptExecutor js =(JavascriptExecutor) Browser.getDriver();
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    List<WebElement> labels = driver1.findElements(By.xpath(TEST));

    System.out.println(labels.size());
    ArrayList<WebElement> Automatic_offers_list = new ArrayList();
        for (
    WebElement a : labels) {
        if(a.getText().contains("Автоматическая")) {
            Automatic_offers_list.add(a);
        }
    }
    Boolean result = false;
        if (labels.size() == Automatic_offers_list.size()) {
        result = true;
    }
        System.out.println(result);
    }


}
