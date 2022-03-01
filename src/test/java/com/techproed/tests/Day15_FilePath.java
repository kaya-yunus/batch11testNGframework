package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day15_FilePath extends TestBase {

    @Test
    public void test01(){

        System.out.println(System.getProperty("user.dir")); //suan da calistigimiz projenin yolunu(path) getiriyor.
                                                            //icinde oldugumuz klasorun yolu

        System.out.println( System.getProperty("user.home"));//C:\Users\admin bilgisayarimizin ana govdesini veriyor.
                                                            //Hangi bilgisayarda isek o bilgisayarin ana path'ini verir.

        String anaPath=System.getProperty("user.home"); //C:\Users\admin

        String masaUstuPath=anaPath+"\\Desktop"; //bir slash problem yapiyor. iki tane yapmaliyiz ama bir tane aliyor.
        System.out.println(masaUstuPath);


    }
    @Test
    public void isExist(){

        //C:\Users\admin\Desktop\FLOWER.jpg

        //1. adim: bilgisayarimizin homePath'ini aliyoruz.
        String homePath=System.getProperty("user.home");

        //2. adim: homePath'in devamina dosya yolunu olusturacak sekilde ek yapiyoruz.
        //ONEMLI: Dosya adinda sonra uzantininda yazilmasi gerekir.
        String filePath=homePath+"\\Desktop\\FLOWER.jpg"; //ters slash otomatikman 2 tane oldu

        System.out.println(filePath);

        //masaustunde FLOWER.jpg dosyasinin var oldugunu test ediniz.

        //3. adim: dosyanin var olsugunu Files.exist() ile test edebiliriz

        Files.exists(Paths.get(filePath)); // dosyanin var veya yok oldugunu boolean olarak verir.
        boolean fileIsExist=Files.exists(Paths.get(filePath)); //atama yaptik
        System.out.println(fileIsExist);







    }

}
