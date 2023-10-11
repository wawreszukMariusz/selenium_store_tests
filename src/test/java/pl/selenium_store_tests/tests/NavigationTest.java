package pl.selenium_store_tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.selenium_store_tests.pages.NavigationPage;
import pl.selenium_store_tests.pages.ProductsPage;


public class NavigationTest extends BaseTest{

    @Test
    public void desktopsDropDownTest(){
        NavigationPage navPage = new NavigationPage(driver);

        navPage.clickNavElement("Desktops");
        navPage.clickDropDownNavElement("PC (0)");
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "PC");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
        System.out.println(productsPage.getNumberOfProductBoxes());

        navPage.clickNavElement("Desktops");
        navPage.clickDropDownNavElement("Mac (1)");
        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Mac");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
        System.out.println(productsPage.getNumberOfProductBoxes());
    }

    @Test
    public void laptopsAndNotebooksTest(){


        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clickNavElement("Laptops & Notebooks");
        navigationPage.clickDropDownNavElement("Macs (0)");

        ProductsPage productsPage = new ProductsPage(driver);
        System.out.println(productsPage.getNumberOfProductBoxes());

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Macs");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());

        navigationPage.clickNavElement("Laptops & Notebooks");
        navigationPage.clickDropDownNavElement("Windows (0)");
        System.out.println(productsPage.getNumberOfProductBoxes());

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Windows");

    }

    @Test
    public void componentsTest() throws InterruptedException {
        NavigationPage navigationPage = new NavigationPage(driver);

        navigationPage.clickNavElement("Components");
        navigationPage.clickDropDownNavElement("Mice and Trackballs (0)");

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Mice and Trackballs");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());

        navigationPage.clickNavElement("Components");
        navigationPage.getDropDownNavElement("Monitors (2)").click();

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Monitors");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());

        navigationPage.clickNavElement("Components");
        navigationPage.clickDropDownNavElement("Printers (0)");

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Printers");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());

        navigationPage.clickNavElement("Components");
        navigationPage.clickDropDownNavElement("Scanners (0)");

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Scanners");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());

        navigationPage.clickNavElement("Components");
        navigationPage.clickDropDownNavElement("Web Cameras (0)");

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Web Cameras");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());

        navigationPage.clickNavElement("Components");
        navigationPage.clickDropDownNavElement("Show All Components");

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Components");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
    }

    @Test
    public void tabletsTest(){
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clickNavElement("Tablets");

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Tablets");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
    }

    @Test
    public void softwareTest(){
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clickNavElement("Software");

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Software");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
    }

    @Test
    public void phonesAndPdasTest(){
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clickNavElement("Phones & PDAs");

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Phones & PDAs");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
    }

    @Test
    public void camerasTest(){
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clickNavElement("Cameras");

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Cameras");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
    }

    @Test
    public void mpPlayersTest(){
        NavigationPage navigationPage = new NavigationPage(driver);

        navigationPage.checkMp3PlayersDropDownElements(driver);

        navigationPage.clickNavElement("MP3 Players");
        navigationPage.clickDropDownNavElement("Show All MP3 Players");

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "MP3 Players");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
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
