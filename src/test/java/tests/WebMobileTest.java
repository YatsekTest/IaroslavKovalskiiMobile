package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestDataProvider;

public class WebMobileTest extends BaseTest {

    @Test(description = "This test searches results for keyword on Google-search web-page.",
            dataProviderClass = TestDataProvider.class, dataProvider = "webTestData")
    public void openWebPageTest(String url, String keyWord, String siteTitle)
            throws NoSuchFieldException, IllegalAccessException {
        openSearchPage(url, siteTitle);
        searchKeyword(keyWord);
        Assert.assertTrue(pageObject.getElements("searchResults").size() > 0);
        Assert.assertTrue(pageObject.getElements("searchResults")
                .get(0).getText().contains(keyWord));
        System.out.println("Search for the keyword on Google Web cite test done.");
    }

    private void openSearchPage(String url, String siteTitle) {
        getDriver().get(url);
        new WebDriverWait(getDriver(), 5)
                .until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
        assert ((WebDriver) getDriver()).getTitle().equals(siteTitle)
                : "This is not Google homepage!";
        System.out.println(getDriver().getTitle() + " site opening done.");
    }

    private void searchKeyword(String keyword) throws NoSuchFieldException, IllegalAccessException {
        pageObject.getElement("searchField").sendKeys(keyword);
        if (getDriver().getCapabilities().getCapability("platformName").equals("iOS")) {
            pageObject.getElement("searchField").submit();
        } else {
            pageObject.getElement("searchField").sendKeys("\n");
        }
        new WebDriverWait(getDriver(), 5)
                .until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
        System.out.println("Search for \"" + keyword + "\" keyword done.");
    }

}
