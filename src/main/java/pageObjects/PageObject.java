package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import setup.IPageObject;

import java.lang.reflect.Field; //TODO: learn reflection!

public class PageObject implements IPageObject {

    Object anyPageObject;

    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        System.out.println("Current app type is " + appType);
        switch (appType) {
            case "web":
                anyPageObject = new WebPageObject(appiumDriver);
                break;
            case "native":
                anyPageObject = new NativePageObject(appiumDriver);
                break;
            default:
                throw new Exception("Can't create page object for " + appType);
        }
    }

    @Override //TODO: learn reflection!
    public WebElement getElement(String elementName) throws NoSuchFieldException, IllegalAccessException {
        Field field = anyPageObject.getClass().getDeclaredField(elementName);
        field.setAccessible(true);
        return (WebElement) field.get(anyPageObject);
    }

}
