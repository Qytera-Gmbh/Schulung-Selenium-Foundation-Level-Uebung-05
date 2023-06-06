import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class FirstTestCase {

    @BeforeAll
    static void setUp(){
        var lxResourcePath = "src/test/resources/chromedriver";
        var operatingSystem = System.getProperty("os.name").toLowerCase();
        var resourcePath = operatingSystem.contains("windows") ? lxResourcePath + ".exe" : lxResourcePath;
        System.setProperty("webdriver.chrome.driver", resourcePath);
    }

    @Test
    @Tag("MyFirstTest")
    public void firstTestCase(){
        System.out.println("FirstTest");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://selenium.webtesting.eu/");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("menu-item-134")))).click();
        Assertions.assertEquals( "TESTSEITE-KONTAKTFORMULAR", driver.findElement(By.xpath("//h1[contains(text(),'Testseite-Kontaktformular')]")).getText());
        List<WebElement> radioButton = driver.findElements(By.name("your-customer-type"));
        for (WebElement e: radioButton) {
            if(e.getAttribute("value").equals("Business")){
                Assertions.assertTrue(e.isSelected());
            }
            if(e.getAttribute("value").equals("Private")){
                Assertions.assertFalse(e.isSelected());
            }
        }
        driver.quit();
    }

    @Test
    @Tag("MySecondTestcase")
    public void secondTestCase(){
        System.out.println("SecondTest");
    }

}
