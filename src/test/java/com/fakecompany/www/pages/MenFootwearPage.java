package com.fakecompany.www.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Залізний Мозок on 16.10.2017.
 */
public class MenFootwearPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By productCards = By.id("categoryGridProductCards");
    private By product = By.xpath("//div[@id='categoryGridProductCards']/ul/li[1]/div/div/div/div/div/div[@class='imageDiv']");
    /*private By productLink = By.className("quickviewbutton-inner-left");*/

    public MenFootwearPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public ProductPage choseProduct() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(this.productCards));
        WebElement product = driver.findElement(this.product);
        System.out.println(product);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,product);
        product.click();
        return new ProductPage(driver);

    }
}
