import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrationTest extends BaseTest {


@Test
void successfulRegistrationWithValidData() throws InterruptedException {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.clickLinkSignUp();
    RegistrationPage registrationPage = new RegistrationPage(driver);
    registrationPage.enterEmailInputField("John2000@gmail.com");
    registrationPage.enterPasswordInputField("ukraine25");
    registrationPage.enterConfirmPasswordInputField("ukraine25");
    sleep(2000);
    registrationPage.clickRegistrationButton();
    sleep(2000);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
    assertEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());
    sleep(2000);
}

    @Test
    void registrationWithEmailMissingComSuffix() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField("2000John@gmail");
        registrationPage.enterPasswordInputField("ukraine25");
        registrationPage.enterConfirmPasswordInputField("ukraine25");
        registrationPage.checkRegistrationButtonDisabled();
    }

    @Test
    void registrationWithInvalidEmailMissingAtSymbol() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField("2000JohnJohngmail");
        registrationPage.enterPasswordInputField("ukraine25");
        registrationPage.enterConfirmPasswordInputField("ukraine25");
        registrationPage.checkRegistrationButtonDisabled();
    }

    @Test
    void registrationWithEmptyEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterPasswordInputField("ukraine25");
        registrationPage.enterConfirmPasswordInputField("ukraine25");
        registrationPage.checkRegistrationButtonDisabled();
    }

    @Test
    void registrationWithExistingEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField("John2000@gmail.com");
        registrationPage.enterPasswordInputField("ukraine25");
        registrationPage.enterConfirmPasswordInputField("ukraine25");
        registrationPage.clickRegistrationButton();
        registrationPage.checkTextErrorEmailAlreadyExists("Email already exists!");
    }

    @Test
    void registrationWithEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField("John2000@gmail.com");
        registrationPage.checkRegistrationButtonDisabled();
    }

    @Test
    void registrationWithMismatchedPasswords() {
    LoginPage loginPage = new LoginPage( driver);
    loginPage.clickLinkSignUp();
    RegistrationPage registrationPage = new RegistrationPage(driver);
    registrationPage.enterEmailInputField("John2000@gmail.com");
    registrationPage.enterPasswordInputField("ukraine25");
    registrationPage.enterConfirmPasswordInputField("ukraine100");
    registrationPage.checkRegistrationButtonDisabled();
    }

    @Test
    void registrationWithShortPassword() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.clickLinkSignUp();
    RegistrationPage registrationPage = new RegistrationPage(driver);
    registrationPage.enterEmailInputField("John2000@gmail.com");
    registrationPage.enterPasswordInputField("ukraine");
    registrationPage.enterConfirmPasswordInputField("ukraine");
    registrationPage.checkRegistrationButtonDisabled();
    }

    @Test
    void registrationWithLongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField("John2000@gmail.com");
        registrationPage.enterPasswordInputField("G7x$Yp!m2z@K#rQ9tN&dLwV3s^aM0XcU8B*jH4fZT5o(PJ6)AqE%R1u,G7x$Yp!m2z@K#rQ9tN&dLwV3s^aM0XcU8B*jH4fZT5o(PJ6)AqE%R1u");
        registrationPage.enterConfirmPasswordInputField("G7x$Yp!m2z@K#rQ9tN&dLwV3s^aM0XcU8B*jH4fZT5o(PJ6)AqE%R1u,G7x$Yp!m2z@K#rQ9tN&dLwV3s^aM0XcU8B*jH4fZT5o(PJ6)AqE%R1u");
        registrationPage.checkRegistrationButtonDisabled();
    }

    @Test
    void registrationWithEmptyAllFields() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField("");
        registrationPage.enterPasswordInputField("");
        registrationPage.enterConfirmPasswordInputField("");
        registrationPage.checkRegistrationButtonDisabled();
    }

    @Test
    void registrationWithSpacesInFields() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField(" John2000@gmail.com");
        registrationPage.enterPasswordInputField(" ukraine25");
        registrationPage.enterConfirmPasswordInputField(" ukraine25");
        registrationPage.checkRegistrationButtonDisabled();
    }
    @Test
    void registrationButtonIsDisabledWhenFieldsAreEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField("");
        registrationPage.enterPasswordInputField("");
        registrationPage.enterConfirmPasswordInputField("");
        registrationPage.checkRegistrationButtonDisabled();
       // assertFalse(registrationButton.isEnabled());
    }

    @Test
    void verifyLoginLinkNavigatesToLoginPage(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.checkLoginLinkNavigatesToLoginPage();
    }
    @Test
    void verifySignInLinkContactUsNotDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.checkLinkContactUsNotDisplayed();

    }

    @Test
    void verifySignInLinkAboutUsNotDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.checkLinkAboutUsNotDisplayed();
    }
}


