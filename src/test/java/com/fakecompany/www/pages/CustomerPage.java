package com.fakecompany.www.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Залізний Мозок on 15.10.2017.
 */
public class CustomerPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public boolean isCustomerPage() {
        String url = driver.getCurrentUrl();
        return url.equals("https://www.crocs.eu/on/demandware.store/Sites-crocs_eu-Site/en_ES/Customer-Account");
    }
}
