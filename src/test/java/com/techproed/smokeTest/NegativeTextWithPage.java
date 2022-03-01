package com.techproed.smokeTest;

import com.techproed.pages.CrsytalHotelPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTextWithPage extends TestBase {
    /*
    1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
3 Farkli test Methodunda 3 senaryoyu test et
  - yanlisSifre
  - yanlisKulllanici
  - yanlisSifreKullanici
2) http://qa-environment.crystalkeyhotels.com/ adresine git
3) Login butonuna bas
4) Verilen senaryolar ile giris yapilamadigini test et
     */
    @Test
    public void test(){
        driver.get("http://qa-environment.crystalkeyhotels.com");
        CrsytalHotelPage crsytalHotelPage=new CrsytalHotelPage(driver);
        crsytalHotelPage.loginLink.click();
        crsytalHotelPage.usernameTextBox.sendKeys("manager");
        crsytalHotelPage.passwordBox.sendKeys("12345");
        crsytalHotelPage.loginButton.click();

        WebElement uyari= driver.findElement(By.xpath("//span[.='Try again please']"));
        Assert.assertTrue(uyari.isDisplayed());
    }
}
