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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day09_DropDown2 {
    /*
    ● Bir class oluşturun: DropDown
    ● https://the-internet.herokuapp.com/dropdown adresine gidin.
      1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
      2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
      3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin
        ve yazdırın
      4.Tüm dropdown değerleri(value) yazdırın
      5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda
      True , degilse False yazdırın.
     */

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dropdown");

    }
    @Test
    public void dropDownTesti() {
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        //1. adim: dropdown webelementini locate edelim
        WebElement dropDown= driver.findElement(By.xpath("//select[@id='dropdown']"));

        //2. adim: select objesi olusturulur ve locate edilen webelementi parametre olarak objeye eklenir.
        Select select=new Select(dropDown);

        //3. adim --> var olan 3 yontemden herhangi biri ile istedigimiz kategoriyi seceriz.
        select.selectByIndex(1); //elementi web sitesinde secer
        String ilkSecilenOpsiyon=select.getFirstSelectedOption().getText(); //secilmis olan elementin textini bize getirir

        //sectigimiz option'in "Opsiyon 1" oldugunu test edin
        String expectedOption="Opsiyon 1";
        Assert.assertEquals(ilkSecilenOpsiyon,expectedOption);

    }
    @Test
    public void test02(){
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        WebElement dropDown= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(dropDown);
        select.selectByValue("2");

        //sectigimiz opsiyonun
        String opsiyon2=select.getFirstSelectedOption().getText();
        String expected="Option 2";

        Assert.assertEquals(opsiyon2, expected);

    }
    @Test
    public void tumListe(){
        //4.Tüm dropdown değerleri(value) yazdırın
        WebElement dropDown= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(dropDown);
        List<WebElement> tumOptions= select.getOptions();

        //yazdirmak icin for-each loop kullaniyoruz
        for (WebElement w:tumOptions) {
            System.out.println(w.getText());

        }
       // List<String>expectedOptionsList=new ArrayList<>();

        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda
        //      True , degilse False yazdırın.
        int listeninBoyutu=tumOptions.size();
        if(listeninBoyutu==4){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        System.out.println(listeninBoyutu);
    }

    @AfterClass
    public void tearDown(){
        driver.close();

    }

}
