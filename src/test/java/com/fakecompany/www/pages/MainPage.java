package com.fakecompany.www.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Залізний Мозок on 13.10.2017.
 */
public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By signInButton = By.className("headerLoginLink");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void openMainPage(){
        driver.get("https://www.crocs.eu/");
    }

    public AuthorizationPage clickSignInButton(){
        wait.withTimeout(15, TimeUnit.SECONDS);
        if(driver.findElement(By.id("cboxClose")).isDisplayed()){
            driver.findElement(By.id("cboxClose")).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.signInButton));
        WebElement signInButton = driver.findElement(this.signInButton);
        signInButton.click();
        return new AuthorizationPage(driver);
    }


}
