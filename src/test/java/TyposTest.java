import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TyposTest {

    public static final String BASE_URL = "http://the-internet.herokuapp.com/";
    WebDriver driver;

    @BeforeMethod
    private void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        WebElement typos = driver.findElement(new By.ByPartialLinkText("Typos"));
        typos.click();
    }

    @Test
    public void typosTest() {
        List<WebElement> paragraphs = driver.findElements(new By.ByTagName("p"));
        String expectedParagraph0 = "This example demonstrates a typo being introduced. It does it randomly on each page load.";
        String expectedParagraph1 = "Sometimes you'll see a typo, other times you won't.";

        Assert.assertEquals(paragraphs.get(0).getText(), expectedParagraph0);
        Assert.assertEquals(paragraphs.get(1).getText(), expectedParagraph1);
    }

    @AfterMethod
    private void tearDown() {
        driver.quit();
    }
}
