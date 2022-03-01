package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day15_UploadFile extends TestBase {
    /*
    1.Tests packagenin altina bir class oluşturun : D14_UploadFile
    2.https://the-internet.herokuapp.com/upload adresine gidelim
    3.chooseFile butonuna basalim
    4. Yuklemek istediginiz dosyayi secelim.
    5. Upload butonuna basalim.
    6. “File Uploaded!” textinin goruntulendigini test edelim.
     */
    @Test
    public void test01(){

        driver.get("https://the-internet.herokuapp.com/upload");

        //3.chooseFile butonuna basalim
        WebElement chooseFile= driver.findElement(By.id("file-upload"));
       // chooseFile.click();

        //4. Yuklemek istediginiz dosyayi secelim.
        // ilk olarak chooseFile butonu locate edilir zaten yukarda yaptim. 2. olarak
        // yuklenecek dosyanin yolunu hazirlamaliyim

        String homePath=System.getProperty("user.home");
        String yuklenecekDosya=homePath+"\\Desktop\\FLOWER.jpg";

        chooseFile.sendKeys(yuklenecekDosya); //click yapmadan yuklenecek dosyanin pathini yazdim alana

        WebElement uploadButonu= driver.findElement(By.id("file-submit"));
        uploadButonu.click();

        WebElement uploadedYazisi= driver.findElement(By.xpath("//h3"));

        String actualUploadedYazisi=uploadedYazisi.getText();
        String expectedUploadedText="File Uploaded!";

        Assert.assertEquals(actualUploadedYazisi,expectedUploadedText);



    }
}
