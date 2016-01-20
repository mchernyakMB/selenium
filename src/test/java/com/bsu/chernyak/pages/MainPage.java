package com.bsu.chernyak.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends Page{
    private final Logger logger = Logger.getLogger(MainPage.class);
    private final String BASE_URL = "http://www.kinopoisk.ru/";


    @FindBy(xpath = "//input[@id='search_input']")
    private WebElement inputSearch;

    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage(){
        driver.navigate().to(BASE_URL);
    }


    public void searchText(String text){
        inputSearch.sendKeys(text);
        inputSearch.sendKeys(Keys.ENTER);
    }

    public boolean movieIsFound(){
        String text = "К сожалению, по вашему запросу ничего не найдено...";
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" +text +"')]"));
        return(list.size()==0);
    }


}
