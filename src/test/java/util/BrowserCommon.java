package util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.log4testng.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BrowserCommon extends EventFiringWebDriver {
    public static final Logger LOGGER = Logger.getLogger(BrowserCommon.class);
    public static WebDriver driver;
    protected static Date currentDate;
    //static DateFormat df = addDateTime();

    public BrowserCommon() {
        super(driver);
    }

    @BeforeMethod
    public synchronized static WebDriver getCurrentDriver() {
        if (driver == null) {
            try {
                driver = DriverFactory.getWebDriver();
            } catch (Exception e) {
                LOGGER.error("Exception in web driver" + e);
            }
        }
        return driver;
    }

    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            driver.close();
        }
    };

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

/*    public static String myDate(int days) {
        final int NUMBER_OF_DAYS_AGO = days;
        DateFormat format = new SimpleDateFormat("ddMMyyyy_HHMM");
        format.setLenient(true);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());
        cal.add(Calendar.DATE, NUMBER_OF_DAYS_AGO);
        String stopDate = DateFormat.getDateInstance().format(cal.getTime());
        return stopDate;
    }*/

    public static DateFormat addDateTime() {
        Locale local = new Locale("ru", "RU");
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, local);
        currentDate = new Date();
        return df;
    }

    public String getCurrentDate() {
        Locale local = new Locale("ru", "RU");
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, local);
        currentDate = new Date();
        return df.format(currentDate);
    }

    public static void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForPageLoad() {
        long timeOut = 5000;
        pause(900);
        long end = System.currentTimeMillis() + timeOut;
        while (System.currentTimeMillis() < end) {
            if (String.valueOf(
                    ((JavascriptExecutor) getCurrentDriver())
                            .executeScript("return document.readyState"))
                    .equals("complete")) {
                break;
            }
        }
    }

    public static void fillInput(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static void maximizeBrowser() {
        driver.manage().window().maximize();
    }

}