import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckboxesTest {
    public static final String BASE_URL = "http://the-internet.herokuapp.com/";
    WebDriver driver;
    List<WebElement> checkBoxes;

    @BeforeMethod
    private void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        WebElement checkboxElement = driver.findElement(new By.ByPartialLinkText("Checkboxes"));
        checkboxElement.click();
    }

    @Test
    public void firstCheckboxTest() {
        checkBoxes = driver.findElements(By.cssSelector("[type=checkbox]"));

        boolean isFirstCheckboxChecked = checkBoxes.get(0).isSelected();
        Assert.assertFalse(isFirstCheckboxChecked);

        checkBoxes.get(0).click();
        boolean isFirstCheckboxChecked1 = checkBoxes.get(0).isSelected();
        Assert.assertTrue(isFirstCheckboxChecked1);

    }

    @Test
    public void secondCheckboxTest() {
        checkBoxes = driver.findElements(By.cssSelector("[type=checkbox]"));

        boolean isSecondCheckboxChecked = checkBoxes.get(1).isSelected();
        Assert.assertTrue(isSecondCheckboxChecked);

        checkBoxes.get(1).click();
        boolean isSecondCheckboxChecked1 = checkBoxes.get(1).isSelected();
        Assert.assertFalse(isSecondCheckboxChecked1);
    }

    @AfterMethod
    private void tearDown() {
        driver.quit();
    }
}
