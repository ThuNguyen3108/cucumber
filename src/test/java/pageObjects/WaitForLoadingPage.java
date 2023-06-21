package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForLoadingPage {
    private WebDriver driver;
    private LoginPage loginPage;
    public By iconLoad = By.xpath("//div[@class='vibeimLoadingIndicator']");
    public By verify = By.xpath("//button[contains(text(),'Create New Slide')]");

    public WaitForLoadingPage(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }

    public void waitForPageToLoad() {
        loginPage.login("anh.nguyen.quoc@tpssoft.com", "anh@Tps123");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(iconLoad));
    }

    public boolean verifyPageLoaded() {
        return driver.findElement(verify).isDisplayed();
    }

    //Chờ đợi đến khi trang load xong thì sẽ thực hiện các hành động sau đó
//    public void waitForPageLoaded(){
//        ExpectedConditions<Boolean> expectation = new
//                ExpectedCondition<Boolean>(){
//                    public Boolean apply(WebDriver driver){
//                        return ((JavascriptException) driver).executeScript("return document.readyState").toString().equals("complete");
//
//                    }
//                };
//        try{
//            Thread.sleep(1000);
//            WebDriverWait wait = new WebDriverWait(driver, 30);
//            wait.until(expectation);
//        }catch (Throwable error){
//            Assert.fail("Time out waiting for Page Load Request to complete");
//        }
//    }
}
