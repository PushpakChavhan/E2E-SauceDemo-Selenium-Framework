package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CartPage {

    private WebDriver driver;

    private By checkoutBtn = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void proceedToCheckout() {
        WaitUtils.waitForElementVisible(driver, checkoutBtn, 10);
        driver.findElement(checkoutBtn).click();
    }

    public boolean isCheckoutButtonDisplayed() {
        return driver.findElement(By.id("checkout")).isDisplayed();
    }

}
