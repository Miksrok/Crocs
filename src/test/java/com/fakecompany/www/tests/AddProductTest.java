package com.fakecompany.www.tests;

import com.fakecompany.www.BaseScript;
import com.fakecompany.www.pages.MenFootwearPage;
import org.testng.annotations.Test;

/**
 * Created by Залізний Мозок on 16.10.2017.
 */
public class AddProductTest extends BaseScript{

    private MenFootwearPage menFootwearPage;

    @Test
    public void addProductToCart() throws InterruptedException {

        mainPage.openMainPage();
        mainPage.skipAdd();
        menFootwearPage = mainPage.clickMenFootwearLink();
        menFootwearPage.choseProduct();
        /*productPage.selectSize();
        productPage.addToChart();*/


    }

}
