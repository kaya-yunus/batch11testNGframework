package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day14_Keyboard02 extends TestBase {

    /*
    1- Bir Class olusturalim D14_KeyboardActions1
    2- https://www.facebook.com sayfasina gidelim
    3- Kullanici adi : Mehmet , sifre : 12345 degerlerini girip login tusuna basalim
    4- basarili login olmadigini test edin
    https://html.com/tags/iframe/
     */

    @Test
    public void test01(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9fws _4jy3 _4jy1 selected _51sy']")).click();
        //3- Kullanici adi : Mehmet , sifre : 12345 degerlerini girip login tusuna basalim

        Actions actions = new Actions(driver);
        WebElement kullaniciAdi= driver.findElement(By.xpath("//input[@id='email']"));
        WebElement password=driver.findElement(By.xpath("//input[@id='pass']"));
        WebElement loginButtonu=driver.findElement(By.xpath("//button[@id='u_0_b']"));

        actions.click(kullaniciAdi) //tab deyince asagiya gidiyor mouse
                .sendKeys("mehmet")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();



    }
}
