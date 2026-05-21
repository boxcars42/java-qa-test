import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class GoogleSearchTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    void testLogin() {
        driver.get("https://practicetestautomation.com/practice-test-login/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("student");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Password123");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();

        wait.until(ExpectedConditions.urlContains("logged-in-successfully"));
        assertTrue(driver.getPageSource().contains("Congratulations"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}