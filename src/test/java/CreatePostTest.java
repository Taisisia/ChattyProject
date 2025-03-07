import com.github.javafaker.Faker;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;

public class CreatePostTest extends BaseTest {
    Faker faker = new Faker();

    @Test
    void successfulPostCreation() {
        String title = faker.lorem().word();
        String description = faker.lorem().word();
        String content = faker.lorem().paragraph();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2025@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.createNewPost();
        CreatePostPage createPost = new CreatePostPage(driver);
        createPost.enterTitleInputField(title);
        createPost.enterDescriptionInputField(description);
        createPost.enterPublishDateInputField(content);
        createPost.downloadImageInputField();
        createPost.clickSubmitButton();
    }

    @Test
    void successfulPostCreationWithScheduledDate() {
        String title = faker.lorem().word();
        String description = faker.lorem().word();
        String content = faker.lorem().paragraph();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2025@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.createNewPost();
        CreatePostPage createPost = new CreatePostPage(driver);
        createPost.enterTitleInputField(title);
        createPost.enterDescriptionInputField(description);
        createPost.enterPublishDateInputField(content);
        createPost.downloadImageInputField();
        createPost.selectionPublishDateInputField("14.02.2025");
        createPost.clickSubmitButton();
    }

    @Test
    void successfulPostDraftCreation() {
        String title = faker.lorem().word();
        String description = faker.lorem().word();
        String content = faker.lorem().paragraph();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2025@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.createNewPost();
        CreatePostPage createPost = new CreatePostPage(driver);
        createPost.enterTitleInputField(title);
        createPost.enterDescriptionInputField(description);
        createPost.enterPublishDateInputField(content);
        createPost.downloadImageInputField();
        createPost.selectionCheckBoxSaveAsADraft();
        createPost.clickSubmitButton();
    }

    @Test
    void successfulPostCreationWithEmptyDescription() {
        String title = faker.lorem().word();
        String content = faker.lorem().paragraph();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2025@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.createNewPost();
        CreatePostPage createPost = new CreatePostPage(driver);
        createPost.enterTitleInputField(title);
        createPost.enterPublishDateInputField(content);
        createPost.downloadImageInputField();
        createPost.clickSubmitButton();
        createPost.textErrorIsDisplayed();
    }

    @Test
    void successfulPostCreationWithEmptyContent() {
        String title = faker.lorem().word();
        String description = faker.lorem().word();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2025@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.createNewPost();
        CreatePostPage createPost = new CreatePostPage(driver);
        createPost.enterTitleInputField(title);
        createPost.enterDescriptionInputField(description);
        createPost.downloadImageInputField();
        createPost.clickSubmitButton();
        createPost.textErrorIsDisplayed();
    }

    @Test
    void postCreationFailsWithEmptyTitle() {
        String title = faker.lorem().word();
        String description = faker.lorem().word();
        String content = faker.lorem().paragraph();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2025@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.createNewPost();
        CreatePostPage createPost = new CreatePostPage(driver);
        createPost.enterDescriptionInputField(description);
        createPost.enterPublishDateInputField(content);
        createPost.clickSubmitButton();
        createPost.textErrorIsDisplayed();

    }


}
