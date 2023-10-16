package pl.selenium_store_tests.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.selenium_store_tests.pages.NavigationPage;
import pl.selenium_store_tests.pages.ProductsPage;
import pl.selenium_store_tests.utils.ExcelReader;
import pl.selenium_store_tests.utils.SeleniumHelper;

import java.io.IOException;

public class SearchTest extends BaseTest {


    @Test
    public void searchResultsFoundTest() throws IOException {
        ExtentTest test = extentReports.createTest("Search test with results");
        NavigationPage navigationPage = new NavigationPage(driver);

        String searchPhrase = "Mac";

        navigationPage.setSearchInput(searchPhrase);
        test.log(Status.PASS, "Setting search input done", SeleniumHelper.getScreenshot(driver));
        navigationPage.clickSearchButton();
        test.log(Status.PASS, "Clicking search button done", SeleniumHelper.getScreenshot(driver));
        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.getNumberOfProductBoxes();
        Assert.assertTrue(productsPage.checkIfAnyProductBoxesExist());
        Assert.assertTrue(productsPage.getSearchResultHeading().contains(searchPhrase));
        test.log(Status.PASS, "Assertion passed", SeleniumHelper.getScreenshot(driver));

    }

    @Test
    public void searchResultsNotFoundTest() throws IOException {
        ExtentTest test = extentReports.createTest("Search test with results");
        NavigationPage navigationPage = new NavigationPage(driver);

        String searchPhrase = "test";

        navigationPage.setSearchInput(searchPhrase);
        test.log(Status.PASS, "Setting search input done", SeleniumHelper.getScreenshot(driver));
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertFalse(productsPage.checkIfAnyProductBoxesExist());
        test.log(Status.PASS, "Assertion passed", SeleniumHelper.getScreenshot(driver));

    }

    @DataProvider
    public Object[][] data() throws IOException {
        return ExcelReader.readExcel("testData.xlsx");
    }
}
