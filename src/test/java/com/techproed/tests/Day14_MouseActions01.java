package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Day14_MouseActions01 extends TestBase {

    /*
    1- Yeni bir class olusturalim: D14_MouseActions1
    2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
    3 - Cizili alan uzerinde sag click yapalim
    4- Alert’te cikan yazinin “You selected a context menu” oldugunu
       test edelim.
    5- Tamam diyerek alert’I kapatalim
    6- Elemental Selenium linkine tiklayalim
    7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/context_menu ");

        //3 - Cizili alan uzerinde sag click yapalim
           //1.adim: action objesi olusturulur
        Actions actions=new Actions(driver);
           //2.adim: hedef elementi locate edilir
        WebElement ciziliAlan= driver.findElement(By.id("hot-spot"));
           //3.adim: sag click icin contextClick kullnilir
        actions.contextClick(ciziliAlan).perform(); // perform konulmasi lazim islem yapabilmesi icin

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String actualAlertText=driver.switchTo().alert().getText();
        String expectedAlertText="You selected a context menu";

        Assert.assertEquals(actualAlertText,expectedAlertText);

        //5- Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim

        String ilkSayfawindowHandle= driver.getWindowHandle();

        WebElement elementalSeLinki= driver.findElement(By.linkText("Elemental Selenium"));
        elementalSeLinki.click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> handleList=driver.getWindowHandles();

        String ikinciSayfaHandle="";
        for(String w:handleList){
            if(!ilkSayfawindowHandle.equals(w)){
                ikinciSayfaHandle=w;
            }
        }
        driver.switchTo().window(ikinciSayfaHandle);
        WebElement tagH1= driver.findElement(By.xpath("//h1"));

        String ach1EkranYazisi=tagH1.getText();
        String expectedH1="Elemental Selenium";

        Assert.assertEquals(ach1EkranYazisi,expectedH1);

        driver.switchTo().window(ilkSayfawindowHandle);


    }
}
