package com.fakecompany.www.tests;

import com.fakecompany.www.BaseScript;
import com.fakecompany.www.pages.AuthorizationPage;
import com.fakecompany.www.pages.CustomerPage;
import com.fakecompany.www.util.DataProv;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Залізний Мозок on 15.10.2017.
 */
public class WrongLoginTest extends BaseScript {
    private AuthorizationPage autorizationPage;
    private CustomerPage customerPage;

    @Test(dataProvider = "getWrongAuthorizationData", dataProviderClass = DataProv.class)
    public void wrongLoginTest(String login, String password){

        mainPage.openMainPage();
        autorizationPage =  mainPage.clickSignInButton();
        Assert.assertTrue(autorizationPage.isAuthPage());
        customerPage = autorizationPage.enterLoginAndPassword(login, password);
        Assert.assertTrue(autorizationPage.isErrorMessagePresent());

    }

}
