package com.techproed.tests;

import com.techproed.utilities.TestBase; //baska bir paketten alinca import gerekiyor.
import org.testng.annotations.Test;

public class Day13_TextBase01 extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.youtube.com"); //bu class'ta driver olmayinca parenttan aldi kullandi.

    }
}
