import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CheckboxesTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkCheckboxesTest() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkBox = driver.findElements(By.cssSelector("[type=checkbox]"));
        boolean unChecked = !checkBox.get(0).isSelected();
        Assert.assertTrue(unChecked);
        checkBox.get(0).click();
        boolean isChecked = checkBox.get(0).isSelected();
        Assert.assertTrue(isChecked);
        boolean isCheckedSecond = checkBox.get(1).isSelected();
        Assert.assertTrue(isCheckedSecond);
        checkBox.get(1).click();
        boolean unCheckedSecond = !checkBox.get(1).isSelected();
        Assert.assertTrue(unCheckedSecond);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
