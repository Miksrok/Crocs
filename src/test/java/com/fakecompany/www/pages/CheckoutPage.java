package com.fakecompany.www.pages;

import com.fakecompany.www.model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Customer customer;

    private By firstName = By.id("dwfrm_root_singleshipping_shippingAddress_addressFields_firstName");
    private By secondName = By.id("dwfrm_root_singleshipping_shippingAddress_addressFields_lastName");
    private By address = By.id("dwfrm_root_singleshipping_shippingAddress_addressFields_address1");
    private By postcode = By.id("dwfrm_root_singleshipping_shippingAddress_addressFields_zip");
    private By town = By.id("dwfrm_root_singleshipping_shippingAddress_addressFields_city");
    private By country = By.id("dwfrm_root_singleshipping_shippingAddress_addressFields_country");
    private By phone = By.id("dwfrm_root_singleshipping_shippingAddress_addressFields_phone");
    private By email = By.id("dwfrm_root_singleshipping_shippingAddress_email_emailAddress");
    private By confEmail = By.id("dwfrm_root_singleshipping_shippingAddress_email_emailAddressConfirm");
    private By checkBox = By.id("terms");
    private By paymentButton = By.xpath("//div[@class='rfe-buttons-center']/button");


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }
    public void enterCustomerInformation(){
        Actions actions = new Actions(driver);
        customer = Customer.getCustomer();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.firstName));
        WebElement firstName = driver.findElement(this.firstName);
        firstName.sendKeys(customer.getFirstName());

        WebElement secondName = driver.findElement(this.secondName);
        secondName.sendKeys(customer.getSecondName());

        WebElement address = driver.findElement(this.address);
        address.sendKeys(customer.getAddress());

        WebElement postcode = driver.findElement(this.postcode);
        postcode.sendKeys(customer.getPostcode());

        WebElement town = driver.findElement(this.town);
        town.sendKeys(customer.getTown());

        WebElement country = driver.findElement(this.country);
        country.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='CZ']")));
        WebElement countryName = driver.findElement(By.xpath("//option[@value='CZ']"));
        countryName.click();

        WebElement phone = driver.findElement(this.phone);
        phone.sendKeys(customer.getPhone());

        WebElement email = driver.findElement(this.email);
        email.sendKeys(customer.getEmail());

        WebElement confEmail = driver.findElement(this.confEmail);
        confEmail.sendKeys(customer.getEmail());

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.scrollBy(0, 550)");

        WebElement checkBox = driver.findElement(this.checkBox);
        checkBox.click();

        WebElement paymentButton = driver.findElement(this.paymentButton);
        paymentButton.click();

    }

}
