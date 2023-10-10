package us.selenium_tests.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.selenium_tests.pages.NavigationPage;
import us.selenium_tests.pages.ProductsPage;

import java.time.Duration;


public class NavigationTest extends BaseTest{

    @Test
    public void desktopsDropDownTest(){
        NavigationPage navPage = new NavigationPage(driver);

        navPage.clickNavElement("Desktops");
        navPage.clickDropDownNavElement("PC (0)");

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "PC");

        navPage.clickNavElement("Desktops");
        navPage.clickDropDownNavElement("Mac (1)");
        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Mac");
    }

    @Test
    public void laptopsAndNotebooksTest(){
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clickNavElement("Laptops & Notebooks");
        navigationPage.clickDropDownNavElement("Macs (0)");

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Macs");

        navigationPage.clickNavElement("Laptops & Notebooks");
        navigationPage.clickDropDownNavElement("Windows (0)");

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Windows");

    }
    @Test
    public void clickAllNavListElementsInRowTest(){
        NavigationPage navPage = new NavigationPage(driver);

        navPage.getNavElement("Laptops & Notebooks").click();
        navPage.getNavElement("Components").click();
        navPage.getNavElement("Tablets").click();
        navPage.getNavElement("Software").click();
        navPage.getNavElement("Phones & PDAs").click();
        navPage.getNavElement("Cameras").click();
        navPage.getNavElement("MP3 Players").click();

    }
}
