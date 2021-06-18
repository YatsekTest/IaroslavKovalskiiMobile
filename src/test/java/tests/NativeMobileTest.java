package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NativeMobileTest extends BaseTest {

    //TODO: All Strings to properties
    //TODO: Data provider is necessary here
    @Test(groups = {"native"}, description = "This simple test just clicks on Register button.")
    public void simpleNativeTest() throws NoSuchFieldException, IllegalAccessException {
        registerUser();
        System.out.println("User is registered.");
        login();
        System.out.println("User is logged in.");
        Assert.assertEquals(pageObject.getElement("title").getText(), "BudgetActivity");
        System.out.println("Register and Login Native Android test done.");
    }

    private void login() throws NoSuchFieldException, IllegalAccessException {
        pageObject.getElement("emailLoginField").sendKeys("mail@mail.ru");
        pageObject.getElement("passwordLoginField").sendKeys("123456789");
        pageObject.getElement("signInButton").click();
    }

    private void registerUser() throws NoSuchFieldException, IllegalAccessException {
        pageObject.getElement("registerButton").click();
        pageObject.getElement("emailField").sendKeys("mail@mail.ru");
        pageObject.getElement("usernameField").sendKeys("User");
        pageObject.getElement("passwordField").sendKeys("123456789");
        pageObject.getElement("confirmPasswordField").sendKeys("123456789");
        pageObject.getElement("registerAccountButton").click();
    }

}
