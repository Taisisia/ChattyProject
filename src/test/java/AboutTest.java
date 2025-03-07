import org.junit.jupiter.api.Test;


public class AboutTest extends BaseTest {
    @Test
    public void checkHeaderText()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2025@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.clickAbout();
        AboutPage aboutPage = new AboutPage(driver);
        aboutPage.checkHeader("About Chatty");
    }
    @Test
    public void checkTextPartFirst() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2025@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.clickAbout();
        AboutPage aboutPage = new AboutPage(driver);
        aboutPage.checkTextPartFirst( "Chatty is a social network ");
    }
    @Test
    public void checkTextPartSecond() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2025@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.clickAbout();
        AboutPage aboutPage = new AboutPage(driver);
        aboutPage.checkTextPartSecond("Join Chatty today and become a part of our growing community. ");
    }


}
