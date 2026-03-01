package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ConfigReader;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        String execution = ConfigReader.getProperty("execution");
        String browser = ConfigReader.getProperty("browser");

        try {
            if (execution.equalsIgnoreCase("grid")) {

                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setBrowserName(browser);

                driver.set(
                        new RemoteWebDriver(
                                new URL("http://localhost:4444/wd/hub"),
                                caps
                        )
                );

            } else {

//                if (browser.equalsIgnoreCase("chrome")) {
//                    WebDriverManager.chromedriver().setup();
//                    driver.set(new ChromeDriver());
                    if (browser.equalsIgnoreCase("chrome")) {

                        WebDriverManager.chromedriver().setup();

                        ChromeOptions options = new ChromeOptions();

                        // Disable Chrome password manager popup
                        Map<String, Object> prefs = new HashMap<>();
                        prefs.put("credentials_enable_service", false);
                        prefs.put("profile.password_manager_enabled", false);

                        options.setExperimentalOption("prefs", prefs);

                        options.addArguments("--disable-notifications");
                        options.addArguments("--disable-infobars");
                        options.addArguments("--disable-extensions");

                        driver.set(new ChromeDriver(options));

                } else if (browser.equalsIgnoreCase("firefox")) {
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Driver init failed", e);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
