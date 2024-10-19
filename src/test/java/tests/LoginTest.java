package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.time.Duration;

public class LoginTest
{
    private WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void setup()   {
        driver= new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(20));
    }

    @Test(priority = 1)
    public void checkIds() {
        Assert.assertTrue(new LoginPage(driver).checkIds());
    }

    @Test(priority = 2)
    public void validLoginTC()  {
        new LoginPage(driver)
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickOnLoginButton();
        Assert.assertTrue(new LoginPage(driver).isSwagLabsVisible());
    }

    @Test(priority =3)
    public void InvalidLoginTC()  {
        new LoginPage(driver)
                .enterUsername("standard")
                .enterPassword("secret")
                .clickOnLoginButton();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(LoginPage.getErrorMessage(driver), expectedErrorMessage, "Error message did not match!");
    }
    @Test(priority = 4)
    public void emptyUsernameTC() {
        new LoginPage(driver)
                .enterPassword("secret")
                .clickOnLoginButton();
        String expectedErrorMessage = "Epic sadface: Username is required";
        Assert.assertEquals(LoginPage.getErrorMessage(driver), expectedErrorMessage, "Error message for empty username did not match!");
    }

    @Test(priority = 5)
    public void emptyPasswordTC() {
        new LoginPage(driver)
                .enterUsername("standard")
                .clickOnLoginButton();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(LoginPage.getErrorMessage(driver), expectedErrorMessage, "Error message for empty password did not match!");
    }

    @AfterMethod(alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}
