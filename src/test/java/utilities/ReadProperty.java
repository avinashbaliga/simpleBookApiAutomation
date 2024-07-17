package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {

    private static Properties properties = null;

    public static String get(String key) {
        if (properties == null) {
            try {
                File file = new File("src/main/resources/apiConfig.properties");
                FileInputStream fileInputStream = new FileInputStream(file);
                properties = new Properties();
                properties.load(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return properties.getProperty(key);
    }
}
