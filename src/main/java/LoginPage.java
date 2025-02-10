import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name='email']")
    private WebElement emailInputField;

    @FindBy(css = ".input-password")
    private WebElement passwordInputField;

    @FindBy(css = ".registration-btn")// data-test="submit"
    private WebElement loginButton;

    @FindBy(css = "h1")
    private WebElement header;

    @FindBy(css = "[class='link']")
    private WebElement headerLink;
    @FindBy(css = ".text-error")
    private WebElement textError;

    @FindBy(xpath = "//*[contains(text(), 'An error occurred while logging in. Please try again later')]")
    private WebElement textErrorInvalidPassword;

    @FindBy(css = ".password-eye")
    private WebElement passwordEye;

    @FindBy(css = "#root > div > div > p")
    private WebElement linkUndTextNotRegistered;

    @FindBy (css = "#root > div > div > form > p > a")
    private WebElement linkSingUp;



    public void emailIsDisplayed() {
        assertTrue(emailInputField.isDisplayed());
    }

    public void passwordIsDisplayed() {
        assertTrue(passwordInputField.isDisplayed());
    }

    public void enterEmail(String emailValue) {
        emailInputField.sendKeys(emailValue);
    }

    public void enterPassword(String passwordValue) {
        passwordInputField.sendKeys(passwordValue);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void checkTextError(String textErrorValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOf(textError));
        assertEquals(textErrorValue, textError.getText());
        System.out.println(textErrorValue);
        System.out.println(textError.getText());
    }

    public void checkLoginButtonDisabled() {
        assertFalse(loginButton.isEnabled());
    }

    public void checkTextErrorInvalidPassword(String textErrorValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOf(textErrorInvalidPassword));
        assertEquals(textErrorValue, textErrorInvalidPassword.getText());
    }

    public void checkVerifyPasswordMasking() {
        //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //  wait.until(ExpectedConditions.visibilityOf(emailInputField));//passwordInputField)).sendKeys();
        String fieldType = passwordInputField.getAttribute("type");
        assertEquals("password", fieldType);
    }

    public void checkLinkUndTextNotRegisteredNotDisplayed() {
        assertFalse(linkUndTextNotRegistered.isDisplayed());
    }
    public void clickLinkSingUp (){
        linkSingUp.click();
    }

}



