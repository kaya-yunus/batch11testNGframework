package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignUpPage {

    public GlbSignUpPage(){
        PageFactory.initElements(Driver.getDriver(), this); //bu yeterli olur driver class'tan cagircam
    }

    @FindBy (id = "email")
    public WebElement emailTextBox;

    @FindBy (xpath = "//input[@id='name']")
    public WebElement nameTextBox;

    @FindBy (xpath = "//input[@id='mobile']")
    public WebElement phoneTextBox;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement passwordTextBox;

    @FindBy (id = "re_password")
    public WebElement confirmPassword;

    @FindBy (xpath = "(//button[@name='submit'])[1]")
    public WebElement signUpButon;






}
