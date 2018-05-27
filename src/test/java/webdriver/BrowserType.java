package webdriver;

import java.util.Arrays;
import java.util.List;

public enum BrowserType {
    CHROME("gc", "chrome"),
    FIREFOX("ff", "firefox"),
    IE("ie"),
    EDGE("edge"),
    OPERA("opera");

    private List<String> browserName;

    BrowserType(String... args) {
        this.browserName = Arrays.asList(args);
    }

    public List<String> getBrowserName() {
        return browserName;
    }

    public static BrowserType getBrowserType(String browserName) {
        for (BrowserType type : BrowserType.values()) {
            if (type.getBrowserName().contains(browserName.toLowerCase().trim())) {
                return type;
            }
        }
        return CHROME;
    }
}
