// Config utility code

package utils;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties" +e.getMessage());
        }
    }

    /*Returns the base URL for API calls.
     WHY: Keeps environment details externalised so we can switch easily. */
    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    /* Optional generic getter for any property. */
    public static String get(String key) {
        return properties.getProperty(key);
    }

}

