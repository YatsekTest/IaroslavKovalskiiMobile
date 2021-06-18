package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebMobileTest extends BaseTest {

    //TODO: Data provider is necessary here
    @Test(groups = {"web"}, description = "This test searches results for keyword on Google-search web-page.")
    public void openWebPageTest() throws NoSuchFieldException, IllegalAccessException {
        openSearchPage("https://google.com"); //TODO: site url to properties
        searchKeyword("EPAM"); //TODO: keyword for search to properties
        Assert.assertTrue(pageObject.getElements("searchResults").size() > 0);
        Assert.assertTrue(pageObject.getElements("searchResults")
                .get(0).getText().contains("EPAM")); //TODO: keyword for search to properties
    }

    private void openSearchPage(String url) {
        getDriver().get(url);
        new WebDriverWait(getDriver(), 5)
                .until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
        assert ((WebDriver) getDriver()).getTitle().equals("Google") //TODO: site title to properties
                : "This is not Google homepage!";
        System.out.println(getDriver().getTitle() + " site opening done.");
    }

    private void searchKeyword(String keyword) throws NoSuchFieldException, IllegalAccessException {
        pageObject.getElement("searchField").sendKeys(keyword + "\n");
        System.out.println("Search for \"" + keyword + "\" keyword done.");
    }

}
