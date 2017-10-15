package com.fakecompany.www.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;


public class AuthorizationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By nameField = By.id("dwfrm_login_username");
    private By passwordField = By.id("dwfrm_login_password");
    private By loginButton = By.name("dwfrm_login_login");
    private By errorMessage = By.id("dwfrm_login_password-error");

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public boolean isAuthPage(){
        //wait.withTimeout(15, TimeUnit.SECONDS);
       String url =  driver.getCurrentUrl();
       System.out.println(url.equals("https://www.crocs.eu/on/demandware.store/Sites-crocs_eu-Site/en_ES/Login-Show"));
       return url.equals("https://www.crocs.eu/on/demandware.store/Sites-crocs_eu-Site/en_ES/Login-Show");

    }

    public CustomerPage enterLoginAndPassword(String login, String password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(this.nameField));
        WebElement nameField = driver.findElement(this.nameField);
        nameField.sendKeys(login);

        WebElement passwordField = driver.findElement(this.passwordField);
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(this.loginButton);
        loginButton.click();

        return new CustomerPage(driver);
    }
    public boolean isErrorMessagePresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.errorMessage));
        String errorMessage = driver.findElement(this.errorMessage).getText();
        System.out.println(errorMessage);
        return errorMessage.equals("Invalid Username or Password.");
    }

}
