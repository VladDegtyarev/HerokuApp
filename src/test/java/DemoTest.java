import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoTest {
    @Test
    public void seleniumTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();

        driver.get("https://the-internet.herokuapp.com/");
        driver.quit();
    }
}
