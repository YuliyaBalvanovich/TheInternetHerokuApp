import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddRemoveElementsTest {

    public static final String BASE_URL = "http://the-internet.herokuapp.com/";
    WebDriver driver;

    @BeforeMethod
    private void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        WebElement addRemoveElements = driver.findElement(new By.ByPartialLinkText("Add/Remove Elements"));
        addRemoveElements.click();
    }

    @Test
    public void addRemoveElementsTest() {
        WebElement addElementsButton = driver.findElement(new By.ByXPath("//button[text()='Add Element']"));
        addElementsButton.click();
        addElementsButton.click();
        WebElement removeButton = driver.findElement(new By.ByXPath("//button[text()='Delete']"));
        removeButton.click();
        int count = driver.findElements(By.cssSelector("div#elements")).size();
        Assert.assertEquals(count, 1, "Неверное количество элементов после удаления");
    }

    @AfterMethod
    private void tearDown() {
        driver.quit();
    }
}
