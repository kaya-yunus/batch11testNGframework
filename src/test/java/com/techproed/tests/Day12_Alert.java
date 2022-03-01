package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day12_Alert {
/*
● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
● Bir metod olusturun: acceptAlert
 ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
   “You successfuly clicked an alert” oldugunu test edin.
● Bir metod olusturun: dismissAlert
 ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının  “successfuly” icermedigini test edin.
● Bir metod olusturun: sendKeysAlert
 ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
 */
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAlert() throws InterruptedException {
        //○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //   “You successfuly clicked an alert” oldugunu test edin.
        WebElement clickJSAlert= driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        clickJSAlert.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        WebElement ekranMesaji= driver.findElement(By.xpath("//p[@id='result']"));
        String actualEkranMesaji=ekranMesaji.getText();
        String expectedAlertMesaj="You successfuly clicked an alert";

        Assert.assertEquals(actualEkranMesaji,expectedAlertMesaj);

    }
    @Test
    public void dismissAlert(){
        //Bir metod olusturun: dismissAlert
        // ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        // “successfuly” icermedigini test edin.
        WebElement button2= driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        button2.click();
        driver.switchTo().alert().dismiss();
        WebElement ekranMesaji= driver.findElement(By.xpath("//p[@id='result']"));
        String actualMesaj=ekranMesaji.getText();
        String expectedMesaj="successfuly";

        Assert.assertFalse(actualMesaj.contains(expectedMesaj));

    }
    @Test
    public void sendKeysAlert() throws InterruptedException {
        // ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna  tıklayın ve
        // result mesajında isminizin görüntülendiğini doğrulayın.
        WebElement button3= driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button3.click();
        driver.switchTo().alert().sendKeys("Necip");
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        WebElement ekranMesaji= driver.findElement(By.xpath("//p[@id='result']"));
        String actualEkranMesaji=ekranMesaji.getText();
        String expectedEkranMesaji="Necip";

        Assert.assertTrue(actualEkranMesaji.contains(expectedEkranMesaji));

    }

    @AfterClass
    public void tearDown(){
        driver.close();

    }
}
