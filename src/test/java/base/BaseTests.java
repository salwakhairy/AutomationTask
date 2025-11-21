package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {
    protected WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
    }
    public void switchToNewTab() {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }

    @AfterClass
    public void tearDown() {
        // Close browser after all tests
        if (driver != null) {
            driver.quit();
        }
    }

   /* protected WebDriver getDriver() {
        return driver.get();
    }*/
}
