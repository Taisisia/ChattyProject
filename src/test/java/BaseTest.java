import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    ChromeDriver driver;
    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                 "C:\\Users\\User\\OneDrive\\Документы\\Lessons\\QA\\chromedriver-win64\\chromedriver-win64_133.0.6943.53\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://chatty.telran-edu.de:8089/login");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
