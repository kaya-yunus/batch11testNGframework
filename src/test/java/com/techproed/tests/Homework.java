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

import java.util.concurrent.TimeUnit;

public class Homework {

    /*
    1. “http://zero.webappsecurity.com/” Adresine gidin
    2. Sign in butonuna basin
    3. Login kutusuna “username” yazin
    4. Password kutusuna “password” yazin
    5. Sign in tusuna basin
    6. Pay Bills sayfasina gidin
    7. “Purchase Foreign Currency” tusuna basin
    8. “Currency” drop down menusunden Eurozone’u secin
    9. “amount” kutusuna bir sayi girin
    10. “US Dollars” in secilmedigini test edin
    11. “Selected currency” butonunu secin
    12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
         control edin
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
    @Test(priority = 1)
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
    @Test (priority = 2)
    public void payBills(){
        //6. Pay Bills sayfasina gidin
        WebElement payBillsLinki= driver.findElement(By.xpath("//a[@href='/bank/redirect.html?url=pay-bills.html']"));
        payBillsLinki.click();

        //7. “Purchase Foreign Currency” tusuna basin
        WebElement pFCurrency= driver.findElement(By.xpath("//a[@href='#ui-tabs-3']"));
        pFCurrency.click();

    }
    @Test (priority = 3)
    public void dropDownMenusu(){
        ////8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencyDropDown= driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(currencyDropDown);
        select.selectByVisibleText("Eurozone (euro)");


        //9. “amount” kutusuna bir sayi girin
        WebElement amountKutusu=driver.findElement(By.xpath("//input[@id='pc_amount']"));
        amountKutusu.sendKeys("100");


    }
    @Test(priority = 4)
    public void usDollarTest(){
        //10. “US Dollars” in secilmedigini test edin
        WebElement usDollarRadyoButton= driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(usDollarRadyoButton.isSelected());
    }
    @Test (priority = 5)
    public void selectedCurrency(){
        //11. “Selected currency” butonunu secin
        WebElement selCurr= driver.findElement(By.id("pc_inDollars_false"));
        selCurr.click();

        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        WebElement calculateCostButonu= driver.findElement(By.id("pc_calculate_costs"));
        calculateCostButonu.click();

        WebElement purchaseButonu= driver.findElement(By.id("purchase_cash"));
        purchaseButonu.click();
    }
    @Test (priority = 6)
    public void ekranYazisiTesti(){
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini  control edin
        WebElement mesaj= driver.findElement(By.xpath("//div[@id='alert_content']"));
        String actualMesaj=mesaj.getText();
        String expectedMesaj="Foreign currency cash was successfully purchased.";

        Assert.assertEquals(actualMesaj,expectedMesaj);
    }

    @AfterClass
    public void tearDown(){
        //driver.close();
    }

}
