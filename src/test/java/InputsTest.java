import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class InputsTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkCheckboxesTest() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement value = driver.findElement(By.cssSelector("input"));
        value.sendKeys("10");
        value.sendKeys(Keys.ARROW_UP);
        softAssert.assertEquals(value.getAttribute("value"), "11");
        value.clear();
        value.sendKeys("qwerty");
        value.sendKeys(Keys.ARROW_DOWN);
        softAssert.assertEquals(value.getAttribute("value"), "-1");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
