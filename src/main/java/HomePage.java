import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
        @FindBy(css="[class=header__logo]")
        private WebElement headerLogo ;

    @FindBy(css = "[href='/contact']")
    private WebElement contactLink;
    public void checkHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://chatty.telran-edu.de:8089/homeblog"));
        assertEquals("http://chatty.telran-edu.de:8089/homeblog", driver.getCurrentUrl());
        wait.until(ExpectedConditions.visibilityOf(headerLogo));
        assert headerLogo.isDisplayed();
        // sleep(2000);

    }
    public void clickContactLink(){
        contactLink.click();
    }


        }



