import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest extends BaseTest {
    Faker faker = new Faker();

    @Test
    void successfulRegistrationWithValidDataRandom() {
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField(email);
        registrationPage.enterPasswordInputField(password);
        registrationPage.enterConfirmPasswordInputField(password);
        registrationPage.clickRegistrationButton();
        HomePage homePage = new HomePage(driver);
        homePage.checkGoToHomePage();
    }
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
        String password = faker.internet().password();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField("2000John@gmail");
        registrationPage.enterPasswordInputField(password);
        registrationPage.enterConfirmPasswordInputField(password);
        registrationPage.checkRegistrationButtonDisabled();
    }

    @Test
    void registrationWithInvalidEmailMissingAtSymbol() {
        String password = faker.internet().password();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField("2000JohnJohngmail");
        registrationPage.enterPasswordInputField(password);
        registrationPage.enterConfirmPasswordInputField(password);
        registrationPage.checkRegistrationButtonDisabled();
    }

    @Test
    void registrationWithEmptyEmail() {
        String password = faker.internet().password();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterPasswordInputField(password);
        registrationPage.enterConfirmPasswordInputField(password);
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
            String email = faker.internet().emailAddress();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickLinkSignUp();
            RegistrationPage registrationPage = new RegistrationPage(driver);
            registrationPage.enterEmailInputField(email);

            registrationPage.checkRegistrationButtonDisabled();
        }

    @Test
    void registrationWithMismatchedPasswords() {
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String confirmPassword = faker.internet().password();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField(email);
        registrationPage.enterPasswordInputField(password);
        registrationPage.enterConfirmPasswordInputField(confirmPassword);
        registrationPage.checkRegistrationButtonDisabled();
    }

    @Test
    void registrationWithShortPassword() {
        String email = faker.internet().emailAddress();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField(email);
        registrationPage.enterPasswordInputField("ukraine");
        registrationPage.enterConfirmPasswordInputField("ukraine");
        registrationPage.checkRegistrationButtonDisabled();
    }

    @Test
    void registrationWithLongPassword() {
        String email = faker.internet().emailAddress();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField(email);
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
    void verifyLoginLinkNavigatesToLoginPage() {
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


