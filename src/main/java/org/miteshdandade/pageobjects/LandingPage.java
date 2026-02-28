package org.miteshdandade.pageobjects;

import org.miteshdandade.AbstractComponents.AbstractComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        //initialization
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement passwordEle;

    @FindBy(id="login")
    WebElement submit;
    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;


    public ProductCatalogue loginApplication(String email,String password)
    {
        userEmail.sendKeys(email);
        passwordEle.sendKeys(password);
        submit.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;


    }

    public String getErrorMessage()
    {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/client");
    }
}
