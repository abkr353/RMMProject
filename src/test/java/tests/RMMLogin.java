package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objectsFactry.RMMDefaultPage;
import utils.driverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static utils.driverFactory.driver;

public class RMMLogin {

    private RMMDefaultPage RMMElements = new RMMDefaultPage(driverFactory.getDriver());
    @Given("^i have launched the browser and validate RMM default page$")
    public void iHaveLaunchedTheBrowserAndValidateRMMDefaultPage() throws IOException {
        driverFactory.getDriver();
        RMMElements.RMMDefaultPageValidation();
    }

    @When("^i capture username and the password$")
    public void iCaptureUsernameAndThePassword() throws IOException {
        RMMElements.Username();
        RMMElements.Password();
    }

    @And("^i click on login button$")
    public void iClickOnLoginButton() throws IOException {
        RMMElements.LoginButton();
    }

    @Then("^i validate if the user able to login$")
    public void iValidateIfTheUserAbleToLogin() throws IOException {
        RMMElements.Administrator();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        RMMElements.SiteConfig();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        RMMElements.Site();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        RMMElements.AddNewSite();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        RMMElements.SiteCode();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        RMMElements.SiteType();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        RMMElements.SelectSiteType();
    }
}
