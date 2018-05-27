package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    static String CONFIG_FILE_PATH = "src/test/java/config/env.properties";

    static Properties prop;

    public static String getProperty(String propName) {
        if (prop == null) {
            prop = new Properties();
            try {
                prop.load(new FileInputStream(CONFIG_FILE_PATH));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop.getProperty(propName);

    }
}
