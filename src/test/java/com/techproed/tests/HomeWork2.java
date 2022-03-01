package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class HomeWork2 {

    /*
    1. https://www.amazon.com/ adresine gidin
    2. softassert kullanarak amazon websitesine gittiginizi dogrulayin
    3. kategori dropdown'indan Books kategorisini secin
       arama kutusuna history yazdirip aratin
    4. cikan kitaplardan 2. ve 5. kitabin isminde History kelimesinin gectigini dogrulayin
    5. cikan sonuc sayisinin 50000'den buyuk oldugunu dogrulayin

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
    public void verification(){
        WebElement logo= driver.findElement(By.id("nav-logo-sprites"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(logo.isDisplayed(),"Amazon sitesine gidemedik");

        //3. kategori dropdown'indan Books kategorisini secin, arama kutusuna history yazdirip aratin
        WebElement dropDown= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("Books");

        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("history"+ Keys.ENTER);

        //4. cikan kitaplardan 2. ve 5. kitabin isminde History kelimesinin gectigini dogrulayin
        WebElement kitap2= driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        System.out.println("2. kitap "+kitap2.getText());
        WebElement kitap5=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[5]"));
        System.out.println("5. kitap "+kitap5.getText());
        String actualKitap2Text=kitap2.getText();
        String actualKitap5Text=kitap5.getText();
        String expectedKitapText="History";

        softAssert.assertTrue(actualKitap2Text.contains(expectedKitapText)&&actualKitap5Text.contains(expectedKitapText),"2.ve5. kitaplar History kelimesini icermez");

        //5. cikan sonuc sayisinin 50000'den buyuk oldugunu dogrulayin
        WebElement historySearchResult= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonuc=historySearchResult.getText();
        String[] sonucArr=sonuc.split(" ");
        System.out.println(Arrays.toString(sonucArr));

        String sayisalSonuc=sonucArr[3].toString().replace(",","");
        System.out.println("History Arama sonucu= "+sayisalSonuc);
        int actualSonuc=Integer.valueOf(sayisalSonuc);

        int expectedSonuc=5000;

        softAssert.assertTrue(actualSonuc>expectedSonuc,"cikan sonuc 5000'den buyuk degil");

        softAssert.assertAll();
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
