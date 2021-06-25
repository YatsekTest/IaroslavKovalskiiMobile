package tests;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageObjects.PageObject;
import interfaces.IDriver;
import interfaces.IPageObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver;
    protected IPageObject pageObject;

    @Override
    public AppiumDriver getDriver() {
        return appiumDriver;
    }

    @Parameters({"platformName", "appType", "deviceName", "udid", "browserName", "app", "appPackage", "appActivity", "bundleId"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName,
                      String appType,
                      @Optional("") String deviceName,
                      @Optional("") String udid,
                      @Optional("") String browserName,
                      @Optional("") String app,
                      @Optional("") String appPackage,
                      @Optional("") String appActivity,
                      @Optional("") String bundleId
    ) throws Exception {
        System.out.println("Before: app type is " + appType + ".");
        setAppiumDriver(platformName, deviceName, udid, browserName, app, appPackage, appActivity, bundleId);
        setPageObject(appType, appiumDriver);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        appiumDriver.closeApp();
        System.out.println("After: finished.");
    }

    private void setAppiumDriver(String platformName, String deviceName, String udid, String browserName,
                                 String app, String appPackage, String appActivity, String bundleId) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        // mandatory Android capabilities
        desiredCapabilities.setCapability("platformName", platformName);
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("udid", udid);
        if (app.endsWith(".apk")) {
            desiredCapabilities.setCapability("app", (new File(app)).getAbsolutePath());
        }
        desiredCapabilities.setCapability("browserName", browserName);
        desiredCapabilities.setCapability("chromedriverDisableBuildCheck", "true");
        // Capabilities for test of Android native app on EPAM Mobile Cloud
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);
        // Capabilities for test of iOS native app on EPAM Mobile Cloud
        desiredCapabilities.setCapability("bundleId", bundleId);
        try {
            appiumDriver = new AppiumDriver(new URL(System.getProperty("ts.appium")), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        pageObject = new PageObject(appType, appiumDriver);
    }

}
