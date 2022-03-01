package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day12_Iframe {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://html.com/tags/iframe/");
    }
    @Test
    public void test01(){
        //play tusuna basin
        //WebElement playTusu= driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        //playTusu.click();
        //play tusu locate edilemiyor normal yollardan
        //Assert.assertTrue(playTusu.isEnabled());

        Actions actions=new Actions(driver); //2 kere page down yapinca iframe ulasiyor--elle test ettim
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        //ilk olarak iframe locate edilir

        WebElement iframe= driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        driver.switchTo().frame(iframe);

        //Iframe icinde istedigimiz web elementi locate edilip istedigimiz islemi yapabiliriz
        WebElement playTusu= driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        playTusu.click();

    }
}
