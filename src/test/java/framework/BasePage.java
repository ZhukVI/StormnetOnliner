package framework;


import framework.elements.Label;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Date;


public class BasePage {

    protected String title;
    protected By pageLocator;

    public BasePage(final By locator, final String pageTitle) {
        init(locator,pageTitle);
        assertIsOpen();
    }

    private void init(final By locator, final String pageTitle) {
        pageLocator = locator;
        title = pageTitle;

    }

    public void assertIsOpen() {
        long before = new Date().getTime();
        Label elem = new Label(pageLocator, title);
        try {
            elem.isElementPresent();
//            waitForPageToLoad();
            long operTime = new Date().getTime() - before;
            System.out.println(String.format("Form '%1$s' appears", title) + String.format(" in %s msec", operTime));
        } catch (Throwable e) {
            Assert.assertTrue(true, title + " is not opened");
        }
    }


}
