import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest extends BaseTest {

    @Test
    void successfulRegistrationWithValidData() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSingUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField("2000John@gmail.com");
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
    void registrationWithEmailMissingComSuffix(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSingUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField("2000John@gmail");
        registrationPage.enterPasswordInputField("ukraine25");
        registrationPage.enterConfirmPasswordInputField("ukraine25");
        registrationPage.checkRegistrationButtonDisabled();
    }
    @Test
    void  registrationWithInvalidEmailMissingAtSymbol(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSingUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField("2000JohnJohngmail");
        registrationPage.enterPasswordInputField("ukraine25");
        registrationPage.enterConfirmPasswordInputField("ukraine25");
        registrationPage.checkRegistrationButtonDisabled();
    }

    @Test
    void registrationWithEmptyEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSingUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterPasswordInputField("ukraine25");
        registrationPage.enterConfirmPasswordInputField("ukraine25");
        registrationPage.checkRegistrationButtonDisabled();
    }
    @Test
    void registrationWithExistingEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSingUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField("2000John@gmail.com");
        registrationPage.enterPasswordInputField("ukraine25");
        registrationPage.enterConfirmPasswordInputField("ukraine25");
    }

}
