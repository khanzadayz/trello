package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfigParser {
    public static String browser;
    public static String domain;
    private static final Logger LOGGER = Logger.getLogger(ConfigParser.class.getName());

    public static void readConfig() {
        String current;
        try {
            current = new java.io.File(".").getCanonicalPath();
            System.out.println("Current dir:" + current);
            String currentDir = System.getProperty("user.dir");
            System.out.println("Current dir using System:" + currentDir);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        Properties prop = new Properties();
        String propFileName = "src/test/java/config/config.properties";

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(propFileName);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        try {
            prop.load(inputStream);
        } catch (IOException e) {
            LOGGER.info("property file '" + propFileName + "' not found in the classpath");
        }

        browser = prop.getProperty("browser");
        domain = prop.getProperty("domain");
    }

    public static String getDomain() {
        if (domain == null) {
            readConfig();
        }
        return domain;
    }

    public static String getBrowser() {
        if (browser == null) {
            readConfig();
        }
        return browser;
    }
}