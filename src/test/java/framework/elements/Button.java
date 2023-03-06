package framework.elements;

import org.openqa.selenium.By;

public class Button extends BaseElement{
    public Button(By by) {
        super(by);
    }

    public Button(By by, String name) {
        super(by, name);
    }

    @Override
    protected String getElementType() {
        return "Button: ";
    }
}
