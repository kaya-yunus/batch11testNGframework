package com.techproed.tests;

import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day35_ExplicitlyWait {

    //https://demoqa.com/browser-windows adresine gidin
    //Alerts’e tiklayin
    //On button click, alert will appear after 5 seconds karsisindaki click me butonuna basin
    //Allert’in gorunur olmasini bekleyin
    //Allert uzerindeki yazinin “This alert appeared after 5 seconds” oldugunu test edin
    //Ok diyerek alerti kapatin



    @Test
    public void demoqaTest() throws InterruptedException {
        Actions actions=new Actions(Driver.getDriver());
        Driver.getDriver().get("https://demoqa.com/browser-windows");
        //Alerts’e tiklayin
        WebElement alertsFrame=Driver.getDriver().findElement(By.xpath("(//div[@class='header-text'])[3]"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        WebElement alertsLink=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Alerts']")));
        alertsLink.click();

        //On button click, alert will appear after 5 seconds karsisindaki click me butonuna basin
        WebElement clickMe5second=Driver.getDriver().findElement(By.xpath("//button[@id='timerAlertButton']"));
        clickMe5second.click();

        ////Allert’in gorunur olmasini bekleyin
        //Driver.getDriver().switchTo().alert();

         wait.until(ExpectedConditions.alertIsPresent());


        ////Allert uzerindeki yazinin “This alert appeared after 5 seconds” oldugunu test edin
        String actualAlertText= Driver.getDriver().switchTo().alert().getText();
        String expectedAlertText="This alert appeared after 5 seconds";
        Assert.assertEquals(actualAlertText,expectedAlertText);
        Driver.getDriver().switchTo().alert().accept();

    }
    @Test
    public void demoqaTest02(){
        //https://demoqa.com/dynamic-properties adresine gidin
        Driver.getDriver().get("https://demoqa.com/dynamic-properties");
        //“Will enable 5 seconds” butonunun enable olmasini bekleyin
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        WebElement enable5seconds=wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));

        //“Will enable 5 seconds” butonunun enable oldugunu test edin
        Assert.assertTrue(enable5seconds.isEnabled());
        enable5seconds.click();

    }
    @Test
    public void test3(){
        //visibleAfter
        //https://demoqa.com/dynamic-properties adresine gidin
        Driver.getDriver().get("https://demoqa.com/dynamic-properties");
        //“Visible After 5 seconds” butonunun gorunur olmasini bekleyin
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);
        WebElement visibleAfter=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        //“Visible After 5 seconds” butonunun gorunur oldugunu test edin
        Assert.assertTrue(visibleAfter.isDisplayed());
    }

    @Test
    public void test4()  {
        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/add_remove_elements/");
        //“Add Element” butona basin
        Driver.getDriver().findElement(By.xpath("//*[.='Add Element']")).click();
        //“Delete” butonu gorunur oluncaya kadar bekleyin
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(),20);
        WebElement deletebuton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='added-manually']")));
        //“Delete” butonunun gorunur oldugunu test edin
        Assert.assertTrue(deletebuton.isDisplayed());
        //Delete butonuna basarak butonu silin
         deletebuton.click();
        //Delete butonunun gorunmedigini test edin
         //delete butonu silindigi icin bu webelemente ulasilamaz, dolayisiyla da test yapilamaz
        //StaleElementReferenceException hatasi verir
        try {
            Assert.assertFalse(deletebuton.isDisplayed());
        }catch (Exception e){
            System.out.println("Delete webelementi gorunmuyor");
        }

    }



}

