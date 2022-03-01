package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day16_HomeWork01 extends TestBase {

    /*
    1. Bir class olusturun : EnableTest
2. Bir metod olusturun : isEnabled()
3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
4. Textbox’in etkin olmadigini(enabled) dogrulayın
5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
7. Textbox’in etkin oldugunu(enabled) dogrulayın
     */
    @Test
    public void isEnabled(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement testbox=driver.findElement(By.xpath("//input[@type='text']"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertFalse(testbox.isEnabled());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebDriverWait wait=new WebDriverWait(driver,20);
        WebElement enableButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[2]")));
        enableButton.click();

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement ekranMesaji= driver.findElement(By.xpath("//p[@id='message']"));
        String actualMessage= ekranMesaji.getText();
        String expectedMessage="It's enabled!";
        softAssert.assertEquals(actualMessage,expectedMessage);

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın
        softAssert.assertTrue(testbox.isEnabled());

        softAssert.assertAll();
        System.out.println("Testler Basarili");


    }
    @Test
    public void enableButton(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }

}
