import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotificationMessageTest {
    public static final String BASE_URL = "http://the-internet.herokuapp.com/";
    WebDriver driver;

    @BeforeMethod
    private void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        WebElement notificationMessage = driver.findElement(new By.ByPartialLinkText("Notification Message"));
        notificationMessage.click();
    }

    @Test
    public void notificationMessageTest() throws InterruptedException {
        WebElement notification = driver.findElement(new By.ByXPath("//a[@href='/notification_message']"));
        notification.click();
        Thread.sleep(2000);

        WebElement actualMessageElement = driver.findElement(new By.ByXPath("//*[@id='flash']"));
        String actualMessageElementText = actualMessageElement.getText();

        String expectedMessage1 = "Action successful";
        String expectedMessage2 = "Action unsuccesful, please try again";

        boolean isEqual = actualMessageElementText.startsWith(expectedMessage1) ||
                actualMessageElementText.startsWith(expectedMessage2);
        Assert.assertTrue(isEqual);
    }

    @AfterMethod
    private void tearDown() {
        driver.quit();
    }
}


