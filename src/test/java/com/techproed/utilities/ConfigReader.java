package com.techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    //ilk yapacagimiz is properties file'ini kullanmak Properties class'indan instance olarak obje olusturmak

   static private Properties properties; //static block icinde calismasi icin static olmali
                                         //Obje sadece bu class'ta kullanilacagindan private yapariz (onerilir) ama sart degil

    //2. olarak properties objesini kullanmak icin static block olusturuyoruz. Static block class icinde ilk olarak o calisir.

    static{

        String path="configuration.properties";
        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            properties=new Properties();
            properties.load(fileInputStream);

            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getProperty(String key){

        return properties.getProperty(key);
    }
}
