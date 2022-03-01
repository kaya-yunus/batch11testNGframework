package com.techproed.tests;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day17_CreateHotel extends TestBase {
    /*
    1. Tests packagenin altına class olusturun: CreateHotel
2. Bir metod olusturun: createHotel
3. qa-environment.crystalkeyhotels.com adresine git.
4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri  girin.
 a. Username : manager
 b. Password : Manager2!
5. Login butonuna tıklayın.
6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
8. Save butonuna tıklayın.
9. “Hotel was inserted successfully” textinin göründüğünü test edin.
10. OK butonuna tıklayın.
     */

    public void logIn(){
        driver.get("http://qa-environment.crystalkeyhotels.com/");
        WebElement logInPage= driver.findElement(By.linkText("Log in"));
        logInPage.click();

        Actions actions=new Actions(driver);
        WebElement userName= driver.findElement(By.xpath("//input[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager2!").perform();

        //Degerleri girildiginde login tiklama
        WebElement loginTus= driver.findElement(By.id("btnSubmit"));
        loginTus.click();


    }
    @Test
    public void createHotel() throws InterruptedException {
     logIn();
     //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        WebElement hotelManagement= driver.findElement(By.xpath("(//span[@class='title'])[3]"));
        hotelManagement.click();

        WebElement hotelList= driver.findElement(By.xpath("//a[@href='/admin/HotelAdmin']"));
        hotelList.click();

        WebElement addHotelLink= driver.findElement(By.xpath("//span[@class='hidden-480']"));
        addHotelLink.click();

        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Actions actions=new Actions(driver);
        WebElement codeBox= driver.findElement(By.id("Code"));
        Faker faker=new Faker();
        actions.click(codeBox).sendKeys("15").sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().phoneNumber()).sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).perform();

        WebElement dropDown= driver.findElement(By.id("IDGroup"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("Hotel Type2");

        WebElement saveButton= driver.findElement(By.xpath("//button[@id='btnSubmit']"));
        //actions.doubleClick(saveButton);
       saveButton.click();

        Thread.sleep(2000);
        //9. “Hotel was inserted successfully” textinin göründüğünü test edin.
        WebElement mesaj= driver.findElement(By.xpath("//*[text()='Hotel was inserted successfully']"));
        String actualMessage=mesaj.getText();
        System.out.println(actualMessage);
        String expectedMessage="Hotel was inserted successfully";

        Thread.sleep(3000);
        Assert.assertEquals(actualMessage,expectedMessage);

        //10. OK butonuna tıklayın.
        WebElement acceptTusu= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        acceptTusu.click();


    }

}
