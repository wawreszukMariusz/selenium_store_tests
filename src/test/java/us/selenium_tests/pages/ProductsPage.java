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

    @FindBy(xpath = "//p[@class='price']")
    private List<WebElement> productBoxesPricesList;

    @FindBy(xpath = "//span[@class='price-tax']")
    private List<WebElement> productBoxesTaxPricesList;

    @FindBy(className = "pull-right")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@id='content']//h1")
    private WebElement searchResultHeading;

    @FindBy(xpath = "//div/p[text()='Your shopping cart is empty!']")
    private WebElement searchNoResultHeading;

    public ProductsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getProductCategoryHeadingText(){
        return productCategoryHeading.getText();
    }

    public int getNumberOfProductBoxes(){
        return productBoxesList.size();
    }

    public boolean checkIfAnyProductBoxesExist() {
        if(productBoxesList.size()>0){
            return true;
        }
        return false;
    }

    public boolean checkVisibilityOfContinueButton(){
        if(getNumberOfProductBoxes() == 0){
            return continueButton.isDisplayed();
        }
        return true;
    }

    public boolean checkProductBoxesPriceCurrency(String currency){
        for(int i=0; i<productBoxesPricesList.size(); i++){
            if(!productBoxesPricesList.get(i).getText().contains(currency)){
                return false;
            }
        }
        return true;
    }

    public boolean checkProductBoxesTaxPricesCurrency(String currency){
        for(int i=0; i<productBoxesTaxPricesList.size(); i++){
            if(!productBoxesTaxPricesList.get(i).getText().contains(currency)){
                return false;
            }
        }
        return true;
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public String getSearchResultHeading(){
        return searchResultHeading.getText();
    }

    public String getSearchNoResultHeading(){
        return searchNoResultHeading.getText();
    }
}

