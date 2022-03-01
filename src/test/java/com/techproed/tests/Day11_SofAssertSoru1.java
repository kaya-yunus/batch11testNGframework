package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day11_SofAssertSoru1 {
    /*
    1. “http://zero.webappsecurity.com/” Adresine gidin
 2. Sign in butonuna basin
 3. Login kutusuna “username” yazin
 4. Password kutusuna “password.” yazin
 5. Sign in tusuna basin
 6. Pay Bills sayfasina gidin
 7. “Purchase Foreign Currency” tusuna basin
 8. “Currency” drop down menusunden Eurozone’u secin
 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One",
 "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)",
 "Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)",
 "Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
     */

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/");
    }
    @org.testng.annotations.Test(priority = 1)
    public void signIn(){
        //2. Sign in butonuna basin
        WebElement signInButonu= driver.findElement(By.xpath("//button[@id='signin_button']"));
        signInButonu.click();

        //3. Login kutusuna “username” yazin
        WebElement loginButonu= driver.findElement(By.xpath("//input[@id='user_login']"));
        loginButonu.sendKeys("username");

        //4. Password kutusuna “password” yazin
        WebElement passWordKutusu= driver.findElement(By.xpath("//input[@id='user_password']"));
        passWordKutusu.sendKeys("password");

        //5. Sign in tusuna basin
        WebElement signIn=driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        signIn.click();

    }
    @org.testng.annotations.Test(priority = 2)
    public void payBills(){
        //6. Pay Bills sayfasina gidin
        WebElement payBillsLinki= driver.findElement(By.xpath("//a[@href='/bank/redirect.html?url=pay-bills.html']"));
        payBillsLinki.click();

        //7. “Purchase Foreign Currency” tusuna basin
        WebElement pFCurrency= driver.findElement(By.xpath("//a[@href='#ui-tabs-3']"));
        pFCurrency.click();

    }
    @org.testng.annotations.Test(priority = 3)
    public void dropDownMenusu(){
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencyDropDown= driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(currencyDropDown);
        select.selectByVisibleText("Eurozone (euro)");

        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String actualDropMenu=select.getFirstSelectedOption().getText();
        String expectedDropMenu="Eurozone (Euro)";
        softAssert.assertEquals(actualDropMenu,expectedDropMenu,"Eurozone (Euro) yazimi yanlis");

        //10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One",
        // "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)",
        // "Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)",
        // "Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

        List<WebElement> allOptions=select.getOptions();
        List<String>actualAllOptionList=new ArrayList<>();
        for(WebElement w:allOptions){
            actualAllOptionList.add(w.getText());
        }

        List<String>expectedOptionsList= Arrays.asList("Select One",
                "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)",
                "Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)",
                "Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)");

        softAssert.assertEquals(actualAllOptionList,expectedOptionsList, "liste  yanlis yazilmis");


        softAssert.assertAll();

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
