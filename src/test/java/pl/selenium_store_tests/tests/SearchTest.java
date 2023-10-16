package pl.selenium_store_tests.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.selenium_store_tests.pages.NavigationPage;
import pl.selenium_store_tests.pages.ProductsPage;
import pl.selenium_store_tests.utils.ExcelReader;

import java.io.IOException;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "data")
    public void searchResultsFoundTest(String firstName, String lastName, String email, String telephone){
        NavigationPage navigationPage = new NavigationPage(driver);

        String searchPhrase = firstName;

        navigationPage.setSearchInput(searchPhrase);
        navigationPage.clickSearchButton();

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.getNumberOfProductBoxes();
        Assert.assertTrue(productsPage.checkIfAnyProductBoxesExist());
        Assert.assertTrue(productsPage.getSearchResultHeading().contains(searchPhrase));

    }

    @Test
    public void searchResultsNotFoundTest(){
        NavigationPage navigationPage = new NavigationPage(driver);

        String searchPhrase = "test";

        navigationPage.setSearchInput(searchPhrase);

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertFalse(productsPage.checkIfAnyProductBoxesExist());

    }

    @DataProvider
    public Object[][] data() throws IOException {
        return ExcelReader.readExcel("testData.xlsx");
    }
}
