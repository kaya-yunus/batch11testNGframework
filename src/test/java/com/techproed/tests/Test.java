package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class Test {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @org.testng.annotations.Test
    public void test(){
        driver.get("https://www.amazon.com");
        WebElement dropDown= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        String a=dropDown.getText();

        Select drop=new Select(dropDown);
        drop.selectByIndex(0);
        System.out.println(drop.getFirstSelectedOption().getText());

      //  System.out.println(a);
    }
    @AfterClass
    public void tearDown(){

    }
}
