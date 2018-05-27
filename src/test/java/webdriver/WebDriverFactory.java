package webdriver;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
    public static <T extends MutableCapabilities> WebDriver createInstance(BrowserType browserType, T options) {
        WebDriver driver = null;
        switch (browserType) {
            case CHROME:
            default:
                io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
                driver = (options instanceof ChromeOptions) ? new ChromeDriver((ChromeOptions) options) : new ChromeDriver();
                break;
            case FIREFOX:
                io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
                driver = (options instanceof FirefoxOptions) ? new FirefoxDriver((FirefoxOptions) options) : new FirefoxDriver();
                break;
            case IE:
                break;
            case EDGE:
                break;
            case OPERA:
                break;
        }
        return driver;
    }

    public static WebDriver createInstance(BrowserType browserType) {
        return createInstance(browserType, null);
    }

    public static <T extends MutableCapabilities> WebDriver createInstance(String browserName, T options) {
        BrowserType type = BrowserType.getBrowserType(browserName);
        return createInstance(type, options);
    }

    public static WebDriver createInstance(String browserName) {
        return createInstance(browserName, null);
    }


}
