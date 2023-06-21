package com.thutester.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login_page {
    private WebDriver driver;
    public By username = By.id("ctl01_cPC_ctl00_UserName");
    public By password = By.id("ctl01_cPC_ctl00_Password");
    public By submit = By.id("ctl01_cPC_ctl00_ibLogin");
    public By verify = By.id("ctl01_Logo_ctl00_ibBannerImage");

    public login_page(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String name, String pass) {
        // Nhập thông tin đăng nhập
        driver.findElement(username).sendKeys(name);
        driver.findElement(password).sendKeys(pass);
        // Submit đăng nhập
        driver.findElement(submit).click();
    }
}
