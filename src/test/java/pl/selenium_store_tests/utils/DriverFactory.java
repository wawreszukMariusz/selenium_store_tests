package pl.selenium_store_tests.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    public static WebDriver getDriver(String name){
        if(name.equals("firefox")) {
            return new FirefoxDriver();
        }
        else if (name.equals("edge")) {
            return new EdgeDriver();
        }
        else  {
            return new ChromeDriver();
        }
    }

}
