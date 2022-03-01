package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class Day13_SoruWindowHandle extends TestBase {

    /*
    ● Tests package’inda yeni bir class olusturun: D13_WindowHandle2
● https://the-internet.herokuapp.com/windows adresine gidin.
● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
● Click Here butonuna basın.
● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
● Sayfadaki textin “New Window” olduğunu doğrulayın.
● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”  olduğunu doğrulayın.
     */
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement pageText= driver.findElement(By.xpath("//h3[.='Opening a new window']"));
        String actualText=pageText.getText();
        String expectedText="Opening a new window";
        Assert.assertEquals(actualText,expectedText);
    }
    @Test
    public void test02(){
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void test03(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilksayfaHandle=driver.getWindowHandle();

        //● Click Here butonuna basın.
        WebElement clickHereButonu= driver.findElement(By.linkText("Click Here"));
        clickHereButonu.click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        String ikinciSayfaHandle="";
        Set<String> handles= driver.getWindowHandles();
        for(String w:handles){
            if(!ilksayfaHandle.equals(w)){
              ikinciSayfaHandle=w;
            }
        }
        driver.switchTo().window(ikinciSayfaHandle);
        String actualYeniSayfaTitle= driver.getTitle();
        String expectedYeniSayfaTitle="New Window";

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(actualYeniSayfaTitle,expectedYeniSayfaTitle,"yeni sayfa title yanlis");

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement pageText= driver.findElement(By.xpath("//h3"));
        String actualText=pageText.getText();
        String expectedText="New Window";

        softAssert.assertEquals(actualText,expectedText);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”  olduğunu doğrulayın.

        driver.switchTo().window(ilksayfaHandle);
        String actualilkSayfaTitle= driver.getTitle();
        String expectedilkSayfaTitle="The Internet";

        softAssert.assertEquals(actualilkSayfaTitle,expectedilkSayfaTitle, "ilk sayfa title'i The Internet degil");


        softAssert.assertAll();

    }
}
