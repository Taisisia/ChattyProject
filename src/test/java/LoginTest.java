import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class LoginTest extends BaseTest {


    @Test
    public void fieldIsDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailIsDisplayed();
        loginPage.passwordIsDisplayed();
    }

    @Test
    public void successLoginValidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("John2000@gmail.com");
        loginPage.enterPassword("ukraine25");
        loginPage.clickOnLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
        assertEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());

    }

    @Test
    public void invalidEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("invalidEmail@gmail.com");
        loginPage.enterPassword("ukraine25");
        loginPage.clickOnLoginButton();
        loginPage.checkTextError("User not found. Please register.");
    }
    @Test
    void loginWithEmptyEmail()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword("ukraine25");
        loginPage.checkLoginButtonDisabled();
    }

    @Test
    public void invalidPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("John2000@gmail.com");
        loginPage.enterPassword("Ukraine100");
        loginPage.clickOnLoginButton();
        loginPage.checkTextError("An error occurred while logging in. Please try again later");
    }


    @Test
    void loginEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("John2000@gmail.com");
        loginPage.clickOnLoginButton();
        loginPage.checkTextError("Invalid email or password. Please try again.");

    }

    @Test
    void loginWithEmptyEmailAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkLoginButtonDisabled();

    }
    @Test
    void verifyPasswordMasking () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword("Ukraine100");
        loginPage.checkVerifyPasswordMasking();
    }

    @Test
    void loginWithSpacesInEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("                  ");
        loginPage.enterPassword("Ukraine100");
        loginPage.checkLoginButtonDisabled();
    }
    @Test
    void loginWithSpacesInPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("John2000@gmail.com");
        loginPage.enterPassword("          ");
        loginPage.checkLoginButtonDisabled();
    }
    // переход на страницу
    // отсутвутствует строница
}
