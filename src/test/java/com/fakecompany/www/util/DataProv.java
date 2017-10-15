package com.fakecompany.www.util;

import org.testng.annotations.DataProvider;

public class DataProv {

    @DataProvider(name = "getAuthorizationData")
    public static Object [][] getAuthorizationData (){
        return new Object[][] {
                {"mynewtestemail@gmail.com", "12345678"}
        };

    }
    @DataProvider(name = "getWrongAuthorizationData")
    public static Object [][] getWrongAuthorizationData (){
        return new Object[][] {
                {"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"}
        };
    }
}
