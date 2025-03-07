import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeTest extends BaseTest {
    Faker faker = new Faker();

    @Test
    void editingPostTitle() {
        String editingTitle = faker.lorem().word();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2025@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.selectionCheckBoxMyPosts();
        homePage.clickFirstPost();
        homePage.clickEditButton();
        homePage.editingTitleField(editingTitle);
        homePage.clickSubmitButton();
        homePage.checkHeaderPost(editingTitle);
    }

    @Test
    void editingPostDescription() {
        String description = faker.lorem().word();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2025@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.selectionCheckBoxMyPosts();
        homePage.clickFirstPost();
        homePage.clickEditButton();
        homePage.editingDescriptionPost(description);
        homePage.clickSubmitButton();
        homePage.checkDescriptionPost(description);
    }

    @Test
    void editingPostContent() {
        String contentPost = faker.lorem().paragraph();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2025@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.selectionCheckBoxMyPosts();
        homePage.clickFirstPost();
        homePage.clickEditButton();
        homePage.editingContentPost(contentPost);
        homePage.clickSubmitButton();
        homePage.checkContentPost(contentPost);
    }

    @Test
    void editingPostDate() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2025@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.selectionCheckBoxMyPosts();
        homePage.clickFirstPost();
        homePage.clickEditButton();
        homePage.editingDatePost("17.02.2025");
        homePage.clickSubmitButton();
    }
    @Test
    void checkDraftCheckboxPostDate() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2025@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.selectionCheckBoxMyPosts();
        homePage.clickFirstPost();
        homePage.clickEditButton();
        homePage.selectionCheckDraftCheckbox();
    }
}
