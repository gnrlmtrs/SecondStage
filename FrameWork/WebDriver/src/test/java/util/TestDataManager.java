package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataManager {

    public static String getProperty(String propertyKeyValue) {
        String valueOfProperty = "";
        FileInputStream fis;
        Properties property = new Properties();

        try{
            fis = new FileInputStream("src/test/resources/testdata.properties");
            property.load(fis);

            valueOfProperty = property.getProperty(propertyKeyValue);

        } catch (IOException e) {
            Log.error("No such file" + e.getMessage());
        }
        return valueOfProperty;
    }
}
