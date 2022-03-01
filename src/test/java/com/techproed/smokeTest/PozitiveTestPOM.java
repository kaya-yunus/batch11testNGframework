package com.techproed.smokeTest;

import com.techproed.utilities.ConfigReader;
import com.techproed.pages.CrsytalHotelPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class PozitiveTestPOM extends TestBase {

    @Test
    public void test(){
        driver.get(ConfigReader.getProperty("c_url"));
        CrsytalHotelPage crsytalHotelPage=new CrsytalHotelPage(driver);
        crsytalHotelPage.loginLink.click();
        crsytalHotelPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_user"));
        crsytalHotelPage.passwordBox.sendKeys(ConfigReader.getProperty("valid_password"));
        crsytalHotelPage.loginButton.click();
    }
}
