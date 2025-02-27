import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeTest extends BaseTest {

    @Test
    void editingPostTitle() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2000@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.selectionCheckBoxMyPosts();
        homePage.clickFirstPost();
        homePage.clickEditButton();
        homePage.editingTitleField("Oppenheimer");//Oppenheimer
        homePage.clickSubmitButton();
        homePage.checkHeaderPost("Oppenheimer");
    }

    @Test
    void editingPostDescription() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2000@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.selectionCheckBoxMyPosts();
        homePage.clickFirstPost();
        homePage.clickEditButton();
        homePage.editingDescriptionPost("Film 2023");
        homePage.clickSubmitButton();
        homePage.checkDescriptionPost("Film 2023");
    }

    @Test
    void editingPostContent() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2000@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.selectionCheckBoxMyPosts();
        homePage.clickFirstPost();
        homePage.clickEditButton();
        homePage.editingContentPost("Oppenheimer is a 2023 epic biographical drama film written, produced, and directed by Christopher Nolan.[8] It follows the life of J. Robert Oppenheimer, the American theoretical physicist who helped develop the first nuclear weapons during World War II.");
        homePage.clickSubmitButton();
        homePage.checkContentPost("Oppenheimer is a 2023 epic biographical drama film written, produced, and directed by Christopher Nolan.[8] It follows the life of J. Robert Oppenheimer, the American theoretical physicist who helped develop the first nuclear weapons during World War II.");
    }

    @Test
    void editingPostDate() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2000@gmail.com", "ukraine25");
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
        loginPage.successLogin("John2000@gmail.com", "ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.selectionCheckBoxMyPosts();
        homePage.clickFirstPost();
        homePage.clickEditButton();
        homePage.selectionCheckDraftCheckbox();
    }
}
