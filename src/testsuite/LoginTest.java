package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    public void sendTextToElement(By by ,String text){
        driver.findElement(by).sendKeys(text);
    }
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    public void productDisplay(By by){
        driver.findElement(by).isDisplayed();

    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter username in username field
        sendTextToElement(By.id("user-name"), "standard_user");
        //enter password in password field
        sendTextToElement(By.id("password"),"secret_sauce");
        //click on login button
        clickOnElement(By.id("login-button"));
        //verify the text 'products'
        String expectedText = "Products";
        String actualText = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
        Assert.assertEquals("Text is Display", expectedText, actualText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter username in username field
        sendTextToElement(By.id("user-name"), "standard_user");
        //enter password in password field
        sendTextToElement(By.id("password"),"secret_sauce");
        //click on login button
        clickOnElement(By.id("login-button"));
        //verify that six product are displayed on page
        List<WebElement> productDisplay = driver.findElements(By.className("inventory_item_description"));
        System.out.println("Total product are display: " + productDisplay.size());
    }
    @After
    public void tearDown(){
        //closeBrowser();
    }

}
