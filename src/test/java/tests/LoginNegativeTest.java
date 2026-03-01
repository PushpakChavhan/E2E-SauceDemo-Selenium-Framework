package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginNegativeTest extends BaseTest {

    @Test
    public void loginWithInvalidPassword() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "wrong_pass");

        Assert.assertTrue(
                login.isErrorDisplayed(),
                "Error message not displayed for invalid login"
        );
    }

    @Test
    public void loginWithLockedUser() {
        LoginPage login = new LoginPage(driver);
        login.login("locked_out_user", "secret_sauce");

        Assert.assertTrue(
                login.isErrorDisplayed(),
                "Locked out user error not displayed"
        );
    }
}
