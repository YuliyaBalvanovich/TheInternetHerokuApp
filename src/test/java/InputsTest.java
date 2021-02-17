import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputsTest {
    public static final String BASE_URL = "http://the-internet.herokuapp.com/";
    WebDriver driver;

    @BeforeMethod
    private void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        WebElement inputsUrl = driver.findElement(new By.ByPartialLinkText("Inputs"));
        inputsUrl.click();
    }

    @Test
    public void arrowUpNumberTest() {
        WebElement input = driver.findElement(new By.ByTagName("input"));
        input.sendKeys("5");
        input.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(input.getAttribute("value"), "6");
    }

    @Test
    public void arrowDownNumberTest() {
        WebElement input = driver.findElement(new By.ByTagName("input"));
        input.sendKeys("5");
        input.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(input.getAttribute("value"), "4");
    }

    @Test
    public void lettersTest() {
        WebElement input = driver.findElement(new By.ByTagName("input"));
        input.sendKeys("cat");
        Assert.assertEquals(input.getAttribute("value"), "");
    }

    @AfterMethod
    private void tearDown() {
        driver.quit();
    }
}

