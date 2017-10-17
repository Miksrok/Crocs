package com.fakecompany.www.tests;

import com.fakecompany.www.BaseScript;
import com.fakecompany.www.pages.CartShowPage;
import com.fakecompany.www.pages.CheckoutPage;
import com.fakecompany.www.pages.MenFootwearPage;
import com.fakecompany.www.pages.ProductPage;
import org.testng.annotations.Test;

/**
 * Created by Залізний Мозок on 16.10.2017.
 */
public class AddProductTest extends BaseScript{

    private MenFootwearPage menFootwearPage;
    private ProductPage productPage;
    private CartShowPage cartShowPage;
    private CheckoutPage checkoutPage;

    @Test
    public void addProductToCart() throws InterruptedException {

        mainPage.openMainPage();
        mainPage.skipAd();
        menFootwearPage = mainPage.clickMenFootwearLink();
        productPage = menFootwearPage.choseProduct();
        productPage.selectSize();
        productPage.addToCart();
        cartShowPage = productPage.viewCartAndCheckout();
        checkoutPage = cartShowPage.clickContinueButton();
        checkoutPage.enterCustomerInformation();

    }

}
