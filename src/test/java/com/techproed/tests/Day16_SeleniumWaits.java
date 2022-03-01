package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_SeleniumWaits extends TestBase {

    /*
    1. Bir class olusturun : WaitTest
    2. Iki tane metod olusturun : implicitWait() , explicitWait()
       Iki metod icin de asagidaki adimlari test edin.
    3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    4. Remove butonuna basin.
    5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    6. Add buttonuna basin
    7. It’s back mesajinin gorundugunu test edin
     */
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");

        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));

        WebElement noExistElement= driver.findElement(By.id("null"));

    }
    @Test
    public void implicitlyWait(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement sonucYazisi= driver.findElement(By.xpath("//p[@id='message']"));
        //<p id="message">It's gone!</p>
        Assert.assertTrue(sonucYazisi.isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //7. It’s back mesajinin gorundugunu test edin
       // WebElement sonucYazisi= driver.findElement(By.xpath("//p[@id='message']")); zaten locate ettik yukarda
        WebElement sonucYazisi2= driver.findElement(By.xpath("//p[@id='message']")); //adi degistirdik
       //<p id="message">It's back!</p>
        Assert.assertTrue(sonucYazisi2.isDisplayed());// id ayni olmasina ragmen mesaj degisti. o yuzden stale elemnt
                                                    // hatasi verdi. onclick attribute dikkat

        //implicitlyWait 2 saniye yapinca fail oldu elementi bulamadi
    }

    @Test
    public void explicitlyWait(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin. nORMALDE CALISIYOR AMA ben yinede wait objesi olusturdum. aslinda benim icin kritik
                                   // beklemem gereken web elementleri icin wait objesi olustururlur.
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement removeButonu=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='swapCheckbox()']")));
        removeButonu.click();
        //remove butonu eski locate adresi
        //WebElement removeEskiButon=driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        //removeEskiButon.click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsgoneYazisi= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsgoneYazisi.isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsbackYazisi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
       // WebElement sonucYazisi2= driver.findElement(By.xpath("//p[@id='message']")); bu calismadi cunku implicitly kaldirmistik
    }

}
