import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest extends BaseTest {
    @Test
    public void fieldIsDisplayed() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("John2025@gmail.com");
        loginPage.enterPassword("ukraine25");
        loginPage.clickOnLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
        assertEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());


        HomePage homePage = new HomePage(driver);
        homePage.clickContactLink();

        ContactPage contactPage = new ContactPage(driver);
        contactPage.nameIsDisplayed();
        contactPage.emailIsDisplayed();
        contactPage.messageIsDisplayed();
        contactPage.sendMessageButtonIsEnabled();


    }

    @Test
    public void successfulContactUsWithValidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("John2025@gmail.com");
        loginPage.enterPassword("ukraine25");
        loginPage.clickOnLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
        assertEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());


        HomePage homePage = new HomePage(driver);
        homePage.clickContactLink();
        ContactPage contactPage = new ContactPage(driver);
        contactPage.enterNameInputField("Ammar");
        contactPage.enterEmailInputField("John2000@gmail.com");
        contactPage.enterMessageInputField("I need help. " +
                "I have a system issue and can’t use the website properly.\n" +
                "Мне нужна помощь. У меня проблема с системой, " +
                "и я не могу нормально использовать сайт.");
        contactPage.clickSendMessageButton();
        contactPage.checkSuccessMessage();
        assertEquals("http://chatty.telran-edu.de:8089/contact", driver.getCurrentUrl());


    }

    @Test
    void contactWithEmptyName()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("John2025@gmail.com");
        loginPage.enterPassword("ukraine25");
        loginPage.clickOnLoginButton();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
        assertEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());

        HomePage homePage = new HomePage(driver);
        homePage.clickContactLink();
        ContactPage contactPage = new ContactPage(driver);
        //contactPage.enterNameInputField("Ammar");
        contactPage.enterEmailInputField("smith1990@gamil.com");
        contactPage.enterMessageInputField("I need help. " +
                "I have a system issue and can’t use the website properly.\n" +
                "Мне нужна помощь. У меня проблема с системой, " +
                "и я не могу нормально использовать сайт.");
        contactPage.clickSendMessageButton();
        assertEquals("http://chatty.telran-edu.de:8089/contact", driver.getCurrentUrl());
    }

    @Test
    void contactWithEmptyEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("John2025@gmail.com");
        loginPage.enterPassword("ukraine25");
        loginPage.clickOnLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
        assertEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());

        HomePage homePage = new HomePage(driver);
        homePage.clickContactLink();
        ContactPage contactPage = new ContactPage(driver);
        contactPage.enterNameInputField("Ammar");
        contactPage.enterMessageInputField("I need help. " +
                "I have a system issue and can’t use the website properly.\n" +
                "Мне нужна помощь. У меня проблема с системой, " +
                "и я не могу нормально использовать сайт.");
        contactPage.clickSendMessageButton();
        assertEquals("http://chatty.telran-edu.de:8089/contact"
                , driver.getCurrentUrl());


    }

    @Test
    void contactWithEmptyMessage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("John2025@gmail.com");
        loginPage.enterPassword("ukraine25");
        loginPage.clickOnLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
        assertEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());

        HomePage homePage = new HomePage(driver);
        homePage.clickContactLink();
        ContactPage contactPage = new ContactPage(driver);
        contactPage.enterNameInputField("Ammar");
        contactPage.enterEmailInputField("John2000@gmail.com");
        contactPage.clickSendMessageButton();
        assertEquals("http://chatty.telran-edu.de:8089/contact"
                , driver.getCurrentUrl());
    }

    @Test
    void contactWithInvalidName() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("John2025@gmail.com");
        loginPage.enterPassword("ukraine25");
        loginPage.clickOnLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
        assertEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());

        HomePage homePage = new HomePage(driver);
        homePage.clickContactLink();
        ContactPage contactPage = new ContactPage(driver);
        contactPage.enterNameInputField("Am");
        contactPage.enterEmailInputField("John2025@gmail.com");
        contactPage.enterMessageInputField("I need help. " +
                "I have a system issue and can’t use the website properly.\n" +
                "Мне нужна помощь. У меня проблема с системой, " +
                "и я не могу нормально использовать сайт.");
        contactPage.clickSendMessageButton();
        assertEquals("http://chatty.telran-edu.de:8089/contact"
                , driver.getCurrentUrl());
    }

    @Test
    void contactWithInvalidEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("John2025@gmail.com");
        loginPage.enterPassword("ukraine25");
        loginPage.clickOnLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
        assertEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());

        HomePage homePage = new HomePage(driver);
        homePage.clickContactLink();
        ContactPage contactPage = new ContactPage(driver);
        contactPage.enterNameInputField("Ammar");
        contactPage.enterEmailInputField("John2000gmail.com");
        contactPage.enterMessageInputField("I need help. " +
                "I have a system issue and can’t use the website properly.\n" +
                "Мне нужна помощь. У меня проблема с системой, " +
                "и я не могу нормально использовать сайт.");
        contactPage.clickSendMessageButton();
        assertEquals("http://chatty.telran-edu.de:8089/contact"
                , driver.getCurrentUrl());

    }

    @Test
    void contactWithInvalidMessage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("John2025@gmail.com");
        loginPage.enterPassword("ukraine25");
        loginPage.clickOnLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
        assertEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());

        HomePage homePage = new HomePage(driver);
        homePage.clickContactLink();
        ContactPage contactPage = new ContactPage(driver);
        contactPage.enterNameInputField("Ammar");
        contactPage.enterEmailInputField("John2025@gmail.com");
        contactPage.enterMessageInputField("In");
        contactPage.clickSendMessageButton();
        assertEquals("http://chatty.telran-edu.de:8089/contact"
                , driver.getCurrentUrl());

    }
}
