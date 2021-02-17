import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HoversTest {
    public static final String BASE_URL = "http://the-internet.herokuapp.com/";
    WebDriver driver;

    @BeforeMethod
    private void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        WebElement hovers = driver.findElement(new By.ByPartialLinkText("Hovers"));
        hovers.click();
    }

    @Test
    public void hoversTest1() {
        Actions action = new Actions(driver);
        List<WebElement> img1 = driver.findElements(new By.ByXPath("//div[@class='figure']"));
        action.moveToElement(img1.get(0)).perform();

        List<WebElement> userNames1 = driver.findElements(new By.ByXPath("//div[@class='figcaption']/h5"));
        Assert.assertEquals(userNames1.get(0).getText(), "name: user1");

        List<WebElement> userLinks1 = driver.findElements(new By.ByXPath("//div[@class='figcaption']/a"));
        userLinks1.get(0).click();

        WebElement error1 = driver.findElement(new By.ByXPath("//h1"));
        Assert.assertEquals(error1.getText(), "Not Found");
    }

    @Test
    public void hoversTest2() {
        Actions action = new Actions(driver);
        List<WebElement> img2 = driver.findElements(new By.ByXPath("//div[@class='figure']"));
        action.moveToElement(img2.get(1)).perform();

        List<WebElement> userNames2 = driver.findElements(new By.ByXPath("//div[@class='figcaption']/h5"));
        Assert.assertEquals(userNames2.get(1).getText(), "name: user2");

        List<WebElement> userLinks2 = driver.findElements(new By.ByXPath("//div[@class='figcaption']/a"));
        userLinks2.get(1).click();

        WebElement error2 = driver.findElement(new By.ByXPath("//h1"));
        Assert.assertEquals(error2.getText(), "Not Found");
    }

    @Test
    public void hoversTest3() {
        Actions action = new Actions(driver);
        List<WebElement> img3 = driver.findElements(new By.ByXPath("//div[@class='figure']"));
        action.moveToElement(img3.get(2)).perform();

        List<WebElement> userNames3 = driver.findElements(new By.ByXPath("//div[@class='figcaption']/h5"));
        Assert.assertEquals(userNames3.get(2).getText(), "name: user3");

        List<WebElement> userLinks3 = driver.findElements(new By.ByXPath("//div[@class='figcaption']/a"));
        userLinks3.get(2).click();

        WebElement error3 = driver.findElement(new By.ByXPath("//h1"));
        Assert.assertEquals(error3.getText(), "Not Found");
    }

    @AfterMethod
    private void tearDown() {
        driver.quit();
    }
}

