package gui.core;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class WebDriverFactory {
    public static WebDriver getDriver (String browser) {
        switch (browser){
            case "chrome":
                return configChrome();
            case "edge":
                return configEdge();
            case "firefox":
                return configFirefox();
            default:
                System.out.println("Wrong browser name" + browser);    // todo: Make log4j log here
                return configChrome();
                //throw new RuntimeException("Unknown Browser " + browser);
        }
    }

    private static ChromeDriver configChrome(){
        ChromeOptions options = new ChromeOptions();
        options.setImplicitWaitTimeout(Duration.ofMillis(20000));
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return new ChromeDriver(options);
    }

    private static EdgeDriver configEdge(){
        EdgeOptions options = new EdgeOptions();
        options.setImplicitWaitTimeout(Duration.ofMillis(20000));
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return new EdgeDriver(options);
    }

    private static FirefoxDriver configFirefox(){
        FirefoxOptions options = new FirefoxOptions();
        options.setImplicitWaitTimeout(Duration.ofMillis(20000));
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return new FirefoxDriver(options);
    }
}
