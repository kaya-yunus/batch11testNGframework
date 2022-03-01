package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Driver { //inheritance kullanmayacagimdan static yapiyorum

    //Singleton class: Obje olusturulmasi kontrol altina alinan (genelde izin verilmeyen) class.
    //default constructor'i private yapariz. Boylece bu class'tan obje olusturulamaz.

    private Driver(){ //artik baska class'lardan bu class'in objesi olusturamaz.

    }

   static WebDriver driver; //private yapabiliriz

   static public WebDriver getDriver(){ //static oldugu icin parametresiz yazariz gerek yok parametreye

       if(driver==null) { //daha once buna bir atama yapildi mi chrome, firefox gibi
           switch(ConfigReader.getProperty("browser")){
               case "chrome":
                   WebDriverManager.chromedriver().setup();
                   driver = new ChromeDriver();
                   break;
               case "firefox":
                   WebDriverManager.firefoxdriver().setup();
                   driver=new FirefoxDriver();
                   break;
               case "edge":
                   WebDriverManager.edgedriver().setup();
                   driver=new EdgeDriver();
                   break;
               case "opera":
                   WebDriverManager.operadriver().setup();
                   driver=new OperaDriver();
                   break;
           }
       }

      // driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       return driver;

   }

   static public void closeDriver(){
       if(driver!=null){
           driver.close();
       }
       driver=null;
   }
}
