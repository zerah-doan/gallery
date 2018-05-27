package stepdefs;

import config.Config;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import webdriver.WebDriverFactory;
import webdriver.WebDriverManager;

public class Hooks {
    @Before
    public void before() {
        WebDriverManager.setWebDriver(WebDriverFactory.createInstance(Config.getProperty("browser")));
        WebDriverManager.getDriver().get(Config.getProperty("url"));
    }

    @After
    public void after() {
        WebDriverManager.dismissWebDriver();
    }
}
