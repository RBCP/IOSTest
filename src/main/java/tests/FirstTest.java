package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loginPage;
import utils.Assertion;

public class FirstTest extends BaseTest{
    @Test(priority=3)
    public void ValidLoginTest(){
        loginPage loginPage1=new loginPage();
        loginPage1.InputStaffId("M088163");
        loginPage1.InputPassword("lcl1702111");
        loginPage1.clickPrivacyBtn();
        loginPage1.clickPolicyBtn();
        loginPage1.clickLoginBtn();
    }
    @Test(priority=1)
    public void emptyStaffIdTest(){
        loginPage loginPage1=new loginPage();
        loginPage1.InputPassword("lcl1702111");
        loginPage1.clickLoginBtn();
        String actualText=loginPage1.getNullStaffToast();
        Assertion.verityText(actualText,"工号",driverName,sdkVersion);

    }
    @Test(priority=2)
    public void emptyPasswordTest(){
        loginPage loginPage1=new loginPage();
        loginPage1.InputStaffId("M088163");
        loginPage1.clickLoginBtn();
        String actualText=loginPage1.getNullPasswordToast();
        Assertion.verityText(actualText,"密码",driverName,sdkVersion);
    }
}
