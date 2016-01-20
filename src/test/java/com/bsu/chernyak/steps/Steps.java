package com.bsu.chernyak.steps;

import com.bsu.chernyak.pages.LoginPage;
import com.bsu.chernyak.pages.MainPage;
import com.bsu.chernyak.pages.MoviePage;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Steps {
    private final Logger logger = Logger.getLogger(Steps.class);
    private WebDriver driver;
    private int previousPinsNumber=0;
    private int currentPinsNumber=0;

    public void initBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logger.info("Browser started");
    }

    public void closeDriver(){
        driver.quit();
        logger.info("Browser stoped");
    }

    public void loginKinopoisk(String email, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(email,password);
        logger.info("Login");
    }

    public boolean isLoggedIn(String username)
    {
        LoginPage loginPage = new LoginPage(driver);

        return (loginPage.getLoggedInUserName().contains(username));
    }
    public boolean movieWithTextFound(String text){
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.searchText("Звездные войны");
        return mainPage.movieIsFound();


    }

    public boolean likeMovie(){
        MoviePage moviePage = new MoviePage(driver);
        moviePage.openPage();
        return moviePage.like();
    }
    public boolean disLikeMovie(){
        MoviePage moviePage = new MoviePage(driver);
        moviePage.openPage();
        return moviePage.disLike();
    }


}
