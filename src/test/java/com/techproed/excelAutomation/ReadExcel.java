package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadExcel {

    @Test
    public void readExcelTest() throws IOException { //input aoutput ile ilgili en genis exception IO Exception

        //1. adim fileInputStream. Java ile dosya okuyabilmek icin FileInputStream kullaniyoruz. Ancak bunun
        // icin okuyacagimiz dosyanin path'ine ihtiyacimiz var. Dosyanin Path'ini bulup String path degiskenine
        // atiyoruz. Bu path'i fileinputstream objesine parametre olarak ekliyoruz.
        String path=".\\src\\test\\java\\resources\\ulkeler.xlsx"; //src'den oncesine nokta koyuyoruz ve siliyoruz.
        FileInputStream fileInputStream=new FileInputStream(path);

        //2. adim: workbook objesi olusturuyoruz. Excel'de dosyaya ulasmak icin cell(hucre)'ye ulasmamiz gerekiyor.
        //Bunun icin sirasiyla workbook olusturup parametre olarak fileinputstream objesini giriyoruz.
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //3. adim: sheet objesi olusturuyorum
        Sheet sheet=workbook.getSheetAt(0);

        //4.adim:row'a gidiyoruz
        Row row=sheet.getRow(0);

        //5.adim cell seciyoruz
        Cell cell=row.getCell(0);

        //ulastigimiz data cell objesi formatindadir. Yazdirmak istedigimizde yazdirabiliriz. Ancak manipule edemeyiz.
        //Data uzerinde assert veya manipulasyon yapmak istiyorsak once datayi toString methodu ile String'e ceviririz.
        System.out.println(cell);
        String cellString=cell.toString();  //cell String degildir. kendi bir return type'dir. toString yapmaliyim
        System.out.println(cellString);

    }

    @Test
    public void readExcelTest2() throws IOException {
        //Yeni bir test method olusturalim readExcel2()
        //        - 1.satirdaki 2.hucreye gidelim ve yazdiralim
        //        - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        //        - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        //        - Satir sayisini bulalim
        //        - Fiziki olarak kullanilan satir sayisini bulun
        //        - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

       //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        String path=".\\src\\test\\java\\resources\\ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook=WorkbookFactory.create(fileInputStream);
        Sheet sheet=workbook.getSheetAt(0);
        Row row=sheet.getRow(0);
        Cell cell=row.getCell(1);
        String cell2=cell.toString();
        System.out.println(cell2);

        //ikinci yol
        // 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String actualCell=workbook.getSheetAt(0).getRow(1).getCell(3).toString();
        String expectedCell="Kabil";
        Assert.assertEquals(actualCell,expectedCell);

        //- Satir sayisini bulalim
        int rowNum=workbook.getSheetAt(0).getFirstRowNum();
        System.out.println(rowNum);
        int sonRow=workbook.getSheetAt(0).getLastRowNum();
        System.out.println(sonRow);
        int satirSayisi=workbook.getSheetAt(0).getPhysicalNumberOfRows();
        System.out.println(satirSayisi);

        //fiziki olarak kullanilan satir sayisi (index degil normal olarak sayar)
        System.out.println(workbook.getSheetAt(1).getLastRowNum()); //index'e gore verir
        System.out.println(workbook.getSheetAt(1).getPhysicalNumberOfRows()); //kullanilan satir sayisini verir index ile degil normal verir

        //Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        //herbir ulke icin dolayisiyla herbir satir icin 0. index ulke adi, 1. index baskent adi oluyor.
        int rowNumber=workbook.getSheetAt(0).getLastRowNum();
        String countryName="";
        String capitalName="";
        Map<String, String>capitals=new HashMap<>();
        for(int i=1; i<=rowNumber; i++){
            countryName=workbook.getSheetAt(0).getRow(i).getCell(0).toString();
            capitalName=workbook.getSheetAt(0).getRow(i).getCell(1).toString();
            capitals.put(countryName,capitalName); //butun datayi map icine aldik.
        }
        System.out.println(capitals); //map'i yazdirdi. hashmap siralama yapmaz
        //1=Afghanistan,Kabul,Afganistan,Kabil key value yapabilirim

        //



    }
}
