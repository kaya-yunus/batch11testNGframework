package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrsytalHotelPage {

    public WebDriver driver; //bu sayfada locate islemlerini yapabilmek icin driver objesi olusturdum

    public CrsytalHotelPage(WebDriver driver){
        this.driver=driver;

        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Log in")
    public WebElement loginLink;

    @FindBy(id = "UserName")
    public WebElement usernameTextBox;

    @FindBy(id="Password")
    public WebElement passwordBox;

    @FindBy(id="btnSubmit")
    public WebElement loginButton;

    @FindBy(xpath = "//*[.='System Management']")
    public WebElement systemManagentmenu;


}
