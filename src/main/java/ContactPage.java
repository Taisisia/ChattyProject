import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ContactPage {
    WebDriver driver;
    public ContactPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css ="[name='name']")
   // @FindBy(css = "[id=name]")
    private WebElement nameInputField;

    @FindBy(css = "[name='email']")
    private WebElement emailInputField;

    @FindBy(css = " [name='content']")
    private WebElement messageInputField;

    @FindBy(css = " [type='submit']")
    private WebElement sendMessageButton;

    @FindBy(css = " #root .contact div div div" )
    private WebElement successMessage;

//    @FindBy(css = ".success-message")
//    private WebElement successMessage;
//@FindBy(css = "@FindBy(css = [class='success-message'])" +
//        "    private WebElement successMessage;")
//private WebElement successMessage;





    public void nameIsDisplayed() {
        assertTrue(nameInputField.isDisplayed());
    }

    public void emailIsDisplayed() {
        assertTrue(emailInputField.isDisplayed());
    }
    public void messageIsDisplayed() {
        assertTrue( messageInputField.isDisplayed());
    }
    public void sendMessageButtonIsEnabled() {
        assertTrue(sendMessageButton.isEnabled());
    }



    public void enterNameInputField(String nameValue){
        nameInputField.sendKeys(nameValue);

    }
     public void enterEmailInputField(String emailValue){
        emailInputField.sendKeys(emailValue);
     }
     public void enterMessageInputField(String messageText){
        emailInputField.sendKeys("messageInputField");
     }
     public void clickSendMessageButton(){
        sendMessageButton.click();
     }
    public void checkSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        successMessage.isDisplayed();
    }

}
