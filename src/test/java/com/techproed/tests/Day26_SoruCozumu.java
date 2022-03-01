package com.techproed.tests;

import com.techproed.pages.AmazonPage;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day26_SoruCozumu {
    //Soru 1 :
    //ØAmazon anasayfaya gidebilecek sekilde bir page sayfasi olusturun : AmazonPage
    //ØAmazon ana sayfasinda en altta bulunan Webtable’i inceleyebilmek icin AmazonPage clasinda en altta gitme
    // isini yapacak bir method olusturun
    //ØTests paketi altinda yeni bir class olusturun: D26_AmazonSatirSutunSayisi
    //ØBu class’in altinda bir test method olusturun : satirSayisi() ve webtable’da 10 satir oldugunu test edin
    //ØYeni bir method olusturun : sutunSayisi() ve yazi olan sutun sayisinin 7oldugunu test edin

    //Soru 2 :
    //ØAmazonPage sayfasinda istedigim satir ve sutun sayisi ile cagirdigimda bana hucredeki yaziyi getirecek
    // bir method olusturun
    //ØTests paketi altinda yeni bir class olusturun: D26_AmazonHucreTesti
    //ØBu class’in altinda bir test method olusturun : hucretesti() ve webtable’da 3. satir 2.sutundaki yazinin
    // “Home Services” yazisi icerdigini test edin
    //ØYeni bir method olusturun : AmazonYazisi() ve tabloda 9 Hucrede “Amazon” yazisi bulundugunu test edin

    //Soru 3 :
    //ØAmazon uzerine yapilan 4 testi otomatik olarak calistiracak xml kodunu yazin ve calistirin
    //ØD26_AmazonSatirSutunSayisi class’indan satirSayisi() testini ve D26_AmazonHucreTesti class’indan hucretesti()
    // testini calistiracak xml kodunu yazin ve calistirin


    @Test
    public void test(){
        Driver.getDriver().get("https://www.amazon.com");
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.getAction().sendKeys(Keys.END).perform();
    }

    @Test (groups = "grup1")
    public void satirSayisi(){
        // webtable’da 10 satir oldugunu test edin
        Driver.getDriver().get("https://www.amazon.com");
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.getAction().sendKeys(Keys.END).perform();

        int actualSatirSayisi=amazonPage.satirSayisi.size();
        System.out.println("Tablodaki satir Sayisi: "+actualSatirSayisi);
        int expectedSatirSayisi=10;

        Assert.assertEquals(actualSatirSayisi,expectedSatirSayisi);
        Driver.closeDriver();

    }
    @Test
    public void sutunSayisi(){
        // sutunSayisi() ve yazi olan sutun sayisinin 7 oldugunu test edin
        Driver.getDriver().get("https://www.amazon.com");
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.getAction().sendKeys(Keys.END).perform();

        int i=0;
        for(WebElement w:amazonPage.sutunNum){
            if(w.getText().equals("")){
                continue;
            }else{
                i++;
            }
        }
        int actualSutunSayisi=i;
        int expectedSutunSayisi=7;
        System.out.println("Tablodaki sutun Sayisi: "+i);

        //2. yol
       int actualSutunSayisi2= amazonPage.yaziliSutun.size(); //xpath olarak bulduk

        Assert.assertEquals(actualSutunSayisi,expectedSutunSayisi);
        Driver.closeDriver();
    }

    @Test (groups = "grup1")
    public void cellData(){
        //ØAmazonPage sayfasinda istedigim satir ve sutun sayisi ile cagirdigimda bana hucredeki
        // yaziyi getirecek bir method olusturun
        //amazon page'de methodu olsuturdum
        Driver.getDriver().get("https://www.amazon.com");
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.getAction().sendKeys(Keys.END).perform();

        String cellData=amazonPage.getCell(3,5);
        System.out.println(cellData);

        //webtable’da 3. satir 2.sutundaki yazinin “Home Services” yazisi icerdigini test edin
        String actualCellData=amazonPage.getCell(3,7);
        System.out.println("3.satir 2. sutun text:"+actualCellData);
        boolean isContains=actualCellData.contains("Home Services");

        ReusableMethods.waitFor(4);

        Assert.assertTrue(isContains);
        Driver.closeDriver();

    }
    @Test
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
