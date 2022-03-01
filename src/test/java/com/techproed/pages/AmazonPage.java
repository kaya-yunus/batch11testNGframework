package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonPage {

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//tbody//tr") //findElements() yeride de kullanilir.
    public List<WebElement> satirSayisi;

    @FindBy(xpath = "//tbody//tr[1]//td")
    public List<WebElement>sutunNum;

    @FindBy(xpath = "//tbody//tr[1]//td[@class='navFooterDescItem']")
    public List<WebElement>yaziliSutun;

    @FindBy (xpath = "//tbody//td")
    public List<WebElement>cellNum;


    public Actions getAction(){
        Actions actions=new Actions(Driver.getDriver());
        return actions;
    }

    public String getCell(int satir, int sutun){
        List<WebElement>satirSutun= Driver.getDriver().findElements(By.xpath("//tbody//tr[1]//td"));
        String cellData="";

        WebElement cellVeri = Driver.getDriver().findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));

        return cellData=cellVeri.getText();
    }
}
