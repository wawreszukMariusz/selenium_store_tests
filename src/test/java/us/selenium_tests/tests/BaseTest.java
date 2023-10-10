package us.selenium_tests.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void setUpTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");
    }

}
