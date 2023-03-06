package framework.elements;
import framework.Browser;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

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
        return element.getText();
    }

    public void click() {
        isElementPresent();
        log.info("Click on: " + getElementType() + " : " + by);
        element.click();
        Browser.getTimeoutForCondition();
    }

    public void clickAndWait() { //используется, когда после клика происходит редирект на другую страницу
        isElementPresent();
        element.click();
        Browser.getTimeoutForPageLoad();
    }

//    public void clickViaJS() {
//        isElementPresent();
//        if (Browser.getDriver() instanceof JavascriptExecutor) {
//            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].style.border='3px solid blue'", element);
//            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].click();", element);
//        }
//    }

    public void moveAndClickByAction() {
        isElementPresent();
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element).click().perform();
    }

    public void moveAndClick() {
        isElementPresent();
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element).click();
    }
    public void moveToElement() {
        isElementPresent();
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element).perform();
    }

    public void selectComboBox(String value) {
        isElementPresent();
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public String getAttribute(String attribute) {
        isElementPresent();
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
        JavascriptExecutor js =(JavascriptExecutor) Browser.getDriver();
        //js.executeScript("arguments[0].scrollIntoView();", element);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)", element);
    }


}
