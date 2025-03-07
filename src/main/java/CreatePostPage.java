import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

import static java.lang.Thread.sleep;

public class CreatePostPage {
    WebDriver driver;

    public CreatePostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name='title']")
    private WebElement titleInputField;

    @FindBy(css = "class=\"form-control \"")
    private WebElement titleInputFieldNotEmpty;

    @FindBy(css = "[data-test='description-input']")
    private WebElement descriptionInputField;

    @FindBy(css = "[name='content']")
    private WebElement contentInputField;

    @FindBy(xpath = "//input [@type=\"file\"]")
    private WebElement imageInputField;
    @FindBy(css = "[data-test=\"uploaded-image\"]")
    private WebElement imageDownload;

    @FindBy(css = "[id='publishDate']")
    private WebElement publishDateInputField;

    @FindBy(css = "[data-test='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/form/div[5]/div[2]/label")//css = "#root > div.home-blog.home-page > div.post-form__section.active > div > form > div.form__checkbox > div.post-header__checkbox > label")
    private WebElement draftCheckbox;

    @FindBy(css = "[class=\"error\"]")
    private WebElement textError;

    public void enterTitleInputField(String titleInputFieldValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(titleInputField));
        titleInputField.sendKeys(titleInputFieldValue);
    }

    public void enterDescriptionInputField(String descriptionInputFieldValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(descriptionInputField));
        descriptionInputField.sendKeys(descriptionInputFieldValue);
    }

    public void enterPublishDateInputField(String contentInputFieldValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(contentInputField));
        contentInputField.sendKeys(contentInputFieldValue);
        titleInputField.isDisplayed();
    }

    public void downloadImageInputField() {

        imageInputField.sendKeys("C:/Users/User/IdeaProjects/ChattyProjects/src/test/resources/Oppenheimer.jpg");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(imageDownload));
        imageDownload.isDisplayed();
    }

    public void selectionPublishDateInputField(String publishDateInputFieldValue)   {

        publishDateInputField.sendKeys(publishDateInputFieldValue);


    }
    public void selectionCheckBoxSaveAsADraft(){
        draftCheckbox.click();
        draftCheckbox.isSelected();
    }


    public void clickSubmitButton() {
        submitButton.click();
    }

    public void textErrorIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(textError));
        textError.isDisplayed();
    }

    //Please fill the field
}
