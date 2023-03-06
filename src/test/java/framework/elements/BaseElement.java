package framework.elements;
import framework.Browser;
import framework.PropertyReader;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static framework.PropertyReader.getProperty;

@Log4j2
public abstract class BaseElement {
    protected WebElement element;
    protected List<WebElement> elements;
    private By by;
    private String name;
    private WebDriverWait wait;

    public BaseElement(By by) {
        this.by = by;
    }

    public BaseElement(By by, String name) {
        this.by = by;
        this.name = name;
    }

    protected abstract String getElementType();

    public boolean isElementPresent() {
        try {
            Browser.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(Browser.getTimeoutForCondition()), TimeUnit.SECONDS);
            element = Browser.getDriver().findElement(by);
            log.info(getElementType() + ": " + by + " - is present");
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            log.info(getElementType() + ": " + by + " - is not present. Exception - NoSuchElementException");
        } catch (Exception e) {
            log.info("Exception: " + e.getMessage());
        }
        return false;
    }

    public boolean areElementPresent(int timeout) {
        wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(timeout));
        Browser.getDriver().manage().timeouts().implicitlyWait(Integer.valueOf(Browser.getTimeoutForCondition()), TimeUnit.SECONDS);
        try {
            wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
                public Boolean apply(final WebDriver driver) {
                    try {
                        elements = driver.findElements(by);
                        log.info(getElementType() + ": " + by + " - are present");
                        for (WebElement element : elements) {
                            if (element instanceof WebElement && element.isDisplayed()) {
                                element = (WebElement) element;
                                return element.isDisplayed();
                            }
                        }
                        element = (WebElement) driver.findElement(by);
                    } catch (Exception e) {
                        return false;
                    }
                    return element.isDisplayed();
                }
            });
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public WebElement getElement() {
        isElementPresent();
        log.info("Get element: " + getElementType() + " : " + by);
        return element;
    }

    public void sendKeys(String sendKeys) {
        isElementPresent();
        log.info("Send keys: " + getElementType() + " : " + by);
        getElement().sendKeys(sendKeys);
    }

    public boolean isDisplayed() {
        isElementPresent();
        log.info(getElementType() + " : " + by + " is displayed: " + element.isDisplayed());
        return element.isDisplayed();
    }

    public boolean isSelected() {
        isElementPresent();
        log.info(getElementType() + " : " + by + " is selected: " + element.isSelected());
        return element.isSelected();
    }

    public String getText() {
        isElementPresent();
        log.info("Get text: " + getElementType() + " : " + by);
        return element.getText();
    }

    public void click() {
        isElementPresent();
        log.info(getProperty("element.click") + " - " + getElementType() + " : " + by);
        element.click();
        Browser.getTimeoutForCondition();
    }

    public void clickAndWait() { //используется, когда после клика происходит редирект на другую страницу
        isElementPresent();
        log.info(getProperty("element.click") + " and " + getProperty("element.wait") + " - " + getElementType() + " : " + by);
        element.click();
        Browser.getTimeoutForPageLoad();
    }

    public void moveAndClickByAction() {
        isElementPresent();
        log.info(getProperty("element.move") + " and " + getProperty("element.click") + getProperty("element.action") + " - "  + getElementType() + " : " + by);
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element).click().perform();
    }

    public void moveAndClick() {
        isElementPresent();
        log.info(getProperty("element.move") + " and " + getProperty("element.click") + " - " + getElementType() + " : " + by);
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element).click();
    }
    public void moveToElement() {
        isElementPresent();
        log.info(getProperty("element.move") + " - " + getElementType() + " : " + by);
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element).perform();
    }

    public void selectComboBox(String value) {
        isElementPresent();
        log.info("Select: " + getElementType() + " : " + by);
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public String getAttribute(String attribute) {
        isElementPresent();
        log.info("Get attribute: " + getElementType() + " : " + by);
        return element.getAttribute(attribute);
    }

    public void scrollIntoView() {
        isElementPresent();
        if(Browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].style.border='3px solid blue'", element);
        }
    }

    public void clickViaJS() {
        moveToElement();
        log.info(getProperty("element.click") + " - " + getElementType() + " : " + by);
        JavascriptExecutor js =(JavascriptExecutor) Browser.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)", element);
    }


}
