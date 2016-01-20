package com.bsu.chernyak.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {
    private final String BASE_URL = "http://www.kinopoisk.ru/login/";

    @FindBy(xpath = "//input[@id='shop_user_login']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='shop_user_pass']")
    private WebElement inputPassword;

    @FindBy(xpath = "//form[@id='login']//input[@class='button nice_button']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//div[@id='perechenlogin']//a[2]")
    private WebElement linkLoggedInUser;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }

    public void login(String userEmail, String password)
    {
        inputEmail.sendKeys(userEmail);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
    }

    public String getLoggedInUserName()
    {
        return linkLoggedInUser.getText();
    }

}
