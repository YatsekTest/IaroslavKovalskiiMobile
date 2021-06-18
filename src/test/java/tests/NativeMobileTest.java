package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestDataProvider;

public class NativeMobileTest extends BaseTest {

    @Test(description = "This test asserts User registration and login in.",
            dataProviderClass = TestDataProvider.class, dataProvider = "nativeTestData")
    public void simpleNativeTest(String email, String userName, String password, String nativePageTitle)
            throws NoSuchFieldException, IllegalAccessException {
        registerUser(email, userName, password);
        login(email, password);
        Assert.assertEquals(pageObject.getElement("title").getText(), nativePageTitle);
        System.out.println("Register and Login Native Android test done.");
    }

    private void registerUser(String email, String userName, String password)
            throws NoSuchFieldException, IllegalAccessException {
        pageObject.getElement("registerButton").click();
        pageObject.getElement("emailField").sendKeys(email);
        pageObject.getElement("usernameField").sendKeys(userName);
        pageObject.getElement("passwordField").sendKeys(password);
        pageObject.getElement("confirmPasswordField").sendKeys(password);
        pageObject.getElement("registerAccountButton").click();
        System.out.println("User is registered.");
    }

    private void login(String email, String password)
            throws NoSuchFieldException, IllegalAccessException {
        pageObject.getElement("emailLoginField").sendKeys(email);
        pageObject.getElement("passwordLoginField").sendKeys(password);
        pageObject.getElement("signInButton").click();
        System.out.println("User is logged in.");
    }

}
