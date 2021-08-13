package testData;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider()
    public static Object[][] nativeTestData() {
        return new Object[][]{{DataPropertiesFile.getTestData().getProperty("email"),
                DataPropertiesFile.getTestData().getProperty("userName"),
                DataPropertiesFile.getTestData().getProperty("password"),
                DataPropertiesFile.getTestData().getProperty("nativePageTitle")}};
    }

    @DataProvider()
    public static Object[][] webTestData() {
        return new Object[][]{{DataPropertiesFile.getTestData().getProperty("url"),
                DataPropertiesFile.getTestData().getProperty("keyWord"),
                DataPropertiesFile.getTestData().getProperty("siteTitle")}};
    }

}
