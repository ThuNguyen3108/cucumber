package com.thutester.testcases;

import com.thutester.core.baseTest;
import com.thutester.pages.login_page;
import org.testng.annotations.Test;

public class login_test extends baseTest {

    @Test
    public void testCase1(){
        login_page loginPage = new login_page(driver);
        loginPage.login("anh.nguyen.quoc@tpssoft.com", "anh@Tps123");

    }
}
