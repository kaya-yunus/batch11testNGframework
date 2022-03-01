package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    //Yeni bir Class olusturalim WriteExcel
    //Yeni bir test method olusturalim writeExcel()
    //Adimlari takip ederek 1.satira kadar gidelim
    //4.hucreye yeni bir cell olusturalim
    //Olusturdugumuz hucreye “Nufus” yazdiralim
    //2.satir nufus kolonuna 1500000 yazdiralim
    //10.satir nufus kolonuna 250000 yazdiralim
    //15.satir nufus kolonuna 54000 yazdiralim
    //Dosyayi kaydedelim
    //Dosyayi kapatalim
    //10:30
    //WriteExcel
    @Test
    public void writeExcelTest01() throws IOException {

        //nufus sutunu eklemek istiyoruz
        String path=".\\src\\test\\java\\resources\\ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        workbook.getSheetAt(0).getRow(0).createCell(4).setCellValue("Nufus"); //bu ekleme selenium'da oldu bunu excel'de islememiz gerekiyor.
                                                                                      //onun icin fileoutpustream

        //excel'e ekleme yapacagimdan fileoutputStream objesi olusturuyorum

        ////2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheetAt(0).getRow(1).createCell(4).setCellValue("1500000");

        //10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheetAt(0).getRow(9).createCell(4).setCellValue("250000");

        //15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheetAt(0).getRow(14).createCell(4).setCellValue("54000");

        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);


        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();

    }
}
