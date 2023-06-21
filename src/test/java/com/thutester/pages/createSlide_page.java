package com.thutester.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class createSlide_page {
    private static final Logger Log =  LogManager.getLogger(createSlide_page.class);
    private WebDriver driver;
    private login_page loginPage;

    private waitForLoading_page waitForLoadingPage;
    public By buttonCreatSlide = By.className("new-item-button");
    public By search = By.cssSelector("input[placeholder='Search']");

    public By image = By.xpath("//img[@alt='Noticeboard (Blocks)']");

    public By selectThisTemplate = By.xpath("//button[normalize-space()='Select this template']");

    public By enterSideTitle = By.xpath("//input[@id='text']");

    public By button_Create = By.cssSelector("button[type='submit']");

    public By verifyCreateSlide = By.xpath("//button[normalize-space()='Add to Playlists']");

    public By addItemButton = By.xpath("//div[@class='button-column']");
    public By dragImage = By.cssSelector("div[class='image-dnd-wrapper'] div[class='image-dnd-text1']");
    public By addImage = By.cssSelector("div.vibeImageManagerContainer.show:nth-child(3) div.vibeImageManager.iframe div.content div.listsWrapper:nth-child(4) div.vibeimImageListWrapper.listWrapper div.imageList.list div.vibeimImageWrapper:nth-child(1) > img.image");
    public By updateListItem = By.cssSelector("button[class='MuiButtonBase-root MuiButton-root MuiButton-contained vibeBtn btnComplete MuiButton-containedPrimary'] span[class='MuiButton-label']");
    public By titleAddItem = By.xpath("//input[@id='Title']");
    public By summary = By.cssSelector("#Summary");

    public By buttonSave = By.cssSelector("div.MuiDialog-root.create-list-item-modal:nth-child(6) div.MuiDialog-container.MuiDialog-scrollPaper:nth-child(3) div.MuiPaper-root.MuiDialog-paper.MuiDialog-paperScrollPaper.MuiDialog-paperWidthSm.MuiPaper-elevation24.MuiPaper-rounded div.MuiDialogActions-root.buttons-container.MuiDialogActions-spacing > button.primary.save-button");

    public By checkItem1 = By.cssSelector("body > form:nth-child(1) > div:nth-child(24) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(9) > main:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1)");

    public By checkItem2 = By.cssSelector("body > form:nth-child(1) > div:nth-child(24) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(9) > main:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1)");
    public By checkPreviewItem1 = By.cssSelector("body:nth-child(2) div.outerWrapper:nth-child(6) div.content div.contentWrapper > div.titlecontainer");
    public By checkPreviewItem2 = By.cssSelector("div.outerWrapper:nth-child(6) div.thumbContainer div.thumbWrapper:nth-child(3) div.title > p:nth-child(1)");

    public By vibeImageManagerIframe = By.id("vibeImageManagerIframe");

    public By previewIframe = By.xpath("//iframe[@id='PreviewIframe']");

    public createSlide_page(WebDriver driver) {
        this.driver = driver;
        loginPage = new login_page(driver);
        waitForLoadingPage = new waitForLoading_page(driver);
    }

    public void createSlide() {
        loginPage.login("anh.nguyen.quoc@tpssoft.com", "anh@Tps123");
        Log.info("Login Successful");
        // Click vào nút tạo slide
        waitForLoadingPage.verifyPageLoaded();
        Log.info("Wait For Loading Page Successful");
        driver.findElement(buttonCreatSlide).click();
        Log.info("Click button create Slide Successful");
        // Tìm và chọn template slide
        driver.findElement(search).sendKeys("Noticeboard (Blocks)");
        Log.info("Search Slide Successful");
        driver.findElement(image).click();
        Log.info("Select this template Successful");
        //driver.findElement(selectThisTemplate).click();
        // Nhập tiêu đề slide
        // waitForLoadingPage.verifyPageLoaded();
        driver.findElement(enterSideTitle).sendKeys("Anh Block");
        Log.info("Enter title Slide Successful");
        // Nhấp vào nút tạo slide
        driver.findElement(button_Create).click();
        Log.info("Click button Create Slide Successful");
    }
    public boolean verifySlideCreated() {
        // Kiểm tra xem slide đã được tạo thành công bằng cách kiểm tra phần tử "Add to Playlists"
        return driver.findElement(verifyCreateSlide).isDisplayed();
    }


    public void addItem(String itemTitle, String itemSummary) throws InterruptedException {
        //waitForLoadingPage.verifyPageLoaded();
        // Click vào nút thêm mục
        Thread.sleep(6000);
        driver.findElement(addItemButton).click();
        Log.info("Click button of successful item");
        // Kéo và thả hình ảnh
        driver.findElement(dragImage).click();
        Log.info("Drag image of successful item");
        driver.switchTo().frame(driver.findElement(vibeImageManagerIframe));
        driver.findElement(addImage).click();
        Log.info("Add image of successful item");
        // Nhập tiêu đề và tóm tắt mục
        driver.findElement(updateListItem).click();
        // Lưu mục
        Log.info("Update Item Successful");
        driver.switchTo().defaultContent();
        driver.findElement(titleAddItem).sendKeys(itemTitle);
        Log.info("Add title of successful item");
        driver.findElement(summary).sendKeys(itemSummary);
        Log.info("Add summary of successful item ");
        driver.findElement(buttonSave).click();
    }

    public void verifyTwoItem() throws InterruptedException {
        String checkStringItem1 = driver.findElement(checkItem1).getText();
        Log.info("Title item1 is : " + checkStringItem1);
        String checkStringItem2 = driver.findElement(checkItem2).getText();
        Log.info("Title item2 is : " + checkStringItem2);
        Thread.sleep(4000);
        driver.switchTo().frame(driver.findElement(previewIframe));
        String checkStringPreviewItem1 = driver.findElement(checkPreviewItem1).getText();
        Log.info("Title preview item1 is : " + checkStringPreviewItem1);
        String checkStringPreviewItem2 = driver.findElement(checkPreviewItem2).getText();
        Log.info("Title preview item2 is : " + checkStringPreviewItem2);
        driver.switchTo().defaultContent();
        if (checkStringItem1.equals(checkStringPreviewItem1)) {
            Log.info("The two items are the same");
        } else if (checkStringItem1.equals( checkStringPreviewItem2)) {
            Log.info("The two items are the same");
        } else {
            Log.info("Not found");
        }

        if (checkStringItem2.equals(checkStringPreviewItem1)) {
            Log.info("The two items are the same");
        } else if (checkStringItem2.equals(checkStringPreviewItem2)) {
            Log.info("The two items are the same");
        } else {
            Log.info("Not found");
        }

    }
}
