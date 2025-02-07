import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name='email']")
    private WebElement emailInputField;

    @FindBy(css = ".input-password")
    private WebElement passwordInputField;

    @FindBy(css = ".registration-btn")// data-test="submit"
    private WebElement loginButton;

    @FindBy(css = "h1")
    private WebElement header;

    @FindBy(css = "[class='link']")
    private WebElement headerLink;

    public void emailIsDisplayed() {
        assertTrue(emailInputField.isDisplayed());
    }

    public void passwordIsDisplayed() {
        assertTrue(passwordInputField.isDisplayed());
    }

    public void enterEmail(String emailValue) {
        emailInputField.sendKeys(emailValue);
    }

    public void enterPassword (String passwordValue){
        passwordInputField.sendKeys(passwordValue);
    }
    public void clickOnLoginButton() {
        loginButton.click();
    }

}


