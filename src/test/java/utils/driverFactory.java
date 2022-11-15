package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class driverFactory {
    public static WebDriver driver = null;

    public driverFactory(){

    }

    public static WebDriver getDriver() {

        String url = "https://resource-management-sit.absa.co.za/";
        System.setProperty("webdriver.chrome.driver", "common_driver" + File.separator + "chromedriver.exe");

        if (driver == null) {
            driver = new ChromeDriver();
        }

        driver.get(url); // open the metadata hub system URL
        driver.manage().window().maximize(); //maximise the browser
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //waiting for the page to load

        return driver;
    }

}
