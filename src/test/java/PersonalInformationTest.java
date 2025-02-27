import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;

public class PersonalInformationTest extends BaseTest {
    @Test
    public void verifyPersonalInformationIsDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2001@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.clickDropDownMenu();
        homePage.clickYourProfile();
    }

    @Test
    void successfulPersonalInformationEditing() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2001@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.clickDropDownMenu();
        homePage.clickYourProfile();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.editClick();
        personalInformationPage.enterName("Johni");
        personalInformationPage.enterSurname("Dou");
        personalInformationPage.enterPhone("+489067236457");
      //  personalInformationPage.downloadAvatar();
      //  sleep(5000);
        personalInformationPage.clickProfileSaveButton();

    }

    @Test
    void successfulChangePassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2001@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.clickDropDownMenu();
        homePage.clickYourProfile();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.clickChangePasswordButton();
        personalInformationPage.enterOldPassword("ukraine25");
        personalInformationPage.enterNewPassword("ukraine26");
        personalInformationPage.enterConfirmNewPassword("ukraine26");
        personalInformationPage.clickSaveButtonChangePassword();
    }

    @Test
    void cannotEditPersonalInformationWithInvalidFieldName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2001@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.clickDropDownMenu();
        homePage.clickYourProfile();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.editClick();
        personalInformationPage.enterName("*********************");
        personalInformationPage.checkProfileSaveButton();
    }

    @Test
    void cannotEditPersonalInformationWithEmptyName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2001@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.clickDropDownMenu();
        homePage.clickYourProfile();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.editClick();
        personalInformationPage.enterName("");
        personalInformationPage.clickProfileSaveButton();
    }


    @Test
    void cannotEditPersonalInformationWithInvalidFieldSurname() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2001@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.clickDropDownMenu();
        homePage.clickYourProfile();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.editClick();
        personalInformationPage.enterSurname("*********************");
        personalInformationPage.checkProfileSaveButton();
    }

    @Test
    void cannotEditPersonalInformationWithEmptySurname() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2001@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.clickDropDownMenu();
        homePage.clickYourProfile();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.editClick();
        personalInformationPage.enterSurname("");
        personalInformationPage.clickProfileSaveButton();
    }

    @Test
    void cannotEditPersonalInformationWithInvalidDate() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2001@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.clickDropDownMenu();
        homePage.clickYourProfile();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.editClick();
        personalInformationPage.enterBirthDate("14.01.2026");
        personalInformationPage.checkProfileSaveButton();
    }

    @Test
    void cannotEditPersonalInformationWithEmptyFieldPhone() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2001@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.clickDropDownMenu();
        homePage.clickYourProfile();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.editClick();
        personalInformationPage.enterPhone("");
        personalInformationPage.clickProfileSaveButton();
    }
}
