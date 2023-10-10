package us.selenium_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    @FindBy(tagName = "h2")
    private WebElement productCategoryHeading;

    public ProductsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getProductCategoryHeadingText(){
        return productCategoryHeading.getText();
    }


}
