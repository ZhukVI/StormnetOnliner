package onliner.pageObject;

import framework.BasePage;
import framework.elements.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AutobarakholkaPage extends BasePage {

    private static final By PAGE_LOCATOR = By.xpath("//h1[contains(text(),'Автобарахолка')]");
    private static final Button CURRENCY_BUTTON_LOCATOR = new Button(By.xpath("//a[@class='vehicle-" +
            "form__link vehicle-form__link_primary vehicle-form__link_base' and text()='USD']"));
    private static final TextBox COST_FIELD_XPATH = new TextBox(By.xpath("//div[@class='vehicle-form" +
            "__row vehicle-form__row_condensed-alter']//input[@placeholder='до']"));
    private static final CheckBox TYPE_VEHICLE_CHECKBOX_XPATH = new CheckBox (By.xpath("//div[contains(text(),'Седан')]/../../.."));
    private static final CheckBox TYPE_ENGINE_CHECKBOX_XPATH = new CheckBox(By.xpath("//label[@class='vehicle-form__checkbox-label']//div[@class='i-checkbox vehicle-form__checkbox vehicle-form__checkbox_base']//div[@class='vehicle-form__checkbox-text']//div[contains(text(),'Автоматическая')]/../../.."));
    private static final Label COLOR_XPATH = new Label(By.xpath("//div[contains(text(),'Цвет')]"));
    private static final String TEST = "//div[@class='vehicle-form__description vehicle-form__description_base vehicle-form__description_primary vehicle-form__description_transmission vehicle-form__description_condensed-other']";

    public AutobarakholkaPage() {
        super(PAGE_LOCATOR, "'Autobarakholka' Page");
    }

    @Step("Фильтрация по цене и валюте.")
    public void costFilter() {
        CURRENCY_BUTTON_LOCATOR.moveAndClickByAction();
        COST_FIELD_XPATH.sendKeys("100000");
    }

    @Step("Фильтрация по типу кузова.")
    public void vehicleFilter() {
        TYPE_VEHICLE_CHECKBOX_XPATH.click();
    }

    @Step("Фильтрация по типу двигателя.")
    public void engineFilter() {
        COLOR_XPATH.moveToElement();
        TYPE_ENGINE_CHECKBOX_XPATH.click();
    }


}
