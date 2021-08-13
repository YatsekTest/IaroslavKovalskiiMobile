package testData;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class DataPropertiesFile {

    private static Properties testData;
    private static final String DATA_FILE_PATH = "src/main/resources/testData.properties";

    public static Properties getTestData() {
        try(InputStream inputStream = new FileInputStream(DATA_FILE_PATH)) {
            testData = new Properties();
            testData.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Test data can't be loaded.");
        }
        return testData;
    }

}
