package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day14_MouseActon02 extends TestBase {

    /*
    Yeni bir class olusturalim: D14_MouseActions2
    1- http://uitestpractice.com/Students/Actions adresine gidelim
    2- Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini  gorelim
    3- Click Me butonuna click yapalim ve cikan alertteki mesajin  "Clicked !!" oldugunu dogrulayalim
    4- Double Click Me! butonuna tiklayalim ve cikan mesajin "Double  Clicked !!" oldugunu dogrulayalim
    5- Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
     */
    @Test
    public void test01(){
        driver.get("http://uitestpractice.com/Students/Actions");

        //2- Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini  gorelim
        Actions actions=new Actions(driver);
        WebElement maviKutu= driver.findElement(By.xpath("//div[@id='div2']"));
        actions.moveToElement(maviKutu).perform(); //moveto deyince oraya gidiyor

        //3- Click Me butonuna click yapalim ve cikan alertteki mesajin  "Clicked !!" oldugunu dogrulayalim
        WebElement clickMe= driver.findElement(By.xpath("//button[@name='click']"));
        actions.click(clickMe).perform();

        String actualAlertText=driver.switchTo().alert().getText();
        String expectedAlertText="Clicked !!";

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualAlertText,expectedAlertText,"alert uzerindeki yazi 'Clicked !!' degildir");

        //4- Double Click Me! butonuna tiklayalim ve cikan mesajin "Double  Clicked !!" oldugunu dogrulayalim
        driver.switchTo().alert().accept();

        WebElement doubleClick= driver.findElement(By.xpath("//button[@name='dblClick']"));
        actions.doubleClick(doubleClick).perform();

        String actualDoubleClickAlertText=driver.switchTo().alert().getText();
        String expectedDoubleClickAlertText="Double Clicked !!";

        softAssert.assertEquals(actualDoubleClickAlertText,expectedDoubleClickAlertText,"Double click yazisi yanlis");

        // 5- Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
        driver.switchTo().alert().accept();

        WebElement alinanacakKutu= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement gonderilecekKutu=driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.dragAndDrop(alinanacakKutu,gonderilecekKutu).perform();
        String actualDropped=gonderilecekKutu.getText();
        String expectedDroppedText="Dropped!";

        softAssert.assertEquals(actualDropped,expectedDroppedText);

        softAssert.assertAll();
        System.out.println("=====");









    }
}
