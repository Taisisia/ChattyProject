import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-test='post-header__plus']")
    private WebElement createAPost;
    @FindBy(css = "[href=\"/userprofile\"]")
    private WebElement yourProfile;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div/div[2]/p")
    private WebElement dropdownMenu;
    @FindBy(css = "[data-test=\"profileEmail\"]")
    private WebElement profileEmail;
    @FindBy(css = "#root > div.home-blog.home-page > div.posts > div.container > div > div:nth-child(1)")
    private WebElement firstPost;
    @FindBy(css = "label[for='myPostsId']")
    private WebElement labelMyPosts;
    @FindBy(css = "[data-test=\"edit-button\"]")
    private WebElement editButton;
    @FindBy(css = "[name=\"title\"]")//
    private WebElement titleField;
    @FindBy(css = "[type=\"submit\"]")
    private WebElement submitButton;
    @FindBy(tagName = "h3")
    private WebElement headerPost;
    @FindBy(css = "[data-test=\"description-input\"]")
    private WebElement descriptionField;
    @FindBy(css = "[class=\"post__description\"]")
    private WebElement descriptionPost;
    @FindBy(css = "[name=\"content\"]")
    private WebElement contentField;

    @FindBy(css = "[class=\"post-content__body\"]")
    private WebElement contentPost;
    @FindBy(id = "publishDate")
    private WebElement dateField;
    @FindBy(css = "label[for='draftCheckbox']")
    //   @FindBy(css = "id=\"draftCheckbox\"")

    private WebElement labelDraftCheckbox;
    @FindBy(css = "[class=header__logo]")
    private WebElement headerLogo;
    @FindBy(css = "li:nth-of-type(2) a")
    private WebElement aboutLink;

    public void createNewPost() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf( createAPost));
        createAPost.click();
    }

    public void checkGoToHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(headerLogo));
        headerLogo.isDisplayed();
    }

    public void clickDropDownMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dropdownMenu));
        dropdownMenu.click();
        wait.until(ExpectedConditions.visibilityOf(yourProfile));
    }

    public void clickYourProfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(yourProfile));
        yourProfile.click();
    }

    public void selectionCheckBoxMyPosts() {
        labelMyPosts.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstPost));
    }

    public void clickFirstPost() {
        firstPost.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(editButton));
    }

    public void clickEditButton() {
        editButton.click();
    }

    public void editingTitleField(String titleFieldValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(titleField));
        titleField.clear();
        wait.until(ExpectedConditions.attributeToBe(titleField, "value", ""));
        titleField.sendKeys(titleFieldValue);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void checkHeaderPost(String headerPostValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(headerPost));
        assertEquals(headerPostValue, headerPost.getText());
    }

    public void editingDescriptionPost(String descriptionPostValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(descriptionField));
        descriptionField.clear();
        wait.until(ExpectedConditions.attributeToBe(descriptionField, "value", ""));
        descriptionField.sendKeys(descriptionPostValue);
    }

    public void checkDescriptionPost(String descriptionPostValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(descriptionPost));
        assertEquals(descriptionPostValue, descriptionPost.getText());
    }

    public void editingContentPost(String contentPostValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(contentField));
        contentField.clear();
        wait.until(ExpectedConditions.attributeToBe(contentField, "value", ""));
        contentField.sendKeys(contentPostValue);
    }

    public void checkContentPost(String contentPostValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(contentPost));
        assertEquals(contentPostValue, contentPost.getText());
    }

    public void editingDatePost(String datePostValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dateField));
        dateField.sendKeys(datePostValue);
    }

    public void selectionCheckDraftCheckbox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(labelDraftCheckbox));
        labelDraftCheckbox.click();
    }
    public void clickAbout (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(aboutLink));
        aboutLink.click();
    }
}
