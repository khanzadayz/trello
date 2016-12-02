package util;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
    static WebDriver driver = null;

    public static void setupDriver() {
        String browser = ConfigParser.getBrowser();
        if (browser.equalsIgnoreCase("chrome")) {
            String chromeBinary = System.getProperty(" ");
            if (chromeBinary == null || chromeBinary.equals("")) {
                String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
                chromeBinary = "src/test/resources/libs/chromedriver-" + os + (os.equals("win") ? ".exe" : "");
                System.setProperty("webdriver.chrome.driver", chromeBinary);
            }
            DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
            driver = new ChromeDriver(chromeCapabilities);
        } else if (browser.equalsIgnoreCase("phantomjs")) {
            Capabilities caps = new DesiredCapabilities();
            ((DesiredCapabilities) caps).setJavascriptEnabled(true);
            ((DesiredCapabilities) caps).setCapability("takesScreenshot", true);

            //((DesiredCapabilities) caps).setCapability(
            //        PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
            //        "phantomjs"
            //);
            driver = new PhantomJSDriver(caps);
        }
        setupBrowser(driver);
    }

    private static void setupBrowser(WebDriver driver) {
        //driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver getWebDriver() {
        if (driver == null) setupDriver();
        return driver;
    }
}