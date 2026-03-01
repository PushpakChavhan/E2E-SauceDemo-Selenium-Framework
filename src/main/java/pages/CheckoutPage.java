package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CheckoutPage {

    private WebDriver driver;

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");

    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");
    private By successMsg = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Positive checkout flow
    public void completeCheckout() {

        WaitUtils.waitForElementVisible(driver, firstName, 10);

        driver.findElement(firstName).sendKeys("Pushpak");
        driver.findElement(lastName).sendKeys("Chavhan");
        driver.findElement(postalCode).sendKeys("411001");

        driver.findElement(continueBtn).click();

        WaitUtils.waitForElementVisible(driver, finishBtn, 10);
        driver.findElement(finishBtn).click();
    }

    // ❌ Negative scenario – empty form
    public void submitEmptyForm() {
        driver.findElement(continueBtn).click();
    }

    public boolean isOrderSuccessful() {
        WaitUtils.waitForElementVisible(driver, successMsg, 10);
        return driver.findElement(successMsg).isDisplayed();
    }

    public boolean isErrorDisplayed() {
        return driver.getPageSource().contains("Error:");
    }
}
