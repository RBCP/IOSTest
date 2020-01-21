package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loginPage;
import utils.AppiumScreenShot;
import utils.Assertion;
import utils.TestListener;

import static org.testng.TestRunner.PriorityWeight.priority;

public class loginTest extends BaseTest{
    @Test
    public void InvalidLoginTest(){
        String testName=Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            loginPage loginPage1 = new loginPage();
            loginPage1.InputStaffId("M088163");
            loginPage1.InputPassword("1234567");
            loginPage1.clickLoginBtn();
            String actualText = loginPage1.getInvalidLoginToast();
            Assertion.verityText(actualText, "error:您输入的账号或密码有错误", driverName, sdkVersion);
            log.info("设备："+driverName+"测试用例："+testName+"用例通过");
            TestListener.mobileSuccessMessageList.add(driverName+"(版本："+sdkVersion+"）"+testName);
        }catch(Exception | Error e){
            AppiumScreenShot appiumScreenShot=new AppiumScreenShot(driver);
            appiumScreenShot.setScreenName(driverName,testName);
            appiumScreenShot.takeScreenShot();
            log.error("设备："+driverName+"测试用例："+testName+"用例失败");
            TestListener.messageList.add(driverName+"(版本："+sdkVersion+")"+testName);
            throw e;
        }
    }
    @Test
       public void validLoginTest(){
        String testName=Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            loginPage loginPage1 = new loginPage();
            loginPage1.InputStaffId("ITTEST03");
            loginPage1.InputPassword("123456789");
            loginPage1.clickLoginBtn();
            log.info("设备："+driverName+"测试用例："+testName+"用例通过");
            TestListener.mobileSuccessMessageList.add(driverName+"(版本："+sdkVersion+")"+testName);
        }catch(Exception | Error e){
            AppiumScreenShot appiumScreenShot=new AppiumScreenShot(driver);
            appiumScreenShot.setScreenName(driverName,testName);
            appiumScreenShot.takeScreenShot();
            log.error("设备："+driverName+"测试用例："+testName+"用例失败");
            TestListener.messageList.add(driverName+"(版本："+sdkVersion+"）"+testName);
            throw e;
        }
    }
    @Test
    public void emptyStaffIdTest(){
        String testName=Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            loginPage loginPage1 = new loginPage();
            loginPage1.InputStaffId("");
            loginPage1.InputPassword("lcl1702111");
            loginPage1.clickPolicyBtn();
            loginPage1.clickPrivacyBtn();
            loginPage1.clickLoginBtn();
            String actualText = loginPage1.getNullStaffToast();
            Assertion.verityText(actualText, "工号", driverName, sdkVersion);
            log.info("设备："+driverName+"测试用例："+testName+"用例通过");
            TestListener.mobileSuccessMessageList.add(driverName+"(版本："+sdkVersion+")"+testName);
        }catch(Exception | Error e){
            AppiumScreenShot appiumScreenShot=new AppiumScreenShot(driver);
            appiumScreenShot.setScreenName(driverName,testName);
            appiumScreenShot.takeScreenShot();
            log.error("设备："+driverName+"测试用例："+testName+"用例失败");
            TestListener.messageList.add(driverName+"(版本："+sdkVersion+"）"+testName);
            throw e;
        }

    }
    @Test
    public void emptyPasswordTest(){
        String testName=Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            loginPage loginPage1 = new loginPage();
            loginPage1.InputStaffId("M088163");
            loginPage1.InputPassword("");
            loginPage1.clickLoginBtn();
            String actualText = loginPage1.getNullPasswordToast();
            Assertion.verityText(actualText, "密码", driverName, sdkVersion);
            log.info("设备：" + driverName + "测试用例：" + testName + "用例通过");
            TestListener.mobileSuccessMessageList.add(driverName+"(版本："+sdkVersion+")"+testName);
        }catch(Exception | Error e){
            AppiumScreenShot appiumScreenShot=new AppiumScreenShot(driver);
            appiumScreenShot.setScreenName(driverName,testName);
            appiumScreenShot.takeScreenShot();
            log.error("设备："+driverName+"测试用例："+testName+"用例失败");
            TestListener.messageList.add(driverName+"(版本："+sdkVersion+"）"+testName);
            throw e;
        }

    }
}
