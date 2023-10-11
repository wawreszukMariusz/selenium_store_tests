package us.selenium_tests.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import us.selenium_tests.utils.DriverFactory;

public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void setUpTest(){
        driver = DriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
