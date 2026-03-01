package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;

public class EndToEndSauceDemoTest extends BaseTest {

    @Test
    public void completeSauceDemoPurchaseFlow() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        // Inventory
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(
                inventoryPage.isInventoryPageDisplayed(),
                "Inventory page not displayed"
        );

        inventoryPage.addProductToCart();
        inventoryPage.goToCart();

        // Cart
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        // Checkout
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.completeCheckout();

        Assert.assertTrue(
                checkoutPage.isOrderSuccessful(),
                "Order was not successful"
        );
    }
}
