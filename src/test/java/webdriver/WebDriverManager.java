package webdriver;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {
    private static ThreadLocal<WebDriver> manager = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (manager.get() == null) {
            System.out.println("[" + WebDriverManager.class.getName() + "]" + " WebDriver has NOT been set to Manager");
        }
        return manager.get();
    }

    public static void setWebDriver(WebDriver driver) {
        if (manager.get() != null) {
            dismissWebDriver();
        }
        manager.set(driver);
    }

    public static void dismissWebDriver() {
        manager.get().quit();
        manager.remove();
    }


}
