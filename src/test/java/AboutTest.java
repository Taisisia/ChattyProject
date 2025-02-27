import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;

public class AboutTest extends BaseTest {
    @Test
    public void checkHeaderText() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2000@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.clickAbout();
        AboutPage aboutPage = new AboutPage(driver);
        aboutPage.checkHeader("About Chatty");
    }
    @Test
    public void checkTextPartFirst() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2000@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.clickAbout();
        AboutPage aboutPage = new AboutPage(driver);
        aboutPage.checkTextPartFirst( "Chatty is a social network ");
    }
    @Test
    public void checkTextPartSecond() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2000@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.clickAbout();
        AboutPage aboutPage = new AboutPage(driver);
        aboutPage.checkTextPartSecond("Join Chatty today and become a part of our growing community. ");
    }


}
