package com.techproed.smokeTest;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PozitifTest extends TestBase {
    /*
    1) com.techproed altinda bir package olustur : smoketest
2) Bir Class olustur : PositiveTest
3) Bir test method olustur positiveLoginTest()
   http://qa-environment.crystalkeyhotels.com adresine git
  login butonuna bas
test data username: manager ,
test data password : Manager2!
Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */

    @Test
    public void positiveLoginTest(){
        //http://qa-environment.crystalkeyhotels.com adresine git
        //  login butonuna bas
        driver.get("http://qa-environment.crystalkeyhotels.com");
        WebElement loginButton= driver.findElement(By.xpath("(//a[@class='nav-link'])[7]"));
        loginButton.click();

        //test data username: manager ,
        Actions actions=new Actions(driver);
        WebElement userName= driver.findElement(By.xpath("//input[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager2!").perform();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        WebElement loginTus= driver.findElement(By.id("btnSubmit"));
        loginTus.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        WebElement adduser= driver.findElement(By.xpath("//*[text()='Add User ']"));
        Assert.assertTrue(adduser.isDisplayed());
    }
}
