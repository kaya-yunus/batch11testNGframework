package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CKP2 {

    public CKP2(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Log in")
    public WebElement loginLink;

    @FindBy (xpath = "//span[@class='btn btn-primary py-3 px-5']")
    public WebElement createAccount;

    @FindBy (xpath = "//input[@id='UserName']")
    public WebElement username;

    @FindBy (xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy (xpath = "//input[@id='Email']")
    public WebElement emailText;

    @FindBy (xpath = "//input[@id='NameSurname']")
    public WebElement fullname;

    @FindBy (xpath = "//input[@id='PhoneNo']")
    public WebElement phoneNo;

    @FindBy (xpath = "//input[@id='SSN']")
    public WebElement ssn;

    @FindBy (xpath = "//input[@id='DrivingLicense']")
    public WebElement drivingLisance;

    @FindBy(xpath = "//select[@id='IDCountry']")
    public WebElement country;

    //@FindBy (xpath = "//select[@id='IDState']")






}
