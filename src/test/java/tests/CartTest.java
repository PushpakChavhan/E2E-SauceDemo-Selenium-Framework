package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;

public class CartTest extends BaseTest {

    @Test
    public void addAndRemoveProductFromCart() {

        new LoginPage(driver).login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addProductToCart();
        inventory.goToCart();

        CartPage cart = new CartPage(driver);
        Assert.assertTrue(cart.isCheckoutButtonDisplayed());
    }
}
