package utils;

import objectsFactry.RMMDefaultPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;



import java.io.File;
import java.util.Iterator;
import java.util.Set;

public class baseFunctionality {

    private RMMDefaultPage RMMElements = new RMMDefaultPage(driverFactory.getDriver());

    /*RMM
     * Developer: Khangwelo Ravhutsi
     * Date: 8 November 2022
     * Function name: Screenshot
     * Description: This is to take screenshoot
     *
     * Updated By:
     * Date Updated:
     * Description:
     * */

    public static void TakeScreenShots(String TestID){
        String Error;
        try{
            WebDriverWait wait = new WebDriverWait(driverFactory.driver, 10);
            File scrFile = ((TakesScreenshot)driverFactory.driver).getScreenshotAs(OutputType.FILE);
            // copy screenshot to certain location
            FileUtils.copyFile(scrFile, new File("src\\screenshots"+"\\" +TestID+ ".png"));

        }catch(Exception e){
            Error = e.getMessage();
            System.out.println(Error);
        }
    }
    /*---------------------------------------------------------------------------------------------------------------------------------------------------------------
     * */

    public static void WaitUntilVisible(WebElement object, String data){
        try{
            //Log.info("Wait for the object to be visible " + object);
            WebDriverWait wait = new WebDriverWait(driverFactory.driver, 10);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(object));
        }catch(Exception e){
            //Log.error("Not able to Select an item --- " + e.getMessage());
        }
    }
    /*---------------------------------------------------------------------------------------------------------------------------------------------------------------
     * */

    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement webElement, int seconds) {
        WebDriverWait wait = new WebDriverWait(driverFactory.driver, seconds);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        element.click();
        return element;
    }
    /*---------------------------------------------------------------------------------------------------------------------------------------------------------------
     * */

    public static void waitForAnElementToBeVisible(WebDriver driver, WebElement webElement, int seconds) {
        WebDriverWait wait = new WebDriverWait(driverFactory.driver, seconds);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));
        // if (!element) throw new AssertionError();

    }
    /*---------------------------------------------------------------------------------------------------------------------------------------------------------------
     * */

    public static void selectElementByValue(WebElement element, String value) {
        Select selectElement = new Select(element);
        selectElement.selectByValue(value);
    }

    /*---------------------------------------------------------------------------------------------------------------------------------------------------------------
     * */

    public static void selectElementByVisibleText(WebElement element, String text) {
        Select selectElement = new Select(element);
        selectElement.selectByVisibleText(text);
    }
    /*---------------------------------------------------------------------------------------------------------------------------------------------------------------
     * */

    public static String TrimEnd(String string, Character... charsToTrim)
    {
        if (string == null || charsToTrim == null)
            return string;

        int lengthToKeep = string.length();
        for (int index = string.length() - 1; index >= 0; index--)
        {
            boolean removeChar = false;
            if (charsToTrim.length == 0)
            {
                if (Character.isWhitespace(string.charAt(index)))
                {
                    lengthToKeep = index;
                    removeChar = true;
                }
            }
            else
            {
                for (int trimCharIndex = 0; trimCharIndex < charsToTrim.length; trimCharIndex++)
                {
                    if (string.charAt(index) == charsToTrim[trimCharIndex])
                    {
                        lengthToKeep = index;
                        removeChar = true;
                        break;
                    }
                }
            }
            if ( ! removeChar)
                break;
        }
        return string.substring(0, lengthToKeep);
    }
    /*---------------------------------------------------------------------------------------------------------------------------------------------------------------
     * */

    public void CloseChildWIndows()
    {
        String MainWindow = driverFactory.driver.getWindowHandle();
        System.out.println("Main window handle is " + MainWindow);

        // To handle all new opened window
        Set<String> s1 = driverFactory.driver.getWindowHandles();
        System.out.println("Child window handle is" + s1);
        Iterator<String> i1 = s1.iterator();

        // Here we will check if child window has other child windows and when child window
        //is the main window it will come out of loop.
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driverFactory.driver.switchTo().window(ChildWindow);
                driverFactory.driver.close();
                System.out.println("Child window closed");
            }
        }
    }

    /*---------------------------------------------------------------------------------------------------------------------------------------------------------------
     * */
}
