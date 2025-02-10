import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name='email']")
    private WebElement emailInputField;

    @FindBy(css = "[name='password']")
    private WebElement passwordInputField;

    @FindBy(css = "[name='confirmPassword']")
    private WebElement confirmPasswordInputField;

    @FindBy (css = ".registration-btn")
    private  WebElement registrationButton;

    @FindBy  (css = ".text-error")
    private WebElement textErrorEmailAlreadyExists;


    public void enterEmailInputField (String emailValue){
        emailInputField.sendKeys(emailValue);
    }
    public void enterPasswordInputField (String passwordValue){
        passwordInputField.sendKeys(passwordValue);
    }
    public void enterConfirmPasswordInputField (String confirmPasswordInputFieldValue) {
        confirmPasswordInputField.sendKeys(confirmPasswordInputFieldValue);
    }
    public void clickRegistrationButton (){
        registrationButton.click();
    }
    public void checkRegistrationButtonDisabled() {
        assertFalse(registrationButton.isEnabled());
    }
    public void checkTextErrorEmailAlreadyExists(String textErrorEmailAlreadyExistsValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOf(textErrorEmailAlreadyExists));
        assertEquals(textErrorEmailAlreadyExistsValue, textErrorEmailAlreadyExists.getText());
    }

}
