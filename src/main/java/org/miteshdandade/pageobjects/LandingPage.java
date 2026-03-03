package org.miteshdandade.pageobjects;

import org.miteshdandade.AbstractComponents.AbstractComponent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class LandingPage extends AbstractComponent {
    WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        //initialization
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    //WebElement userEmails = driver.findElement(By.id("userEmail"));
    //PageFactory

    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement passwordEle;

    @FindBy(id="login")
    WebElement submit;

    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;

    @FindBy(css="div[class*='invalid-feedback'] div")
    List<WebElement> emptyEmailErrorMessage;


    public ProductCatalogue loginApplication(String email,String password)
    {
        userEmail.sendKeys(email);
        passwordEle.sendKeys(password);
        try {
            submit.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click()", submit);
        }
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;


    }

    public String getErrorMessage()
    {
        // Try avoiding wait timeout by using list of elements to see if they're available immediately
        if (!emptyEmailErrorMessage.isEmpty() && emptyEmailErrorMessage.get(0).isDisplayed()) {
             return emptyEmailErrorMessage.get(0).getText();
        }

        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/client");
    }
}
