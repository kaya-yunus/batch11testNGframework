package com.techproed.tests;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Day16_Faker extends TestBase {

    @Test
    public void test(){

        Faker faker=new Faker();
        System.out.println(faker.idNumber().valid());
        System.out.println(faker.internet().password());
    }
    /*
1."https://facebook.com" Adresine gidin
2.“create new account” butonuna basin
3.“firstName” giris kutusuna bir isim yazin
4.“surname” giris kutusuna bir soyisim yazin
5.“email” giris kutusuna bir email yazin
6.“email” onay kutusuna emaili tekrar yazin
7.Bir sifre girin
8.Tarih icin gun secin
9.Tarih icin ay secin
10.Tarih icin yil secin
11.Cinsiyeti secin
12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
13.Sayfayi kapatin
     */

    @Test
    public void test01(){
        driver.get("https://facebook.com");

        //2.“create new account” butonuna basin
        driver.findElement(By.xpath("//button[@id='u_0_h']")).click();

        WebElement createAccountButonu= driver.findElement(By.id("u_0_2"));
        createAccountButonu.click();

        //3.“firstName” giris kutusuna bir isim yazin
        WebElement firstNameBox=driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        Actions actions=new Actions(driver);
        actions.sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

        WebElement yilDropDown=driver.findElement(By.xpath("//select[@id='year']"));
        Select select= new Select(yilDropDown);
        select.selectByVisibleText("1986");

        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

        WebElement radiobutton=driver.findElement(By.xpath("(//input[@class='_8esa'])[1]"));
        actions.moveToElement(radiobutton).click().perform();

        WebElement signUpButton= driver.findElement(By.xpath("(//*[.='Sign Up'])[5]"));
        signUpButton.click();


    }
}
