package com.techproed.smokeTest;

import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class GlbSignUpTest {
//1. pages paketinin altina bir page class olusturun : GlbSignUpPage ve Page
//objelerini(webelement) locate edin.
//2. smoketest paketinin altina bir test classi olusturun : GlbSignUpTest
//Kullanici kimlik bilgileri ile kayit oldugunda “Success!” mesajini gordugunu
//test edin
    @Test
    public void test() throws InterruptedException {
        Driver.getDriver().get("https://www.glbtrader.com/register.html");
        GlbSignUpPage glbSignUpPage=new GlbSignUpPage();
        glbSignUpPage.emailTextBox.sendKeys("adnan7klc@gmail.com");
        glbSignUpPage.nameTextBox.sendKeys("Necip");
        glbSignUpPage.phoneTextBox.sendKeys("+306988080757");
        glbSignUpPage.passwordTextBox.sendKeys("Trtyyh98");
        glbSignUpPage.confirmPassword.sendKeys("Trtyyh98");
        glbSignUpPage.signUpButon.submit();
        Thread.sleep(5000);

    }
}
