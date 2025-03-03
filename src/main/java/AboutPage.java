import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AboutPage {
    WebDriver driver;

    public AboutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (css = "h1")
    private WebElement header;
    @FindBy (xpath= "//*[@id=\"root\"]/div[2]/div/div/p[1]")
    private WebElement textPartFirst;
    @FindBy (xpath = "//*[@id=\"root\"]/div[2]/div/div/p[2]")
    private WebElement textPartSecond;

    public void checkHeader (String headerText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(header));
        assertTrue( header.getText().contains(headerText));
    }
    public void checkTextPartFirst (String textPartFirstValue){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(textPartFirst));
        assertTrue( textPartFirst.getText().contains(textPartFirstValue));
    }
    public void checkTextPartSecond (String textPartSecondValue){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(textPartSecond));
        assertTrue( textPartSecond.getText().contains(textPartSecondValue));
    }

}
