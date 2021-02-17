import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortableDataTablesTest {


    public static final String BASE_URL = "http://the-internet.herokuapp.com/";
    WebDriver driver;

    @BeforeMethod
    private void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        WebElement tables = driver.findElement(new By.ByPartialLinkText("Sortable Data Tables"));
        tables.click();
    }

    @Test
    public void tablesTest() {
        WebElement tableCell1 = driver.findElement(new By.ByXPath("//table//tr[1]//td[1]"));
        Assert.assertEquals(tableCell1.getText(), "Smith");

        WebElement tableCell2 = driver.findElement(new By.ByXPath("//table//tr[2]//td[4]"));
        Assert.assertEquals(tableCell2.getText(), "$51.00");

        WebElement header = driver.findElement(new By.ByXPath("//table//tr[1]//th[4]//span"));
        header.click();

        WebElement tableCell3 = driver.findElement(new By.ByXPath("//table//tr[2]//td[4]"));
        Assert.assertEquals(tableCell3.getText(), "$50.00");

        WebElement tableCell4 = driver.findElement(new By.ByXPath("//table//tr[3]//td[4]"));
        Assert.assertEquals(tableCell4.getText(), "$51.00");
    }

    @AfterMethod
    private void tearDown() {
        driver.quit();
    }
}
