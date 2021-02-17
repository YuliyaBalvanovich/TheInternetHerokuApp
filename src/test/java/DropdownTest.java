import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTest {

    public static final String BASE_URL = "http://the-internet.herokuapp.com/";
    WebDriver driver;

    @BeforeMethod
    private void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        WebElement dropdown = driver.findElement(new By.ByPartialLinkText("Dropdown"));
        dropdown.click();
    }

    @Test
    public void dropdownTest() {

        WebElement selectElement = driver.findElement(By.id("dropdown"));
        Select select = new Select(selectElement);
        List<WebElement> allOptions = select.getOptions();

        Assert.assertEquals(allOptions.get(0).getText(), "Please select an option");
        Assert.assertEquals(allOptions.get(1).getText(), "Option 1");
        Assert.assertEquals(allOptions.get(2).getText(), "Option 2");
    }

    @Test
    public void checkingOptionsSelection() {
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByIndex(1);
        List<WebElement> allOptions = dropdown.getOptions();
        boolean isFirstOptionsSelection = allOptions.get(1).isSelected();
        Assert.assertTrue(isFirstOptionsSelection);

        dropdown.selectByIndex(2);
        boolean isSecondOptionsSelection = allOptions.get(2).isSelected();
        Assert.assertTrue(isSecondOptionsSelection);

    }

    @AfterMethod
    private void tearDown() {
        driver.quit();
    }
}

