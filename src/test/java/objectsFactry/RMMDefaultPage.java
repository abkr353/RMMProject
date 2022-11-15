package objectsFactry;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class RMMDefaultPage {
    private WebDriver driver;

    //RMM default page elements
    @FindBy(how = How.XPATH, using = "/html/body/app-root/app-login/div/form/div/div/div[4]/input")
    private WebElement Username;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/app-login/div/form/div/div/div[7]/input")
    private WebElement Password;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/app-login/div/form/div/div/div[10]/p-button/button/div")
    private WebElement LoginButton;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/app-login/div/form/div/div/div[1]/div")
    private WebElement RMMDefaultPage;

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Administration') and @class='card-title']")
    private WebElement Administrator;
    public void Administrator() throws IOException {
        Administrator.click();
    }

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Sites configuration') and @class='card-title']")
    private WebElement SiteConfig;
    public void SiteConfig() throws IOException {
        SiteConfig.click();
    }

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Sites') and @class='card-title']")
    private WebElement Site;
    public void Site() throws IOException {
        Site.click();

    }

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Add a new site ') and @class]")
    private WebElement AddNewSite;
    public void AddNewSite() throws IOException {
        AddNewSite.click();
    }

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Key site code')  and @type='text']")
    private WebElement SiteCode;
    public void SiteCode() throws IOException {
        SiteCode.sendKeys("1960");
    }

    @FindBy(how = How.XPATH, using = "//p-dropdown[contains(@placeholder,'Select')]//ancestor::div[./div[contains(text(),'Site type')]]//p-dropdown")
    private WebElement SiteType;
    public void SiteType() throws IOException {
        SiteType.click();
    }

    //this will select from the dropdown list
    @FindBy(how = How.XPATH, using = "(//li[contains(@aria-label,'Standard')])[1]")
    private WebElement SelectSiteType;
    public void SelectSiteType() throws IOException {
        SelectSiteType.click();
    }





    /*
    constructor
     */
    public RMMDefaultPage(WebDriver driver) {
        this.driver=driver;
        //initialise elements
        PageFactory.initElements(driver,this);
    }

    public void RMMDefaultPageValidation() throws IOException {
        String rmmDefault = RMMDefaultPage.getText();
        Assert.assertEquals("Welcome to Resource\n" +
                "Management Model",rmmDefault);
    }




    /*
    action required based on the elements
     */
    public void Username() throws IOException {
        Username.sendKeys("ab022oo-a");
    }

    public void Password() throws IOException {
        Password.sendKeys("General12345");
    }

    public void LoginButton() throws IOException {
        LoginButton.click();
    }

}
