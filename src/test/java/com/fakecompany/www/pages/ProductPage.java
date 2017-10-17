package com.fakecompany.www.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Залізний Мозок on 16.10.2017.
 */
public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By sizeButtonBlock = By.id("size-refine-text");
    private By sizeButton = By.xpath("//ul[@id='u']/li[1]/label/div/span[1]");
    private By productAddButton = By.id("product-add-btn");
    private By productCard = By.id("cboxLoadedContent");
    private By viewCartAndCheckoutButton = By.linkText("View Cart & Checkout");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }


    public void selectSize() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(this.sizeButtonBlock));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.scrollBy(0, 350)");
        WebElement sizeButton = driver.findElement(this.sizeButton);
        sizeButton.click();

    }

    public void addToCart() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(this.productAddButton));
        WebElement productAddButton = driver.findElement(this.productAddButton);
        productAddButton.click();
        Thread.sleep(15000);

    }

    public CartShowPage viewCartAndCheckout(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.productCard));
        WebElement viewCartAndCheckoutButton = driver.findElement(this.viewCartAndCheckoutButton);
        viewCartAndCheckoutButton.click();
        return new CartShowPage(driver);

    }
}
