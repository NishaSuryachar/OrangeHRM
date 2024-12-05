package com.OrangeHRM.base;

import com.OrangeHRM.Pages.HomePage;
import com.OrangeHRM.Pages.LoginPage;
import com.OrangeHRM.Util.ExcelUtility;
import com.OrangeHRM.Util.PropertyUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public class BaseClass
{
    public static WebDriver driver;

    //@Parameters("browser")
    @BeforeClass
    public void launchTheBrowser(/*String browser*/)
    {
//       if (browser.equalsIgnoreCase("chrome")) {
//           driver = new ChromeDriver();
//       } else if (browser.equalsIgnoreCase("edge")) {
//           driver = new EdgeDriver();
//       }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void LoginToApp() throws IOException {

        PropertyUtility putil = new PropertyUtility();
        String URL = putil.getDataFromProperty("url");
        driver.get(URL);
        ExcelUtility eutil=new ExcelUtility();
        String USERNAME=eutil.getDataFromExcel("Login",1,0);
        String PASSWORD=eutil.getDataFromExcel("Login",1,1);
        LoginPage lp=new LoginPage(driver);
        lp.LoginPage(USERNAME,PASSWORD);
    }

    @AfterMethod
    public void LogoutToApp()
    {
        HomePage hp=new HomePage(driver);
        hp.Logout();
    }

    @AfterClass
    public void closTheBrowser()
    {
        driver.quit();
    }
}
