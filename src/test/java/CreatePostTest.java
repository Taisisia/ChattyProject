import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;

public class CreatePostTest extends BaseTest {

    @Test
    void successfulPostCreation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2001@gmail.com","ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.createNewPost();
        CreatePostPage createPost = new CreatePostPage(driver);
        createPost.enterTitleInputField("Оппенгеймер ");
        createPost.enterDescriptionInputField("фильм 2023");
        createPost.enterPublishDateInputField("Действие фильма разворачивается не в хронологическом порядке, а параллельно в нескольких эпохах. Одна сюжетная линия повествует собственно биографию Оппенгеймера со студенческих лет, во второй он и другие персонажи рассказывают эту биографию на слушаниях комиссии по допуску к секретной работе, в третьей — Льюис Штраусс во время слушаний в Сенате при утверждении его на должность министра сталкивается с вопросами о его участии в слушаниях Оппенгеймера...");
        createPost.downloadImageInputField();
        createPost.clickSubmitButton();
    }

    @Test
    void successfulPostCreationWithScheduledDate () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2001@gmail.com","ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.createNewPost();
        CreatePostPage createPost = new CreatePostPage(driver);
        createPost.enterTitleInputField("Оппенгеймер ");
        createPost.enterDescriptionInputField("фильм 2023");
        createPost.enterPublishDateInputField("Действие фильма разворачивается не в хронологическом порядке, а параллельно в нескольких эпохах. Одна сюжетная линия повествует собственно биографию Оппенгеймера со студенческих лет, во второй он и другие персонажи рассказывают эту биографию на слушаниях комиссии по допуску к секретной работе, в третьей — Льюис Штраусс во время слушаний в Сенате при утверждении его на должность министра сталкивается с вопросами о его участии в слушаниях Оппенгеймера...");
        createPost.downloadImageInputField();
        createPost.selectionPublishDateInputField("14.02.2025");
        createPost.clickSubmitButton();
    }

    @Test
    void successfulPostDraftCreation() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2000@gmail.com","ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.createNewPost();
        CreatePostPage createPost = new CreatePostPage(driver);
        createPost.enterTitleInputField("Оппенгеймер ");
        createPost.enterDescriptionInputField("фильм 2023");
        createPost.enterPublishDateInputField("Действие фильма разворачивается не в хронологическом порядке, а параллельно в нескольких эпохах. Одна сюжетная линия повествует собственно биографию Оппенгеймера со студенческих лет, во второй он и другие персонажи рассказывают эту биографию на слушаниях комиссии по допуску к секретной работе, в третьей — Льюис Штраусс во время слушаний в Сенате при утверждении его на должность министра сталкивается с вопросами о его участии в слушаниях Оппенгеймера...");
        createPost.downloadImageInputField();
        createPost.selectionCheckBoxSaveAsADraft();
        createPost.clickSubmitButton();
    }

    @Test
    void successfulPostCreationWithEmptyDescription()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2000@gmail.com","ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.createNewPost();
        CreatePostPage createPost = new CreatePostPage(driver);
        createPost.enterTitleInputField("Оппенгеймер ");
        createPost.enterPublishDateInputField("Действие фильма разворачивается не в хронологическом порядке, а параллельно в нескольких эпохах. Одна сюжетная линия повествует собственно биографию Оппенгеймера со студенческих лет, во второй он и другие персонажи рассказывают эту биографию на слушаниях комиссии по допуску к секретной работе, в третьей — Льюис Штраусс во время слушаний в Сенате при утверждении его на должность министра сталкивается с вопросами о его участии в слушаниях Оппенгеймера...");
        createPost.downloadImageInputField();
        createPost.clickSubmitButton();
        createPost.textErrorIsDisplayed();
    }

    @Test
    void successfulPostCreationWithEmptyContent() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2000@gmail.com","ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.createNewPost();
        CreatePostPage createPost = new CreatePostPage(driver);
        createPost.enterTitleInputField("Оппенгеймер ");
        createPost.enterDescriptionInputField("фильм 2023");
        createPost.downloadImageInputField();
        createPost.clickSubmitButton();
        createPost.textErrorIsDisplayed();
        sleep(5000);
    }

    @Test
    void postCreationFailsWithEmptyTitle() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("John2000@gmail.com","ukraine25");
        HomePage homePage = new HomePage(driver);
        homePage.createNewPost();
        CreatePostPage createPost = new CreatePostPage(driver);
        createPost.enterDescriptionInputField("фильм 2023");
        createPost.enterPublishDateInputField("Действие фильма разворачивается не в хронологическом порядке, а параллельно в нескольких эпохах. Одна сюжетная линия повествует собственно биографию Оппенгеймера со студенческих лет, во второй он и другие персонажи рассказывают эту биографию на слушаниях комиссии по допуску к секретной работе, в третьей — Льюис Штраусс во время слушаний в Сенате при утверждении его на должность министра сталкивается с вопросами о его участии в слушаниях Оппенгеймера...");
        createPost.clickSubmitButton();
        createPost.textErrorIsDisplayed();
        sleep(5000);
    }


}
