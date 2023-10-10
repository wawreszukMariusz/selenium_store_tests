package us.selenium_tests.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import us.selenium_tests.pages.NavigationPage;

import java.time.Duration;

public class NavigationTest {
    WebDriver driver;

    @Test
    public void testSelectors(){


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        NavigationPage navigationPage = new NavigationPage(driver);


        navigationPage.clickHomePageLink();
        navigationPage.setSearchInput("witam");
        navigationPage.clickSearchButton();
        navigationPage.clickShoppingCartButton();
        System.out.println(navigationPage.getNumberOfNavElements());

        navigationPage.getNavElement("Desktops").click();
        navigationPage.getDropDownNavElement("PC (0)").click();

        //driver.findElement(By.xpath("//a[@href='http://opencart.abstracta.us:80/index.php?route=common/home']")).click();
    }
}
