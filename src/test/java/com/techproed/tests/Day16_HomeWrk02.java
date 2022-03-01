package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day16_HomeWrk02 extends TestBase {
    /*
    1."http://webdriveruniversity.com/Actions" sayfasina gidin
2."Hover over Me First" kutusunun ustune gelin
3."Link 1" e tiklayin
4.Popup mesajini yazdirin
5.Popup'i tamam diyerek kapatin
6."Click and hold" kutusuna basili tutun
7. "Click and hold" kutusunda cikan yaziyi yazdirin
8. "Double click me" butonunu cift tiklayin
     */

    @Test
    public void test01() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Actions");
        //2."Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverBox= driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(hoverBox).perform();

        //3."Link 1" e tiklayin
        WebElement link1= driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"));
        link1.click();

        //4.Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5.Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6."Click and hold" kutusuna basili tutun
        WebElement clickHldBox= driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.sendKeys(Keys.PAGE_DOWN);

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickHldBox.getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickMe= driver.findElement(By.xpath("//h2"));
        Thread.sleep(3000);
        actions.doubleClick(doubleClickMe).perform();

    }
}
