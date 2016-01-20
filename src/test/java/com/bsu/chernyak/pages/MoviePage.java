package com.bsu.chernyak.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoviePage extends Page {
    private final String BASE_URL = "http://www.kinopoisk.ru/film/333/";
    private final Logger logger = Logger.getLogger(MoviePage.class);

    @FindBy(xpath = "//a[@id='btn_fav_film']")
    private WebElement likeButton;

    @FindBy(xpath = "//li//div[@class='num']")
    private WebElement likeNumber;



    public MoviePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean like(){

       int likesCounter1=Integer.parseInt(likeNumber.getText());
        likeButton.click();
        return likesCounter1 <= Integer.parseInt(likeNumber.getText());
    }

    public boolean disLike(){

        int likesCounter1=Integer.parseInt(likeNumber.getText());
        likeButton.click();
        return likesCounter1 >= Integer.parseInt(likeNumber.getText());
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }

}
