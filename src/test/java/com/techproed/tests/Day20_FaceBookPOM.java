package com.techproed.tests;

import com.techproed.pages.FaceBookPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Day20_FaceBookPOM extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[@title='Accept All']")).click();
        WebElement userTextBox= driver.findElement(By.id("email"));
        userTextBox.sendKeys("mehmet@gmail.com");

        WebElement password= driver.findElement(By.id("pass"));
        password.sendKeys("12345");

        WebElement loginBox= driver.findElement(By.xpath("//button[@name='login']"));
        loginBox.click();
    }
    @Test
    public void test02(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[@title='Accept All']")).click();
        //1. adimdaki hedef locater'lardan kurtulmak
        //bunun icin pages paketi altindaki ilgili page'de ihtiyac duydugum tum locate islemlerini yapip\
        //burada sadece kullanacagim
        FaceBookPage faceBookPage=new FaceBookPage(driver); //driver benimle hareket etmeli
        faceBookPage.userTextBox.sendKeys("mehmet@gmail.com");
        faceBookPage.passwordTextBox.sendKeys("12345");
        faceBookPage.loginButton.click();

    }

    @Test
    public void test03(){
        driver.get(ConfigReader.getProperty("facebook_url"));
        driver.findElement(By.xpath("//button[@title='Accept All']")).click();
        FaceBookPage faceBookPage=new FaceBookPage(driver);
        faceBookPage.userTextBox.sendKeys(ConfigReader.getProperty("fb_user"));
        faceBookPage.passwordTextBox.sendKeys(ConfigReader.getProperty("fb_pass"));
        faceBookPage.loginButton.click();
    }
}
