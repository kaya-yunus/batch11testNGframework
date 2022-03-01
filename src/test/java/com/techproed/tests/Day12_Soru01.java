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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day12_Soru01 {

    /*
● Bir class olusturun: D12_IframeTest
● https://the-internet.herokuapp.com/iframe adresine gidin.
● Bir metod olusturun: iframeTest
 ○ “An IFrame containing….” textini konsolda yazdirin.
 ○ Text Box’a “Merhaba Dunya!” yazin.
 ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda  yazdirin.
     */

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @Test
    public void iframeTest(){
        //○ “An IFrame containing….” textini konsolda yazdirin.
        WebElement iFrameText= driver.findElement(By.xpath("//h3"));
        System.out.println(iFrameText.getText());


        //○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement iFrame= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrame);

        WebElement textYazmaAlani= driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        textYazmaAlani.clear();
        textYazmaAlani.sendKeys("Merhaba Dunya!");

        //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda  yazdirin.

        //burda frame'den cikmak gerekiyor. 2 yol var. Bir ust iframe'e gecmek icin parentFrame
        //direk bulundugum web sayfasina cikmak icin defaultcontent'e switch yapiyoruz.
        driver.switchTo().defaultContent();

        WebElement linkText= driver.findElement(By.linkText("Elemental Selenium"));
        System.out.println(linkText.getText());
        Assert.assertTrue(linkText.isDisplayed());

    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}

