package pl.selenium_store_tests.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.selenium_store_tests.pages.NavigationPage;
import pl.selenium_store_tests.pages.ProductsPage;
import pl.selenium_store_tests.utils.SeleniumHelper;

import java.io.IOException;

public class CurrencyTest extends BaseTest {

    @Test
    public void euroCurrencyTest() throws IOException {
        ExtentTest test = extentReports.createTest("Euro Currency Test");

        NavigationPage navigationPage = new NavigationPage(driver);

        navigationPage.clickCurrencyButton();
        test.log(Status.PASS, "Click currency button done", SeleniumHelper.getScreenshot(driver));
        navigationPage.clickCurrencyEurButton();
        test.log(Status.PASS, "Click currency euro button done", SeleniumHelper.getScreenshot(driver));

        String currency = "€";

        Assert.assertTrue(navigationPage.getShoppingCartButtonText().contains(currency));

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.checkProductBoxesPriceCurrency(currency));
        Assert.assertTrue(productsPage.checkProductBoxesTaxPricesCurrency(currency));
        test.log(Status.PASS, "Asserts passed", SeleniumHelper.getScreenshot(driver));

        navigationPage.clickNavElement("Tablets");
        Assert.assertTrue(productsPage.checkProductBoxesPriceCurrency(currency));
        Assert.assertTrue(productsPage.checkProductBoxesTaxPricesCurrency(currency));
        test.log(Status.PASS, "Asserts passed", SeleniumHelper.getScreenshot(driver));
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
