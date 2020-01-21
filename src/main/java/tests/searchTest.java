package tests;

import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.comChatPage;
import pages.loginPage;
import pages.screenPasscodePage;
import pages.searchPage;
import utils.AppiumScreenShot;
import utils.TestListener;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class searchTest extends BaseTest{
    private static loginPage loginPage1;
    private static screenPasscodePage screenPasscodePage1;
    private static comChatPage comChatPage1;
    private static searchPage searchPage1;
    @BeforeClass
    public void validLogin() throws InterruptedException{
        loginPage1=new loginPage();
        loginPage1.clickPolicyBtn();
        loginPage1.clickPrivacyBtn();
        loginPage1.InputStaffId("M088163");
        loginPage1.InputPassword("lcl1702111");
        loginPage1.clickLoginBtn();
        screenPasscodePage1=new screenPasscodePage();
        for(int i=0;i<6;i++)
            screenPasscodePage1.clickKeyboard(6);
        screenPasscodePage1.clickNextStepBtn();
        for(int i=0;i<6;i++)
            screenPasscodePage1.clickKeyboard(6);
        screenPasscodePage1.clickSaveBtn();
        for(int i=0;i<6;i++)
        screenPasscodePage1.clickKeyboard(6);
        Thread.sleep(15000);
    }
    @Test
    public void searchContactTest() throws InterruptedException{
        String testName=Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            comChatPage1 = new comChatPage();
            searchPage1 = comChatPage1.clickSearchBtn();
            searchPage1.clickSearchContactBtn();
            searchPage1.inputSearchContactText("ITTEST");
            searchPage1.clickSearchBtn();
            String userName=searchPage1.getSearchContactResultText();
            System.out.println(userName);
            searchPage1.clickCancelBtn();
            MatcherAssert.assertThat(userName,containsString("ITTEST"));
            log.info("设备: "+driverName+"测试用例"+testName+"用例通过");
            TestListener.mobileSuccessMessageList.add(driverName+"(版本："+sdkVersion+")"+testName);
        }catch(Exception | Error e){
            AppiumScreenShot appiumScreenShot=new AppiumScreenShot(driver);
            appiumScreenShot.setScreenName(driverName,testName);
            appiumScreenShot.takeScreenShot();
            log.error("设备: "+driverName+"测试用例: "+testName+"用例失败");
            TestListener.messageList.add(driverName+"(版本："+sdkVersion+")"+testName);
            throw e;
        }
    }
    @Test
    public void searchHistoryTest(){
        String testName=Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            comChatPage1 = new comChatPage();
            searchPage1 = comChatPage1.clickSearchBtn();
            searchPage1.clickSearchHistoryBtn();
            searchPage1.inputSearchHistoryText("comChat");
            searchPage1.clickSearchBtn();
            int size = searchPage1.getSearchHistoryItemSize();
            MatcherAssert.assertThat(size, greaterThan(0));
            log.info("设备: " + driverName + "测试用例: " +testName+"用例通过");
            TestListener.mobileSuccessMessageList.add(driverName+"(版本:"+sdkVersion+")"+testName);
        }catch(Exception | Error e){
            AppiumScreenShot appiumScreenShot=new AppiumScreenShot(driver);
            appiumScreenShot.setScreenName(driverName,testName);
            appiumScreenShot.takeScreenShot();
            log.error("设备: "+driverName+"测试用例: "+testName+"用例失败");
            TestListener.messageList.add(driverName+"(版本："+sdkVersion+")"+testName);
            throw e;
        }
    }
}
