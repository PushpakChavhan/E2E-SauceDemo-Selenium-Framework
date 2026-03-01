package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;

public class InventoryTest extends BaseTest {

    @Test
    public void verifyInventoryTitle() {
        new LoginPage(driver).login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        InventoryPage inventory = new InventoryPage(driver);
        Assert.assertTrue(inventory.isInventoryPageDisplayed());
    }
}
