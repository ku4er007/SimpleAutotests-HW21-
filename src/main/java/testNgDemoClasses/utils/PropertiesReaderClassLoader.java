package testNgDemoClasses.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReaderClassLoader {

    private static testNgDemoClasses.utils.PropertiesReaderClassLoader loadProperties = null;
    private static Properties properties = null;
    private static InputStream inputStream = null;

    private PropertiesReaderClassLoader(String propertyFileName) {
        this.inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(propertyFileName);
    }

    public static testNgDemoClasses.utils.PropertiesReaderClassLoader getInstance() {
        if (loadProperties == null) {
            loadProperties = new testNgDemoClasses.utils.PropertiesReaderClassLoader("config.properties");
        }
        return loadProperties;
    }

    public String getValueFromProperty(String key) {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties.getProperty(key);
    }


}
