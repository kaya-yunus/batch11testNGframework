package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Day11_SoftAssert {
    /*
    Yeni bir Class Olusturun : D11_SoftAssert1
    1. “http://https://www.sahibinden.com/” Adresine gidin
    2. Basliginin "Sahibinden Satılık, Kiralık, Emlak, Oto, Alışveriş Ürünleri" oldugunu  dogrulayin
    3. search kutusuna araba yazip arattirin
    4. bulunan sonuc sayisini yazdirin
    5. sonuc yazisinin "araba" icerdigini dogrulayin
    6. Tumunu temizle linkini tiklayin
    7. Bulunan sonucu yazdirin
    8. Sonuc yazisinin “araba” kelimesi icermedigini dogrulayin
     */

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }
    @Test
    public void test01(){
        //2. Basliginin "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more" oldugunu  dogrulayin
        SoftAssert softAssert=new SoftAssert();
        String actualTitle=driver.getTitle();
        String expectedTitle="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        softAssert.assertEquals(actualTitle,expectedTitle,"Anasayfa title'i stedigimiz gibi degil");
        //***ONEMLI-->basarili olunca mesaj ekranda gozukmez.

        //3. search kutusuna araba yazip arattirin
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("apple"+ Keys.ENTER);


        //4. bulunan sonuc sayisini yazdirin
        WebElement appleSonuc= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(appleSonuc.getText());

        //5. sonuc yazisinin "apple" icerdigini dogrulayin
        String actualappleResult=appleSonuc.getText();
        String expectedAppleResult="apple";
        softAssert.assertTrue(actualappleResult.contains(expectedAppleResult),"yanlis");



        // 7. Bulunan sonucu yazdirin
        //WebElement yeniSonuc= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        //8. Sonuc yazisinin “araba” kelimesi icermedigini dogrulayin
        String actualLaptop=appleSonuc.getText();
        String expectedLaptop="elma";
        softAssert.assertTrue(actualLaptop.contains(expectedLaptop),"sonuc apple iceriyor");





        softAssert.assertAll();
    }
    @Test
    public void searchBox(){

        SoftAssert softAssert=new SoftAssert();
        String actualTitle= driver.getTitle();
        String expectedTitle="Amazon";
        softAssert.assertTrue(actualTitle.contains(expectedTitle));

        softAssert.assertAll();

        System.out.println(actualTitle);



    }
    @AfterClass
    public void tearDown(){
        driver.close();

    }

}
