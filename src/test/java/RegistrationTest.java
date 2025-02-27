import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest extends BaseTest {

    @Test
    void successfulRegistrationWithValidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField("John2001@gmail.com");
        registrationPage.enterPasswordInputField("ukraine25");
        registrationPage.enterConfirmPasswordInputField("ukraine25");
        registrationPage.clickRegistrationButton();
        HomePage homePage = new HomePage(driver);
        homePage.checkGoToHomePage();
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
        registrationPage.enterEmailInputField("2000John@gmail.com");
        registrationPage.enterPasswordInputField("ukraine25");
        registrationPage.enterConfirmPasswordInputField("ukraine25");
        registrationPage.clickRegistrationButton();
        registrationPage.checkTextErrorEmailAlreadyExists("Email already exists!");
    }

    @Test
    void registrationWithEmptyPassword() {
    }

    @Test
    void registrationWithMismatchedPasswords() {
    }

    @Test
    void registrationWithShortPassword() {
    }

    @Test
    void registrationWithLongPassword() {
    }

    @Test
    void registrationWithEmptyFields() {}

    @Test
    void registrationWithSpacesInFields() {}
    @Test
    void registrationButtonIsDisabledWhenFieldsAreEmpty() {}

  //  @Test
  //  void verifyLoginLinkNavigatesToLoginPage() {}
//    @Test
  //  void verifySignInLinkContactUsNotDisplayed() {}

  //  @Test
            // void verifySignInLinkAboutUsNotDisplayed() {}
    @Test
    void verifyLoginLinkNavigatesToLoginPage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
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


