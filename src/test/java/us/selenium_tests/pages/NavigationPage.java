package us.selenium_tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class NavigationPage {

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

    @FindBy(xpath = "//div[@class='collapse navbar-collapse navbar-ex1-collapse']//a")
    private List<WebElement> navDropDownElementsList;

    @FindBy(xpath = "//i[@class='fa fa-phone']/..")
    private WebElement contactLink;

    @FindBy(xpath = "//i[@class='fa fa-user']/..")
    private WebElement myAccountDropDown;

    @FindBy(xpath = "//a[text()='Register']")
    private WebElement myAccountDropDownRegister;

    @FindBy(xpath = "//a[text()='Login']")
    private WebElement myAccountDropDownLogin;

    @FindBy(id = "wishlist-total")
    private WebElement wishlistLink;

    @FindBy(css = "title = 'Shopping Cart'")
    private WebElement shoppingCartLink;

    @FindBy(css = "title = 'Checkout'")
    private WebElement checkoutLink;

    @FindBy(xpath = "//div[@class='btn-group']/button")
    private WebElement currencyButton;

    @FindBy(name = "EUR")
    private WebElement currencyEurButton;

    @FindBy(name = "GBP")
    private WebElement currencyGbpButton;

    @FindBy(name = "USD")
    private WebElement currencyUsdButton;

    @FindBy(xpath = "//a[text()='MP3 Players']/..//li/a")
    private List<WebElement> mp3PlayersElements;

    public NavigationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

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

    public String getShoppingCartButtonText(){ return shoppingCartButton.getText(); }

    public int getNumberOfNavElements(){
        return navElementsList.size();
    }

    public int getNumberOfDropDownNavElements(){
        return navDropDownElementsList.size();
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
        for(int i = 0; i<getNumberOfDropDownNavElements(); i++){
            if(dropDownNavElement.equals(navDropDownElementsList.get(i).getText())){
                return navDropDownElementsList.get(i);
            }
        }
        return null;
    }

    public void clickNavElement(String navElement){
        getNavElement(navElement).click();
    }

    public void clickDropDownNavElement(String dropDownNavElement){
        getDropDownNavElement(dropDownNavElement).click();
    }

    public void checkMp3PlayersDropDownElements(WebDriver driver){
        ProductsPage productsPage = new ProductsPage(driver);
        for(int i=0; i<mp3PlayersElements.size(); i++){
            clickNavElement("MP3 Players");
            mp3PlayersElements.get(i).click();
            //Assert.assertEquals(productsPage.getProductCategoryHeadingText(), (mp3PlayersElements.get(i).getText()));
            Assert.assertTrue(productsPage.checkVisibilityOfContinueButton());
        }
    }

    public void clickContactLink(){
        contactLink.click();
    }

    public void clickMyAccountDropDown(){
        myAccountDropDown.click();
    }

    public void clickMyAccountDropDownRegister(){
        myAccountDropDownRegister.click();
    }

    public void clickMyAccountDropDownLogin(){
        myAccountDropDownLogin.click();
    }

    public void clickWishListLink(){
        wishlistLink.click();
    }

    public void clickShoppingCartLink(){
        shoppingCartLink.click();
    }

    public void clickCheckoutLink(){
        checkoutLink.click();
    }

    public void clickCurrencyButton(){
        currencyButton.click();
    }

    public void clickCurrencyEurButton(){
        currencyEurButton.click();
    }

    public void clickCurrencyGbpButton(){
        currencyGbpButton.click();
    }

    public void clickCurrencyUsdButton(){
        currencyUsdButton.click();
    }
}
