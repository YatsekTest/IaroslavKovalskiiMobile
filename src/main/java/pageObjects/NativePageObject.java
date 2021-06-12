package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button") // TODO: id to properties?
    WebElement signInButton;

    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

}