package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SlidePage {
    private static final Logger Log =  LogManager.getLogger(SlidePage.class);
    private WebDriver driver;
    private LoginPage loginPage;

    private WaitForLoadingPage waitForLoadingPage;

    @FindBy(xpath = "//button[normalize-space()='Create New Slide']")
    public WebElement  buttonCreatSlide;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement search;

    @FindBy(xpath = "//img[@alt='Noticeboard (Blocks)']")
    public WebElement image;


    @FindBy(xpath = "//input[@id='text']")
    public WebElement enterSlideTitle;

    @FindBy(css = "button[type='submit']")
    public WebElement button_Create;

    @FindBy(xpath = "//button[normalize-space()='Add to Playlists']")
    public WebElement verifyCreateSlide;

    @FindBy(xpath = "//div[@class='button-column']")
    public WebElement addItemButton;

    @FindBy(css = "div[class='image-dnd-wrapper'] div[class='image-dnd-text1']")
    public WebElement dragImage;

    @FindBy(xpath = "//div[@class='listsWrapper']//div[1]//img[1]")
    public WebElement addImage;

    @FindBy(xpath = "//span[normalize-space()='Update List Item']")
    public WebElement updateListItem;

    @FindBy(xpath = "//input[@id='Title']")
    public WebElement titleAddItem_Field;

    @FindBy(css = "#Summary")
    public WebElement summaryAddItem_Field;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    public WebElement buttonSave;

    @FindBy(xpath = "//div[@class='list-item-title'][text()='Anh Item Title 1']")
    public WebElement checkItem1;

    @FindBy(xpath = "//div[@class='list-item-title'][text()='Anh Item Title 2']")
    public WebElement checkItem2;

    @FindBy(xpath = "(//div[contains(text(),'Anh Item Title 1')])[1]")
    public WebElement checkPreviewItem1;

    @FindBy(xpath = "(//p[contains(text(),'Anh Item Title 2')])[2]")
    public WebElement checkPreviewItem2;

//    @FindBy(xpath = "//button[@title='Refresh preview']//span[@class='MuiButton-label']")
//    public WebElement buttonRefreshPreview;

    @FindBy(id = "vibeImageManagerIframe")
    public WebElement vibeImageManagerIframe;



    @FindBy(xpath = "//iframe[@id='PreviewIframe']")
    public WebElement previewIframe;

    public SlidePage() {
    }

    public SlidePage(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        waitForLoadingPage = new WaitForLoadingPage(driver);
        PageFactory.initElements(driver,this);
    }


    public void button_CreatSlide() throws InterruptedException {
        waitForLoadingPage.verifyPageLoaded();
        Thread.sleep(7000);
        Log.info("Wait For Loading Page Successful");
        buttonCreatSlide.click();
        Log.info("Click button create Slide Successful");
    }

    public void Enter_TitleTemplateSlide(String titleTemplateSlide){
        search.sendKeys(titleTemplateSlide);
        Log.info("Enter Title Slide Successful");
    }

    public void Select_ThisTemplate(){
        image.click();
        Log.info("Select this template Successful");
    }

    public void Enter_TitleSlide(String titleSlide){
        enterSlideTitle.sendKeys(titleSlide);
        Log.info("Enter title Slide Successful");
    }

    public void Button_CreatSlideTemplate(){
        button_Create.click();
        Log.info("Click button Create Slide Successful");
    }

    public void verifyCreateSlide(){
        verifyCreateSlide.isDisplayed();
        Log.info("Verify Create Slide Successful");
    }


    public void setAddItemButton() throws InterruptedException {
        Thread.sleep(6000);
        addItemButton.click();
        Thread.sleep(10000);
        Log.info("Click button of successful item");
    }

    public void setDragImageOfItem(){
        dragImage.click();
        Log.info("Drag image of successful item");
    }

    public void addImageOfItem(){
        driver.switchTo().frame(vibeImageManagerIframe);
        addImage.click();
        Log.info("Add image of successful item");
    }

    public void setUpdateListItem(){
        updateListItem.click();
        Log.info("Update Item Successful");
        driver.switchTo().defaultContent();
    }

    public void enter_titleAddItem(String titleAddItem){
        titleAddItem_Field.sendKeys(titleAddItem);
        String valueTitleAddItem_Field = titleAddItem_Field.getAttribute("value");
        Log.info("Add title of successful item: " + valueTitleAddItem_Field);
    }


    public void enter_summaryAddItem(String summaryAddItem){
        summaryAddItem_Field.sendKeys(summaryAddItem);
        Log.info("Add summary of successful item " + summaryAddItem_Field.getAttribute("value"));
    }



    public void setButtonSave(){
        buttonSave.click();
        Log.info("Save Item Successful");
    }


//    public void buttonRefreshPreview(){
//        buttonRefreshPreview.click();
//    }

    public void verifyIem1Success() throws InterruptedException {
        String checkStringItem1 = checkItem1.getText();
        driver.switchTo().frame(previewIframe);
        String checkStringPreviewItem1 = checkPreviewItem1.getText();
        Thread.sleep(15000);
//        buttonRefreshPreview.click();
        String checkStringPreviewItem2 = checkPreviewItem1.getText();
        Log.info("Title item1 is: " + checkStringItem1);
        Log.info("Title preview item1 is: " + checkStringPreviewItem1);
        Log.info("Title preview item2 is: " + checkStringPreviewItem2);
        driver.switchTo().defaultContent();

        if (checkStringItem1.equals(checkStringPreviewItem1) || checkStringItem1.equals(checkStringPreviewItem2)) {
            Log.info("Verification: Passed");
        } else {
            Log.info("Verification: Failed");
        }
    }

    public void verifyIem2Success() throws InterruptedException {
        String checkStringItem2 = checkItem2.getText();
        driver.switchTo().frame(previewIframe);
        String checkStringPreviewItem1 = checkPreviewItem2.getText();
        Thread.sleep(15000);
        //buttonRefreshPreview.click();
        String checkStringPreviewItem2 = checkPreviewItem2.getText();
        Log.info("Title item2 is: " + checkStringItem2);
        Log.info("Title preview item1 is: " + checkStringPreviewItem1);
        Log.info("Title preview item2 is: " + checkStringPreviewItem2);
        driver.switchTo().defaultContent();

        if (checkStringItem2.equals(checkStringPreviewItem1) || checkStringItem2.equals(checkStringPreviewItem2)) {
            Log.info("Verification: Passed");
        } else {
            Log.info("Verification: Failed");
        }
    }


    public void verifyCreateAndAddSlideItemSuccess() throws InterruptedException {
        button_CreatSlide();
        Enter_TitleTemplateSlide("Noticeboard (Blocks)");
        Select_ThisTemplate();
        Enter_TitleSlide("Anh Title");
        Button_CreatSlideTemplate();
        verifyCreateSlide();
        setAddItemButton();
        setDragImageOfItem();
        addImageOfItem();
        setUpdateListItem();
        enter_titleAddItem("Anh Item Title 1");
        enter_summaryAddItem("Anh Item Summary 1");
        setButtonSave();
        setAddItemButton();
        setDragImageOfItem();
        addImageOfItem();
        setUpdateListItem();
        enter_titleAddItem("Anh Item Title 2");
        enter_summaryAddItem("Anh Item Summary 2");
        setButtonSave();
        verifyIem1Success();
        verifyIem2Success();
    }
}

