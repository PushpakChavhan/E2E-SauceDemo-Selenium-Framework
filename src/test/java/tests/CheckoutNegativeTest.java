package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;

public class CheckoutNegativeTest extends BaseTest {

    @Test
    public void checkoutWithoutFirstName() {

        new LoginPage(driver).login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addProductToCart();
        inventory.goToCart();

        CartPage cart = new CartPage(driver);
        cart.proceedToCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.submitEmptyForm();

        Assert.assertTrue(checkout.isErrorDisplayed());
    }
}
