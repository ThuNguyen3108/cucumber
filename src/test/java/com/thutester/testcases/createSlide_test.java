package com.thutester.testcases;

import com.thutester.core.baseTest;
import com.thutester.pages.createSlide_page;
import com.thutester.pages.waitForLoading_page;
import org.testng.annotations.Test;

public class createSlide_test extends baseTest {
    @Test
    public void testCase1() throws InterruptedException {
        createSlide_page createSlidePage = new createSlide_page(driver);
        waitForLoading_page waitForLoadingPage = new waitForLoading_page(driver);
        createSlidePage.createSlide();
        boolean isSlideCreated = createSlidePage.verifySlideCreated();
        if (isSlideCreated) {
            System.out.println("Slide successful");
        } else {
            System.out.println("Not create slide");
        }
        String itemTitle1 = "Anh test 1";
        String itemSummary1 = "Test Summary";
        createSlidePage.addItem(itemTitle1, itemSummary1);
        Thread.sleep(5000);

        String itemTitle2 = "Anh test 2";
        String itemSummary2 = "Test Summary";
        createSlidePage.addItem(itemTitle2, itemSummary2);
        createSlidePage.verifyTwoItem();
    }

}