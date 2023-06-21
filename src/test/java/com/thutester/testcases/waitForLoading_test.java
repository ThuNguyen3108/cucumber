package com.thutester.testcases;

import com.thutester.core.baseTest;
import com.thutester.pages.waitForLoading_page;
import org.testng.annotations.Test;

public class waitForLoading_test extends baseTest {
    @Test
    public void testCase1(){
        waitForLoading_page waitPage = new waitForLoading_page(driver);
        waitPage.waitForPageToLoad();
        boolean isPageLoaded = waitPage.verifyPageLoaded();
        if (isPageLoaded) {
            System.out.println("Trang đã được tải thành công");
        } else {
            System.out.println("Không thể tải trang");
        }
    }
}
