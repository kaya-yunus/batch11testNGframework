package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Day18_WebTables extends TestBase {

    /*
    Bir class oluşturun : D18_WebTables
● login() metodun oluşturun ve oturum açın.
● http://qa-environment.crystalkeyhotels.com/admin/HotelRoomAdmin adresine gidin ○ Username : manager2
 ○ Password : Man1ager2!
● table() metodu oluşturun
Tum body'i yazdirin
 ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
 ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.

 ● printRows() metodu oluşturun //tr
 ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
 ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
 ○ 4.satirdaki(row) elementleri konsolda yazdırın.

 ● printCells() metodu oluşturun //td
 ○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
 ○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.

 ● printColumns() metodu oluşturun
 ○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
 ○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
 ○ 5.column daki elementleri konsolda yazdırın.

//1. Bir metod oluşturun : printData(int row, int column);
a. Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
 hücredeki(cell) veriyi yazdırmalıdır.
     */

    public void login(){
        driver.get("http://qa-environment.crystalkeyhotels.com/admin/HotelRoomAdmin");
        WebElement userNameBox= driver.findElement(By.name("UserName"));
        userNameBox.sendKeys("manager");
        WebElement passwordBox= driver.findElement(By.id("Password"));
        passwordBox.sendKeys("Manager2!");

        WebElement loginBox= driver.findElement(By.xpath("//button[@class='btn btn-success uppercase']"));
        loginBox.click();
    }
    @Test
    public void table(){
        login();
        WebDriverWait wait=new WebDriverWait(driver,20);

        //Tum body'i yazdirin

        //table body'si tek bir webelement olarak locate edilebilir ve get text ile yazdirildiginda bosy'de bulunan tum datalari yazdirir.
        //Fakat bu datalar uzerinde ben manipulation yapamam

        WebElement tbody=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody")));
        System.out.println(tbody.getText());

        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /header'lardan yola ciktik
        //Sutun sayisini bulmak icin sayfadaki thead icindeki headers (basliklari) saymamiz yeterlidir.
        //Bunun icin bir list olusturup bu liste xpath olarak //theader//th yazip basliklari aldik
        List<WebElement>basliklarListesi= driver.findElements(By.xpath("//thead//th"));
        System.out.println("Tablodaki sutun sayisi: "+basliklarListesi.size());

        //Basliklari yazdiralim
        for (WebElement w:basliklarListesi){
            System.out.println(w.getText());
        }

    }
    @Test
    public void printRows() throws InterruptedException {
        // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        login();
        Thread.sleep(5);
        List<WebElement> satirSayisi= driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satir sayisi: "+satirSayisi.size());

        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement w:satirSayisi){
            System.out.println(w.getText());
        }

        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println(satirSayisi.get(3).getText());
        WebElement satir4= driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println(satir4.getText());

    }
    @Test
    public void printCells() {
        //○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        login();
        List<WebElement> tableCells = driver.findElements(By.xpath("//tbody//tr//td"));
        System.out.println(tableCells.size());

        //○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        for (WebElement w : tableCells) {
            System.out.print(w.getText() + " ");
        }
    }
        @Test
        public void printColums() {

        login();
        // ○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
            List<WebElement>sutunSayisi= driver.findElements(By.xpath("//thead//tr[1]//th"));
            System.out.println(sutunSayisi.size());

            // ○ 5.column daki elementleri konsolda yazdırın.

            List<WebElement> sutun5 = driver.findElements(By.xpath("//tbody//td[5]"));
            for (WebElement w: sutun5) {
                System.out.println(w.getText());
            }

            System.out.println("======================");
            //// ○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
            for(int i=1; i<=sutunSayisi.size(); i++){
                List<WebElement> sutunlar = driver.findElements(By.xpath("//tbody//td["+i+"]"));
                System.out.print(sutunSayisi.get(i-1).getText()+": ");
                for (WebElement w: sutunlar) {
                    System.out.print(w.getText()+" ");
                }
                System.out.println();
            }
    }
    @Test
    public void test01(){
        //3. sutun basligi yazdir
        login();
       for(int i=1; i<=9; i++) {
           WebElement baslik3 = driver.findElement(By.xpath("//thead//th["+i+"]"));
           System.out.print(baslik3.getText()+" ");
       }
    }
    public String printData(int satir, int sutun){
        //1. Bir metod oluşturun : printData(int row, int column);
        // a. Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
        // hücredeki(cell) veriyi yazdırmalıdır.
        WebElement yazdirilacakCell= driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));

        return yazdirilacakCell.getText();


        /*
        for(int i=1; i<=satirlar.size(); i++){
            for(int k=1; k<=sutunlar.size(); k++){
                WebElement yazdirilacakCell= driver.findElement(By.xpath("//tbody//tr["+i+"]//td["+k+"]"));
                System.out.println(yazdirilacakCell.getText());
            }
        }

         */
    }
    @Test
    public void printDataTest(){
        //2. Baska bir Test metodu oluşturun: printDataTest();
        // a. Ve bu metodu printData() methodunu cagirmak icin kullanin.
        // b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
        login();
        System.out.println(printData(3,5));

        //c. yazdirilan datanin olmasi gereken dataya esit oldugunu test edin
        //yazdirilanin double oldugunu test et
        String yazdirilanData=printData(3,5);
        Assert.assertEquals(yazdirilanData,"NewYork");




    }
}
