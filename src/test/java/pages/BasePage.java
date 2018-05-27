package pages;

import config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.WebDriverManager;

public class BasePage {
    protected WebDriver wd;
    protected WebDriverWait wait;

    public BasePage() {
        this.wd = WebDriverManager.getDriver();
        this.wait = new WebDriverWait(this.wd, Integer.parseInt(Config.getProperty("timeout")));
        PageFactory.initElements(this.wd, this);
    }
}
