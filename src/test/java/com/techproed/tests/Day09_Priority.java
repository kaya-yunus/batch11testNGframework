package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.ws.WebEndpoint;
import java.util.concurrent.TimeUnit;

public class Day09_Priority {
    /*
    1) Bir class oluşturun: YoutubeAssertions
    2) https://www.walmart.com adresine gidin
    3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri  yapin
        ○ titleTest  => Sayfa başlığının “Walmart.com | Save Money. Live Better.” oldugunu test edin
        ○ imageTest  => walmart resminin görüntülendiğini (isDisplayed()) test edin
        ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        ○ wrongTitleTest=> Sayfa basliginin “Walmart.com | Save Money” olmadigini dogrulayin
     */

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test(priority=4)
    public void titleTest() {
        driver.get("https://www.walmart.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Walmart.com | Save Money. Live Better.";

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test(priority=2)
    public void imageTest() {
        //○ imageTest  => walmart resminin görüntülendiğini (isDisplayed()) test edin
        driver.get("https://www.walmart.com");
        WebElement logo = driver.findElement(By.id("Shape2"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test(priority=1)
    public void searchBox() {
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        driver.get("https://www.walmart.com");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='global-search-input']"));
        Assert.assertTrue(searchBox.isEnabled());

    }


    @Test(priority=3)
    public void wrongTitle() {
        //○ wrongTitleTest=> Sayfa basliginin “Walmart.com | Save Money” olmadigini dogrulayin
        String actualTitle = driver.getTitle();
        String wrongTitle = "Walmart.com | Save Money";
        Assert.assertFalse(actualTitle.equals(wrongTitle));

    }


    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
