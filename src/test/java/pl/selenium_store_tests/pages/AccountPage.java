package pl.selenium_store_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    public AccountPage(WebDriver driver){

        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement pageHeading;

    public boolean checkPageHeading(){
        return pageHeading.isDisplayed();
    }
}
