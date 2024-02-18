package org.miteshdandade.tests;
import org.miteshdandade.TestComponents.Retry;
import org.miteshdandade.pageobjects.CartPage;
import org.miteshdandade.pageobjects.ProductCatalogue;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.miteshdandade.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest {
    @Test(groups= {"ErrorHandling"},retryAnalyzer= Retry.class)
    public void LoginErrorValidation() throws IOException, InterruptedException {


        landingPage.loginApplication("anshika@gmail.com", "Iamki000");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

    }


    @Test
    public void ProductErrorValidation() throws IOException, InterruptedException
    {

        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("rahulshetty@gmail.com", "Iamking@000");
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);



    }
}
