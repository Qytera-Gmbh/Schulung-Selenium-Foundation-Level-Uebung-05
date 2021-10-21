import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstTestCase {

    @BeforeAll
    static void setUp(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
    }

    @Test
    @Tag("MyFirstTest")
    public void firstTestCase(){
        System.out.println("FirstTest");
        WebDriver driver = new ChromeDriver();
        driver.get("http://selenium.webtesting.eu/");
        driver.manage().window().maximize();
        driver.findElement(By.id("menu-item-134")).click();
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
