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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day10_DropDownSoru {
    /*
       ● https://www.amazon.com/ adresine gidin.
     - Test 1
       Arama kutusunun yanindaki kategori menusundeki kategori sayisinin  45 oldugunu test edin
     -Test 2
       1. Kategori menusunden Books secenegini  secin
       2. Arama kutusuna Java yazin ve aratin
       3. Bulunan sonuc sayisini yazdirin
       4. Sonucun Java kelimesini icerdigini test edin
     */

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @BeforeMethod
    public void sayfayaGit(){
        driver.get("https://www.amazon.com/");
    }
    @Test
    public void test01(){
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin  45 oldugunu test edin
        WebElement kategoriMenusu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(kategoriMenusu);
        List<WebElement> kategoriList= select.getOptions();
        int kategoriSayisi=kategoriList.size()-1;
        System.out.println(kategoriSayisi);
        Assert.assertTrue(kategoriSayisi==45);
    }
    @Test
    public void test02(){
        // 1. Kategori menusunden Books secenegini  secin
        WebElement kategoriMenusu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(kategoriMenusu);
        select.selectByVisibleText("Books");

        //2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java");
        aramaKutusu.submit();

        //3. Bulunan sonuc sayisini yazdirin
        WebElement javaSonuc= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(javaSonuc.getText());

        //4. Sonucun Java kelimesini icerdigini test edin
        String actualText=javaSonuc.getText();
        String expectedText="Java";
        Assert.assertTrue(actualText.contains(expectedText));

    }
    @AfterClass
    public void tearDown()  {
        driver.close();
       // Thread.sleep(5000);

    }

}
