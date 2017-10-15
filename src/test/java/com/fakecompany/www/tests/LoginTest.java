package com.fakecompany.www.tests;

import com.fakecompany.www.BaseScript;
import com.fakecompany.www.pages.AuthorizationPage;
import com.fakecompany.www.pages.CustomerPage;
import com.fakecompany.www.util.DataProv;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseScript {
    private AuthorizationPage autorizationPage;
    private CustomerPage customerPage;

    @Test(dataProvider = "getAuthorizationData", dataProviderClass = DataProv.class)
    public void signInTest(String login, String password){
        mainPage.openMainPage();
        autorizationPage =  mainPage.clickSignInButton();
        Assert.assertTrue(autorizationPage.isAuthPage());
        customerPage = autorizationPage.enterLoginAndPassword(login, password);
        Assert.assertTrue(customerPage.isCustomerPage());
    }

}


