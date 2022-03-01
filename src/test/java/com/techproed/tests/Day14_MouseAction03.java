package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day14_MouseAction03 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //amazonda create a list'e tiklayin. "Your Lists" yazdigini test edin
        driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
        WebElement amazonLink= driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(amazonLink).perform();
        Thread.sleep(3000);
        WebElement createAlIst= driver.findElement(By.linkText("Create a List"));
        actions.click(createAlIst).perform();

        WebElement text= driver.findElement(By.xpath("//div[@role='heading']"));
        //System.out.println(text.getText());
        String actualText= text.getText();
        String expectedText="Your Lists";

        Assert.assertEquals(actualText,expectedText);

    }
}
