package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.utils;

import java.util.Objects;

public class LoginPage {


    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By swagLabs = By.cssSelector(".app_logo");
    private static final By errorMessage = By.cssSelector("div.error-message-container.error");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage enterUsername(String usernameText) {
        utils.sendData(driver, username, usernameText);
        return this;
    }

    public LoginPage enterPassword(String passwordText) {
        utils.sendData(driver, password, passwordText);
        return this;
    }

    public void clickOnLoginButton() {
        utils.clickingOnElement(driver, loginButton);
    }
    public boolean isSwagLabsVisible()
    {
        return utils.findWebElement(driver,swagLabs).isDisplayed();
    }
    public static String getErrorMessage(WebDriver driver) {
        return utils.findWebElement(driver,errorMessage).getText();
    }

    public boolean checkIds ()
    {
        System.out.print(utils.findWebElement(driver, username).getAttribute("id")+"\n" +
                utils.findWebElement(driver, password).getAttribute("id")
                +"\n" +utils.findWebElement(driver, loginButton).getAttribute("id"));

        return Objects.equals(utils.findWebElement(driver, username).getAttribute("id"), "user-name")
                && Objects.equals(utils.findWebElement(driver, password).getAttribute("id"), "password")
                && Objects.equals(utils.findWebElement(driver, loginButton).getAttribute("id"), "login-button");
    }}
