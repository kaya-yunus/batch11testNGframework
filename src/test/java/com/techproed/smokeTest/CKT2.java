package com.techproed.smokeTest;

import com.techproed.pages.CKP2;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class CKT2 {

    @Test
    public void test(){

        Driver.getDriver().get(ConfigReader.getProperty("c_url"));
        CKP2 ckp2=new CKP2();
        ckp2.loginLink.click();


    }
}
