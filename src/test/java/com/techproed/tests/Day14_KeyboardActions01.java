package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day14_KeyboardActions01 extends TestBase {

    /*

     */
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));

        //1. adim actions abjesi olusturulur ve parametre driver olur.
        Actions actions=new Actions(driver);
        actions.click(searchBox).perform();
        actions.sendKeys("samsung").perform();
        //shift tusuna basmak istiyoruz. keydown sifte basili tutar
        actions.keyDown(Keys.SHIFT).perform();
        actions.sendKeys("a").perform();
        //siften elimi kaldirmak istiyoruz
        actions.keyUp(Keys.SHIFT).perform();
        actions.sendKeys("71").perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ENTER).perform();



    }
    @Test
    public void test02(){ //kisa yol
        driver.get("https://www.amazon.com");
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));

        //1. adim actions abjesi olusturulur ve parametre driver olur.
        Actions actions=new Actions(driver);

        actions.click(searchBox).
                sendKeys("samsung").
                keyDown(Keys.SHIFT).
                sendKeys("a").
                keyUp(Keys.SHIFT).
                sendKeys("71").
                sendKeys(Keys.ENTER).
                perform();



    }
}
