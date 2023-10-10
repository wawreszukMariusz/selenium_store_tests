package us.selenium_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {

    @FindBy(tagName = "h2")
    private WebElement productCategoryHeading;

    @FindBy(xpath = "//div[@class='product-thumb']")
    private List<WebElement> productBoxesList;

    @FindBy(className = "pull-right")
    private WebElement continueButton;




    public ProductsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getProductCategoryHeadingText(){
        return productCategoryHeading.getText();
    }

    public int getNumberOfProductBoxes(){
        return productBoxesList.size();
    }

    public boolean checkVisibilityOfContinueButton(){
        if(getNumberOfProductBoxes() == 0){
            return continueButton.isDisplayed();
        }
            return true;
    }

    public void clickContinueButton(){
        continueButton.click();
    }
}

