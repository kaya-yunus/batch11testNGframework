package com.techproed.smokeTest;

import com.techproed.pages.CrsytalHotelPage;
import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PozitiveTestWithPage extends TestBase {
    /*
        1) com.techproed altinda bir package olustur : smoketest
    2) Bir Class olustur : PositiveTest
    3) Bir test method olustur positiveLoginTest()
       http://qa-environment.crystalkeyhotels.com adresine git
      login butonuna bas
    test data username: manager ,
    test data password : Manager2!
    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
         */
    @Test
    public void test(){
        driver.get("http://qa-environment.crystalkeyhotels.com");
        //login butonuna bas
        CrsytalHotelPage crsytalHotelPage=new CrsytalHotelPage(driver);
        crsytalHotelPage.loginLink.click();
        crsytalHotelPage.usernameTextBox.sendKeys("manager");
        crsytalHotelPage.passwordBox.sendKeys("Manager2!");
        crsytalHotelPage.loginButton.click();

        Assert.assertTrue(crsytalHotelPage.systemManagentmenu.isDisplayed());


    }
}
