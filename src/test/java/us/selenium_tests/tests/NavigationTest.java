package us.selenium_tests.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import us.selenium_tests.pages.NavigationPage;
import java.time.Duration;


public class NavigationTest extends BaseTest{
    @Test
    public void testSelectorsTest() {

        NavigationPage navigationPage = new NavigationPage(driver);

        
        //driver.findElement(By.xpath("//a[@href='http://opencart.abstracta.us:80/index.php?route=common/home']")).click();
    }
}
