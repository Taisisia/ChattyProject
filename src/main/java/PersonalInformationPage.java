import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class PersonalInformationPage extends BasePage {
    WebDriver driver;

    public PersonalInformationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-test=\"post-header__plus\"]")
    private WebElement edit;

    public void editClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(edit));
        edit.click();
    }

    @FindBy(css = "[data-test=\"profileName\"]")
    private WebElement nameInputField;
    @FindBy(css = "[data-test=\"profileSurname\"]")
    private WebElement surnameInputField;
    @FindBy(css = "[id=\"birthDate\"]")
    private WebElement birthDate;
    @FindBy(css = "[name=\"phone\"]")
    private WebElement phoneInputField;
    @FindBy(css = "[class=\"user_avatar_container__R0kVm\"]")
    private WebElement avatar;
    @FindBy(xpath = "//img[@src='https://cdn-icons-png.flaticon.com/512/149/149071.png']")
    private WebElement avatarDownload;
    @FindBy(css = "[class=\"data-input pass__btn\"]")
    private WebElement changePasswordButton;
    @FindBy(css = "[placeholder=\"Old password\"]")
    private WebElement oldPassword;
    @FindBy(css = "[placeholder=\"New password\"]")
    private WebElement newPassword;
    @FindBy(css = "[placeholder=\"Confirm new password\"]")
    private WebElement confirmNewPassword;
    @FindBy(css = "[class=\"PasswordModal_pass_btn__eGL9h\"]")
    private WebElement saveButton;
    @FindBy(css = "[data-test=\"profileSaveButton\"]")
    private WebElement profileSaveButton;


    public void enterName(String nameValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nameInputField));
        nameInputField.clear();
        wait.until(ExpectedConditions.attributeToBe(nameInputField, "value", ""));
        enterTextToElement(nameValue, nameInputField);

    }

    public void enterSurname(String surnameValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(surnameInputField));
        surnameInputField.clear();
        wait.until(ExpectedConditions.attributeToBe(surnameInputField, "value", ""));
        enterTextToElement(surnameValue, surnameInputField);
    }

    public void enterBirthDate(String birthDateValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(birthDate));
        birthDate.sendKeys(birthDateValue);
    }

    public void enterPhone(String phoneValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(phoneInputField));
        enterTextToElement(phoneValue, phoneInputField);
    }

    public void downloadAvatar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // avatar.click();

        avatar.sendKeys("C:/Users/User/IdeaProjects/ChattyProjects/src/test/resources/Oppenheimer.jpg");
        //  avatar.sendKeys("C:/Users/User/IdeaProjects/ChattyProjects/src/test/resources/Oppenheimer.jpg");
        // wait.until(ExpectedConditions.visibilityOf( avatarDownload));
        //  avatarDownload.isDisplayed();
    }

    public void clickChangePasswordButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(changePasswordButton));
        changePasswordButton.click();
    }

    public void enterOldPassword(String oldPasswordValue) {
        oldPassword.sendKeys(oldPasswordValue);
    }

    public void enterNewPassword(String newPasswordValue) {
        newPassword.sendKeys(newPasswordValue);
    }

    public void enterConfirmNewPassword(String confirmNewPasswordValue) {
        confirmNewPassword.sendKeys(confirmNewPasswordValue);

    }

    public void clickSaveButtonChangePassword() {
        saveButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(changePasswordButton));
    }

    public void clickProfileSaveButton() {
        profileSaveButton.click();
    }

    public void checkProfileSaveButton() {

        assertFalse(profileSaveButton.isEnabled());
    }

}
