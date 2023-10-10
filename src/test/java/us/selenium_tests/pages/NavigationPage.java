package us.selenium_tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NavigationPage {
    WebDriver driver;
    public NavigationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='http://opencart.abstracta.us:80/index.php?route=common/home']")
    private WebElement homePageLink;

    @FindBy(name = "search")
    private WebElement searchInput;

    @FindBy(xpath = "//span[@class='input-group-btn']//button")
    private WebElement searchButton;

    @FindBy(id = "cart-total")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li")
    private List<WebElement> navElementsList;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a")
    private List<WebElement> navDropDownElementsList;

    public void clickHomePageLink(){
        homePageLink.click();
    }

    public void setSearchInput(String phrase) {
        searchInput.sendKeys(phrase);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void clickShoppingCartButton(){
        shoppingCartButton.click();
    }

    public int getNumberOfNavElements(){
        return navElementsList.size();
    }

    public WebElement getNavElement(String navElement){
        for(int i = 0; i<getNumberOfNavElements(); i++){
            if(navElement.equals(navElementsList.get(i).getText())){
                return navElementsList.get(i);
            }
        }
        return null;
    }
    public WebElement getDropDownNavElement(String dropDownNavElement){
        for(int i = 0; i<getNumberOfNavElements(); i++){
            if(dropDownNavElement.equals(navDropDownElementsList.get(i).getText())){
                return navElementsList.get(i);
            }
        }
        return null;
    }

}
