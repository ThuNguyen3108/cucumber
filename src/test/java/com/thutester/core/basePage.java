package com.thutester.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class basePage {
    public WebDriver driver;
    public static WebDriverWait wait;

    public basePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Khoi tao class khi duoc goi voi driver
        //Va khoi tao initElements tu Page Factory
        PageFactory.initElements(driver, this);
    }
}