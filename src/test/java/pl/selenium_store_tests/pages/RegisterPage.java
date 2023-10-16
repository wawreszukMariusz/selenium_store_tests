package pl.selenium_store_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class RegisterPage {

    @FindBy(name = "firstname")
    private WebElement firstNameInput;

    @FindBy(name = "lastname")
    private WebElement lastNameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "telephone")
    private WebElement phoneNumberInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "confirm")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//label[@class='radio-inline']/input[@value='1']")
    private WebElement newsletterYesOption;

    @FindBy(xpath = "//label[@class='radio-inline']/input[@value='0']")
    private WebElement newsletterNoOption;

    @FindBy(name = "agree")
    private WebElement privacyPolicyCheckbox;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(className = "text-danger")
    private List<WebElement>  formAlertsList;

    public RegisterPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void setFirstNameInput(String firstName){
        firstNameInput.sendKeys(firstName);
    }

    public void setLastNameInput(String lastName){
        lastNameInput.sendKeys(lastName);
    }

    public void setEmailInput(String email){
        emailInput.sendKeys(email);
    }

    public void setPhoneNumberInput(String phoneNumber){
        phoneNumberInput.sendKeys(phoneNumber);
    }

    public void setPasswordInput(String password){
        passwordInput.sendKeys(password);
    }

    public void setConfirmPasswordInput(String password){
        confirmPasswordInput.sendKeys(password);
    }

    public void clickNewsletterYesOption(){
        newsletterYesOption.click();
    }

    public void clickNewsletterNoOption(){
        newsletterNoOption.click();
    }

    public void clickPrivacyPolicyCheckbox(){
        privacyPolicyCheckbox.click();
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public String generateRandomEmail(){
        int randomNumber = (int) (Math.random()*1000);
        String email = "test" + randomNumber + "@test.com";
        return email;
    }

    public boolean checkAlertDisplay(String alertText){
        for(int i=0; i< formAlertsList.size(); i++){
            if(formAlertsList.get(i).getText().equals(alertText)){
                return true;
            }
        }
        return false;
    }
}
