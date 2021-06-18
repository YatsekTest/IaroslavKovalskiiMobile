package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import interfaces.IPageObject;

import java.lang.reflect.Field;
import java.util.List;

public class PageObject implements IPageObject {

    private final Object anyPageObject;

    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        switch (appType) {
            case "web":
                anyPageObject = new WebPageObject(appiumDriver);
                break;
            case "native":
                anyPageObject = new NativePageObject(appiumDriver);
                break;
            default:
                throw new Exception("Can't create page object for " + appType + ".");
        }
        System.out.println("Page object: current app type is " + appType + ".");
    }

    @Override
    public WebElement getElement(String elementName) throws NoSuchFieldException, IllegalAccessException {
        Field field = anyPageObject.getClass().getDeclaredField(elementName);
        field.setAccessible(true);
        return (WebElement) field.get(anyPageObject);
    }

    @Override
    public List<WebElement> getElements(String elementsName) throws NoSuchFieldException, IllegalAccessException {
        Field field = anyPageObject.getClass().getDeclaredField(elementsName);
        field.setAccessible(true);
        return (List<WebElement>) field.get(anyPageObject);
    }

}
