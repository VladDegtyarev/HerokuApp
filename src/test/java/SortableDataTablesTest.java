import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SortableDataTablesTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkCheckboxesTest() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://the-internet.herokuapp.com/tables");
        String nameSmith = driver.findElement(By.xpath("//table//tr[1]//td[1]")).getText();
        String emailFrank = driver.findElement(By.xpath("//table//tr[2]//td[3]")).getText();
        String webDoe = driver.findElement(By.xpath("//table//tr[3]//td[5]")).getText();
        softAssert.assertEquals(nameSmith, "Smith");
        softAssert.assertEquals(emailFrank, "fbach@yahoo.com");
        softAssert.assertEquals(webDoe, "http://www.jdoe.com");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
