package com.bsu.chernyak;

import com.bsu.chernyak.steps.Steps;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumWebDriverTest {
    private Steps steps;
    private final Logger logger = Logger.getLogger(SeleniumWebDriverTest.class);
    private final String USER_EMAIL = "marumaru";
    private final String PASSWORD = "q1q1q1";
    private final String USER_NAME = "marumaru";

    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "Login")
    public void oneCanLogin(){
        logger.info("-----oneCanLogin");
        steps.loginKinopoisk(USER_EMAIL, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USER_NAME));
    }


    @Test
    public void oneCanFind(){
        logger.info("-----oneCanFind");
        Assert.assertTrue(steps.movieWithTextFound("swift"));
    }

    @Test
    public void oneCanLike(){
        logger.info("-----oneCanLike");

    steps.loginKinopoisk(USER_EMAIL,PASSWORD);
        Assert.assertTrue(steps.likeMovie());
    }

    @Test
    public void oneCanDisLike(){
        logger.info("-----oneCanDisLike");

        steps.loginKinopoisk(USER_EMAIL,PASSWORD);
        Assert.assertTrue(steps.likeMovie());
    }


    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }

}
