package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class InventoryPage {

    private WebDriver driver;

    private By inventoryTitle = By.className("title");
    private By firstAddToCart =
            By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isInventoryPageDisplayed() {
        WaitUtils.waitForElementVisible(driver, inventoryTitle, 10);
        return driver.findElement(inventoryTitle).isDisplayed();
    }

    public void addProductToCart() {
        driver.findElement(firstAddToCart).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}
