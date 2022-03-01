package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Day13_WindowsHandle01 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

        String ilkSayfaWindowHandle= driver.getWindowHandle(); //bulunulan pencerenin handle'i
        System.out.println(ilkSayfaWindowHandle); //7DF6D779AB246A32937479D260B44181 handle her calistirildiginda handle bilgisi degisiyor. HashCode olusturuyor unique

        //elemental selenium linkine tiklayin
        WebElement esLinki= driver.findElement(By.linkText("Elemental Selenium"));
        esLinki.click();

        //h1 tagindaki yazinin Elemental selenium oldugunu test edelim
        Thread.sleep(3000);

        //ikinki sayfanin handle'ini almam lazim onun icin weddriver o sayfaya gitmeli
        Set<String> tumHandles= driver.getWindowHandles(); //handles set dondurur ve handle string oldugundan return type string olur
        //set'lerde index olmaz onun icin ne kullaniyoruz.
        System.out.println(tumHandles);

        String ikinciSayfaWindowHandle="";
        for(String w:tumHandles){
            if(!ilkSayfaWindowHandle.equals(w)){
                ikinciSayfaWindowHandle=w;
            }
        }
        System.out.println(ikinciSayfaWindowHandle);

        driver.switchTo().window(ikinciSayfaWindowHandle);

        WebElement h1Elementi= driver.findElement(By.xpath("//h1")); //driver 1. sayfada olsugundan yeni sayfada locate edemedi
        System.out.println(h1Elementi.getText());

        Assert.assertEquals(h1Elementi.getText(),"Elemental selenium");

    }

}
