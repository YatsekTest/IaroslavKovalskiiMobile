package setup;

import org.openqa.selenium.WebElement;

public interface IPageObject {

    WebElement getElement(String elementName) throws NoSuchFieldException, IllegalAccessException;

}
