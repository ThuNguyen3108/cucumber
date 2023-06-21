package com.thutester.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class baseTest {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://dstest.vibe.fyi");
    }
    @AfterMethod
    public void takeScreenshotTearDown(ITestResult result) throws InterruptedException {
        //Khoi tao doi tuong result thuoc ITestResult de lay trang thai va ten cua tung step
        //O day se so sanh dieu kien neu testcase passed hoac failed
        //passed = SUCCESS va failed = FAILURE
        if(ITestResult.FAILURE == result.getStatus()){
            try{
                //Tao tham chieu cua TakesCreenshot voi driver hien tai
                TakesScreenshot ts = (TakesScreenshot) driver;
                //Goi ham capture screenshot - getScreenshotAs
                File source = ts.getScreenshotAs(OutputType.FILE);
                //Kiem tra folder ton tai. Neu khong thi tao moi folder
                File theDir = new File("./Screenshots/");
                if(!theDir.exists()){
                    theDir.mkdirs();
                }
                FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
                System.out.println("Đã chụp: " + result.getName());
                Thread.sleep(3000);
            }catch (IOException | InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        Thread.sleep(3000);
        //driver.quit();
    }
}
