package pl.selenium_store_tests.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.selenium_store_tests.pages.NavigationPage;
import pl.selenium_store_tests.pages.ProductsPage;
import pl.selenium_store_tests.utils.SeleniumHelper;

import java.io.IOException;


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
    public void componentsTest() throws InterruptedException, IOException {
        ExtentTest test = extentReports.createTest("Navigation Components test");

        NavigationPage navigationPage = new NavigationPage(driver);

        navigationPage.clickNavElement("Components");
        test.log(Status.PASS, "Clicking components  done", SeleniumHelper.getScreenshot(driver));
        navigationPage.clickDropDownNavElement("Mice and Trackballs (0)");
        test.log(Status.PASS, "Clicking Mice and Trackballs done", SeleniumHelper.getScreenshot(driver));
        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Mice and Trackballs");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
        test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));

        navigationPage.clickNavElement("Components");
        test.log(Status.PASS, "Clicking components done", SeleniumHelper.getScreenshot(driver));
        navigationPage.getDropDownNavElement("Monitors (2)").click();
        test.log(Status.PASS, "Clicking Monitors done", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Monitors");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
        test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));

        navigationPage.clickNavElement("Components");
        test.log(Status.PASS, "Clicking Components done", SeleniumHelper.getScreenshot(driver));
        navigationPage.clickDropDownNavElement("Printers (0)");
        test.log(Status.PASS, "Clicking Printers done", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Printers");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
        test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));

        navigationPage.clickNavElement("Components");
        test.log(Status.PASS, "Clicking Components done", SeleniumHelper.getScreenshot(driver));
        navigationPage.clickDropDownNavElement("Scanners (0)");
        test.log(Status.PASS, "Clicking Scanners done", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Scanners");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
        test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));


        navigationPage.clickNavElement("Components");
        test.log(Status.PASS, "Clicking Components done", SeleniumHelper.getScreenshot(driver));
        navigationPage.clickDropDownNavElement("Web Cameras (0)");
        test.log(Status.PASS, "Clicking WebCameras done", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Web Cameras");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
        test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));

        navigationPage.clickNavElement("Components");
        test.log(Status.PASS, "Clicking Components done", SeleniumHelper.getScreenshot(driver));
        navigationPage.clickDropDownNavElement("Show All Components");
        test.log(Status.PASS, "Clicking Show All Components done", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Components");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
        test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
    }

    @Test
    public void tabletsTest() throws IOException {
        ExtentTest test = extentReports.createTest("Navigation tablets test");
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clickNavElement("Tablets");
        test.log(Status.PASS, "Clicking Tablets done", SeleniumHelper.getScreenshot(driver));

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Tablets");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
        test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
    }

    @Test
    public void softwareTest() throws IOException {
        ExtentTest test = extentReports.createTest("Navigation software test");
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clickNavElement("Software");
        test.log(Status.PASS, "Clicking Software done", SeleniumHelper.getScreenshot(driver));
        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Software");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
        test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
    }

    @Test
    public void phonesAndPdasTest() throws IOException {
        ExtentTest test = extentReports.createTest("Navigation phones nad pdas test");
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clickNavElement("Phones & PDAs");
        test.log(Status.PASS, "Clicking Phones & PDAs done", SeleniumHelper.getScreenshot(driver));

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Phones & PDAs");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
        test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
    }

    @Test
    public void camerasTest() throws IOException {
        ExtentTest test = extentReports.createTest("Navigation cameras test");
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clickNavElement("Cameras");
        test.log(Status.PASS, "Clicking cameras done", SeleniumHelper.getScreenshot(driver));

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "Cameras");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
        test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
    }

    @Test
    public void mpPlayersTest() throws IOException {
        ExtentTest test = extentReports.createTest("Navigation MP Players test");
        NavigationPage navigationPage = new NavigationPage(driver);

        navigationPage.checkMp3PlayersDropDownElements(driver);

        navigationPage.clickNavElement("MP3 Players");
        navigationPage.clickDropDownNavElement("Show All MP3 Players");
        test.log(Status.PASS, "Clicking Show All MP3 Players done", SeleniumHelper.getScreenshot(driver));

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getProductCategoryHeadingText(), "MP3 Players");
        Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
        test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
    }

}
