package com.techproed.smokeTest;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegatifTest extends TestBase {

    /*
    1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
3 Farkli test Methodunda 3 senaryoyu test et
  - yanlisSifre
  - yanlisKulllanici
  - yanlisSifreKullanici
2) http://qa-environment.crystalkeyhotels.com/ adresine git
3) Login butonuna bas
4) Verilen senaryolar ile giris yapilamadigini test et
     */

    Faker faker=new Faker(); //tum sayfalarda kullanicagim icin tekrar tekrar yazmiyorum buraya yazdim.

    public void loginPage(){
        driver.get("http://qa-environment.crystalkeyhotels.com/");
        WebElement logInPage= driver.findElement(By.linkText("Log in"));
        logInPage.click();
    }
    @Test (groups = "grup1")
    public void yanlisSifre(){

        //dogru kullanici adi
        loginPage();
        WebElement userName= driver.findElement(By.xpath("//input[@name='UserName']"));
        userName.sendKeys("manager");

        //yalissifre
        WebElement password= driver.findElement(By.id("Password"));
        password.sendKeys(faker.internet().password());

        //) Verilen senaryolar ile giris yapilamadigini test et
        WebElement login= driver.findElement(By.id("btnSubmit"));
        login.click();

        WebElement uyari= driver.findElement(By.xpath("//span[.='Try again please']"));
        Assert.assertTrue(uyari.isDisplayed());

    }
    @Test (groups = "grup1")
    public void yanlisKullaniciAdi(){

        //yanlis kullanici adi
        loginPage();

        //yanlis kullanici adi
        WebElement userName= driver.findElement(By.xpath("//input[@name='UserName']"));
        userName.sendKeys(faker.name().firstName());

        //dogrusifre
        WebElement password= driver.findElement(By.id("Password"));
        password.sendKeys("Manager1!");

        //) Verilen senaryolar ile giris yapilamadigini test et
        WebElement login= driver.findElement(By.id("btnSubmit"));
        login.click();

        WebElement uyari= driver.findElement(By.xpath("//span[.='Try again please']"));
        Assert.assertTrue(uyari.isDisplayed());

    }
    @Test
    public void yanlisSifreKullanici(){
        //yanlis kullanici ve sifre
        loginPage();

        //yanlis kullanici adi
        WebElement userName= driver.findElement(By.xpath("//input[@name='UserName']"));
        userName.sendKeys(faker.name().firstName());

        //yanlissifre
        WebElement password= driver.findElement(By.id("Password"));
        password.sendKeys(faker.internet().password());

        //) Verilen senaryolar ile giris yapilamadigini test et
        WebElement login= driver.findElement(By.id("btnSubmit"));
        login.click();

        WebElement uyari= driver.findElement(By.xpath("//span[.='Try again please']"));
        Assert.assertTrue(uyari.isDisplayed());
    }
}
