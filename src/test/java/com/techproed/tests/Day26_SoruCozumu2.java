package com.techproed.tests;

import com.techproed.utilities.Driver;
import com.techproed.pages.AmazonPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day26_SoruCozumu2 {

    @Test (groups = "grup1")
    public void AmazonYazisi(){
        // tabloda 9 Hucrede “Amazon” yazisi bulundugunu test edin
        Driver.getDriver().get("https://www.amazon.com");
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.getAction().sendKeys(Keys.END).perform();

        String actualData=amazonPage.getCell(1,9);
        System.out.println(actualData);
        boolean isContains=actualData.contains("Amazon");
        // Assert.assertTrue(isContains);

        //(Yanlis anlama) 9 Hucrede “Amazon” yazisi bulundugunu test edin


        System.out.println("satir sayisi:"+amazonPage.satirSayisi.size());
        System.out.println("sutun sayisi:"+amazonPage.sutunNum.size());
        System.out.println(amazonPage.getCell(9,13));

        /*
        int num=0;
        for (int i=2; i<amazonPage.satirSayisi.size(); i++){
            for(int k=2; k<amazonPage.sutunNum.size(); k++){
                if(amazonPage.getCell(i-1,k-1).contains("Amazon")){
                    num++;
                }
            }
        }
        System.out.println("num:"+num);
         */

        int count=0;
        for(WebElement w: amazonPage.cellNum){
            if(w.getText().contains("Amazon")){
                count++;
            }
        }
        int actualContains=count;
        System.out.println(actualContains);
        int expectedAmazonisContains=9;

        Assert.assertEquals(actualContains,expectedAmazonisContains);
    }

}
