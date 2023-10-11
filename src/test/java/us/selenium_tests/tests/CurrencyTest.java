package us.selenium_tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.selenium_tests.pages.NavigationPage;
import us.selenium_tests.pages.ProductsPage;

public class CurrencyTest extends BaseTest {

    @Test
    public void euroCurrencyTest(){
        NavigationPage navigationPage = new NavigationPage(driver);

        navigationPage.clickCurrencyButton();
        navigationPage.clickCurrencyEurButton();

        String currency = "€";

        Assert.assertTrue(navigationPage.getShoppingCartButtonText().contains(currency));

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.checkProductBoxesPriceCurrency(currency));
        Assert.assertTrue(productsPage.checkProductBoxesTaxPricesCurrency(currency));

        navigationPage.clickNavElement("Tablets");
        Assert.assertTrue(productsPage.checkProductBoxesPriceCurrency(currency));
        Assert.assertTrue(productsPage.checkProductBoxesTaxPricesCurrency(currency));
    }
    @Test
    public void gbpCurrencyTest(){
        NavigationPage navigationPage = new NavigationPage(driver);

        navigationPage.clickCurrencyButton();
        navigationPage.clickCurrencyGbpButton();

        String currency = "£";

        Assert.assertTrue(navigationPage.getShoppingCartButtonText().contains(currency));

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.checkProductBoxesPriceCurrency(currency));
        Assert.assertTrue(productsPage.checkProductBoxesTaxPricesCurrency(currency));

        navigationPage.clickNavElement("Tablets");
        Assert.assertTrue(productsPage.checkProductBoxesPriceCurrency(currency));
        Assert.assertTrue(productsPage.checkProductBoxesTaxPricesCurrency(currency));
    }
    @Test
    public void usdCurrencyTest(){
        NavigationPage navigationPage = new NavigationPage(driver);

        navigationPage.clickCurrencyButton();
        navigationPage.clickCurrencyUsdButton();

        String currency = "$";

        Assert.assertTrue(navigationPage.getShoppingCartButtonText().contains(currency));

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.checkProductBoxesPriceCurrency(currency));
        Assert.assertTrue(productsPage.checkProductBoxesTaxPricesCurrency(currency));

        navigationPage.clickNavElement("Tablets");
        Assert.assertTrue(productsPage.checkProductBoxesPriceCurrency(currency));
        Assert.assertTrue(productsPage.checkProductBoxesTaxPricesCurrency(currency));
    }
}
