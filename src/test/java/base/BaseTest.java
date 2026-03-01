package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        // Initialize driver (local or grid)
        DriverFactory.initDriver();

        // Get driver instance
        driver = DriverFactory.getDriver();

        // Browser settings
        driver.manage().window().maximize();

        // Launch application
        driver.get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {

        // Quit browser safely
        DriverFactory.quitDriver();
    }
}
