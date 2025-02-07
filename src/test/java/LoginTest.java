import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {
    @Test
    public void fieldIsDisplayed (){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailIsDisplayed();
        loginPage.passwordIsDisplayed();
    }
    @Test
    public void successLoginValidData(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("John2000@gmail.com");
        loginPage.enterPassword("ukraine25");

        loginPage.clickOnLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
        assertEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());

    }
}
