import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;

public class PersonalInformationTest extends BaseTest {
    Faker faker =new Faker();
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
        personalInformationPage.clickProfileSaveButton();

    }

    @Test
    void successfulChangePassword()  {
        String emailRandom = faker.internet().emailAddress();
        String passwordRandom = faker.internet().password();
        String passwordChangeRandom = faker.internet().password();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLinkSignUp();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmailInputField(emailRandom );
        registrationPage.enterPasswordInputField(passwordRandom);
        registrationPage.enterConfirmPasswordInputField(passwordRandom);
        registrationPage.clickRegistrationButton();

        HomePage homePage = new HomePage(driver);
        homePage.clickDropDownMenu();
        homePage.clickYourProfile();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.clickChangePasswordButton();
        personalInformationPage.enterOldPassword(passwordRandom);
        personalInformationPage.enterNewPassword(passwordChangeRandom);
        personalInformationPage.enterConfirmNewPassword(passwordChangeRandom);
        personalInformationPage.clickSaveButtonChangePassword();
    }

    @Test
    void cannotEditPersonalInformationWithInvalidFieldName()  {

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registrationUserRandom();
        HomePage homePage = new HomePage(driver);
        homePage.clickDropDownMenu();
        homePage.clickYourProfile();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.editClick();
        personalInformationPage.enterName("*********************");
        personalInformationPage.checkProfileSaveButton();
    }

    @Test
    void cannotEditPersonalInformationWithEmptyName() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registrationUserRandom();
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
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registrationUserRandom();
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
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registrationUserRandom();
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
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registrationUserRandom();
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
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registrationUserRandom();
        HomePage homePage = new HomePage(driver);
        homePage.clickDropDownMenu();
        homePage.clickYourProfile();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.editClick();
        personalInformationPage.enterPhone("");
        personalInformationPage.clickProfileSaveButton();
    }
}
