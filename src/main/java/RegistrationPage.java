import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    Faker faker = new Faker();

    @FindBy(css = "[name='email']")
    private WebElement emailInputField;
    @FindBy(css = "[name='password']")
    private WebElement passwordInputField;
    @FindBy(css = "[name='confirmPassword']")
    private WebElement confirmPasswordInputField;
    @FindBy(css = ".registration-btn")
    private WebElement registrationButton;
    @FindBy(css = ".text-error")
    private WebElement textErrorEmailAlreadyExists;
    @FindBy(css = "[href='/about']")
    private WebElement linkContactUs;
    @FindBy(css = "[href='/about']")
    private WebElement linkAboutUs;
    @FindBy(css = "[href='/login']")
    private WebElement linkLogin;

    public void enterEmailInputField(String emailValue) {
        emailInputField.sendKeys(emailValue);
    }

    public void enterPasswordInputField(String passwordValue) {
        passwordInputField.sendKeys(passwordValue);
    }

    public void enterConfirmPasswordInputField(String confirmPasswordValue) {
        confirmPasswordInputField.sendKeys(confirmPasswordValue);
    }

    public void clickRegistrationButton() {
        registrationButton.click();
    }

    public void checkRegistrationButtonDisabled() {
        assertFalse(registrationButton.isEnabled());

    }

    public void checkTextErrorEmailAlreadyExists(String textErrorEmailAlreadyExistsValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOf(textErrorEmailAlreadyExists));
        assertEquals(textErrorEmailAlreadyExistsValue, textErrorEmailAlreadyExists.getText());
    }

    public void checkLinkContactUsNotDisplayed() {
        assertFalse(linkContactUs.isDisplayed());
    }

    public void checkLinkAboutUsNotDisplayed() {
        assertFalse(linkAboutUs.isDisplayed());
    }

    public void checkLoginLinkNavigatesToLoginPage() {
        linkLogin.click();
        assertEquals("http://chatty.telran-edu.de:8089/login", driver.getCurrentUrl());
    }
    public void registrationUserRandom() {
        String emailRandom = faker.internet().emailAddress();
        String passwordRandom = faker.internet().password();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField(emailRandom );
        registrationPage.enterPasswordInputField(passwordRandom);
        registrationPage.enterConfirmPasswordInputField(passwordRandom);
        registrationPage.clickRegistrationButton();

    }
}

