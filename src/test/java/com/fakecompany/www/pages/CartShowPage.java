package com.fakecompany.www.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Залізний Мозок on 17.10.2017.
 */
public class CartShowPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By continueButton = By.id("checkout0");


    public CartShowPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public CheckoutPage clickContinueButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.continueButton));
        WebElement continueButton = driver.findElement(this.continueButton);
        continueButton.click();
        return new CheckoutPage(driver);
    }

}
