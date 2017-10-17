package com.fakecompany.www;



import com.fakecompany.www.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public abstract class BaseScript {

    private final String CHROME_PATH = "src\\test\\resources\\chromedriver.exe";
    private final String FIREFOX_PATH = "src\\test\\resources\\geckodriver.exe";

    private WebDriver driver;
    protected MainPage mainPage;


    private WebDriver getDriver(String browser) {
        switch (browser){
            case "chrome":{
                System.setProperty("webdriver.chrome.driver", CHROME_PATH);
                return new ChromeDriver();
            }
            default:{
                System.setProperty("webdriver.gecko.driver", FIREFOX_PATH);
                return new FirefoxDriver();
            }
        }
    }

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        driver = getDriver(browser);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
    }

    @AfterClass
    public void tearDown() {
       /* if (driver != null) {
            driver.quit();
        }*/
    }

}
