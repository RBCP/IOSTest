package tests;

import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.loginPage;
import utils.BaseDriver;

public class FirstTest extends BaseTest{
    @Test
    public void LoginTest(){
        loginPage loginPage1=new loginPage();
        loginPage1.InputStaffId("M088163");
        loginPage1.InputPassword("lcl1702111");
        loginPage1.clickPrivacyBtn();
        loginPage1.clickLoginBtn();
    }
}
