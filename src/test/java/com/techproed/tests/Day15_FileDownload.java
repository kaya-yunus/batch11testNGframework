package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day15_FileDownload extends TestBase {
/*
1. Tests packagenin altina bir class oluşturalim : D14_FileDownload
2. Iki tane metod oluşturun : isExist() ve downloadTest()
3. downloadTest () metodunun icinde aşağıdaki testi yapalim:
  - https://the-internet.herokuapp.com/download adresine gidelim.
  - image1.jpg dosyasını indirelim
4. Ardından isExist()  methodunda dosyanın başarıyla indirilip indirilmediğini test  edelim
 */

    @Test (dependsOnMethods = "downloadTest")
    public void isExist(){

        //4. Ardından isExist()  methodunda dosyanın başarıyla indirilip indirilmediğini test  edelim
        String homePath= System.getProperty("user.home");
        String imageDosyasi=homePath+"\\Downloads\\image.jpg";
        boolean imageDosyasiIsExist= Files.exists(Paths.get(imageDosyasi));
        Assert.assertTrue(imageDosyasiIsExist);
    }
    @Test
    public void downloadTest() throws InterruptedException {
         driver.get("https://the-internet.herokuapp.com/download");
         //- image.jpg dosyasını indirelim
        WebElement imageDosyasi= driver.findElement(By.linkText("image.jpg"));
        imageDosyasi.click();
        Thread.sleep(5000);
    }
}
