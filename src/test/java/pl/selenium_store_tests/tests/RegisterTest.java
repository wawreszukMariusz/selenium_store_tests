package pl.selenium_store_tests.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.devtools.v114.fedcm.model.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.selenium_store_tests.pages.AccountPage;
import pl.selenium_store_tests.pages.NavigationPage;
import pl.selenium_store_tests.pages.RegisterPage;
import pl.selenium_store_tests.utils.SeleniumHelper;

import java.io.IOException;

public class RegisterTest extends BaseTest {

    @Test
    public void fillRegisterFormWithProperValuesTest() throws IOException {
        ExtentTest test = extentReports.createTest("Registry test with proper values");
        NavigationPage navigationPage = new NavigationPage(driver);


        navigationPage.clickMyAccountDropDown();
        test.log(Status.PASS, "Clicking dropdown done", SeleniumHelper.getScreenshot(driver));
        navigationPage.clickMyAccountDropDownRegister();
        test.log(Status.PASS, "Clicking registry option done", SeleniumHelper.getScreenshot(driver));

        RegisterPage registerPage = new RegisterPage(driver);



        String password = "Pass123@";
        registerPage.setFirstNameInput("Mariusz");
        test.log(Status.PASS, "Setting first name done", SeleniumHelper.getScreenshot(driver));
        registerPage.setLastNameInput("Testowy");
        test.log(Status.PASS, "Setting last name done", SeleniumHelper.getScreenshot(driver));
        registerPage.setEmailInput(registerPage.generateRandomEmail());
        test.log(Status.PASS, "Setting email done", SeleniumHelper.getScreenshot(driver));
        registerPage.setPhoneNumberInput("123123123");
        test.log(Status.PASS, "Setting phone number done", SeleniumHelper.getScreenshot(driver));
        registerPage.setPasswordInput(password);
        test.log(Status.PASS, "Setting password done", SeleniumHelper.getScreenshot(driver));
        registerPage.setConfirmPasswordInput(password);
        test.log(Status.PASS, "Setting confirmation password done", SeleniumHelper.getScreenshot(driver));
        registerPage.clickNewsletterYesOption();
        test.log(Status.PASS, "Accepting newsletter option done", SeleniumHelper.getScreenshot(driver));
        registerPage.clickPrivacyPolicyCheckbox();
        test.log(Status.PASS, "Accepting privacy policy done", SeleniumHelper.getScreenshot(driver));
        registerPage.clickSubmitButton();
        test.log(Status.PASS, "Clicking submit button done", SeleniumHelper.getScreenshot(driver));

        AccountPage accountPage = new AccountPage(driver);

        Assert.assertTrue(accountPage.checkPageHeading());
        test.log(Status.PASS, "Assertion passed", SeleniumHelper.getScreenshot(driver));
    }

    @Test
    public void sendEmptyRegisterForm() throws IOException {
        ExtentTest test = extentReports.createTest("Registry test with empty form");
        NavigationPage navigationPage = new NavigationPage(driver);

        navigationPage.clickMyAccountDropDown();
        test.log(Status.PASS, "Clicking dropdown done", SeleniumHelper.getScreenshot(driver));
        navigationPage.clickMyAccountDropDownRegister();
        test.log(Status.PASS, "Clicking registry option done", SeleniumHelper.getScreenshot(driver));

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickSubmitButton();
        test.log(Status.PASS, "Clicking submit button done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(registerPage.checkAlertDisplay("First Name must be between 1 and 32 characters!"));
        Assert.assertTrue(registerPage.checkAlertDisplay("Last Name must be between 1 and 32 characters!"));
        Assert.assertTrue(registerPage.checkAlertDisplay("E-Mail Address does not appear to be valid!"));
        Assert.assertTrue(registerPage.checkAlertDisplay("Telephone must be between 3 and 32 characters!"));
        Assert.assertTrue(registerPage.checkAlertDisplay("Password must be between 4 and 20 characters!"));
        test.log(Status.PASS, "Assertion passed", SeleniumHelper.getScreenshot(driver));
    }
}
