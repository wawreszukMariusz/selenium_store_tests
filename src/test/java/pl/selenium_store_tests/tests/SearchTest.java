package pl.selenium_store_tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.selenium_store_tests.pages.NavigationPage;
import pl.selenium_store_tests.pages.ProductsPage;

public class SearchTest extends BaseTest {

    @Test
    public void searchResultsFoundTest(){
        NavigationPage navigationPage = new NavigationPage(driver);

        String searchPhrase = "Mac";

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
}
