package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class sendCloudTest extends BaseTest{
    private static loginPage loginPage1;
    private static screenPasscodePage screenPasscodePage1;
    private static comChatPage comChatPage1;
    private static singleChatPage singleChatPage1;
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
        Thread.sleep(15000);
        comChatPage1 =new comChatPage();
    }
    @BeforeClass
    public void checkStatus() throws InterruptedException{
        validLogin();
        try{
            Thread.sleep(15000);
            int size=comChatPage1.getOnlineStatusSize();
            boolean condiction=size>0?true:false ;
            Assert.assertTrue(condiction);
            singleChatPage1=comChatPage1.clickChatHistoryBtn();
        }catch(Exception | Error e){
            throw e;
        }
    }
    @Test
    public void sendFileTest() throws InterruptedException{
        saeCloudPage cloudPage;
        singleChatPage1.clickMoreBtn();
        cloudPage=singleChatPage1.clickClondBtn();
        cloudPage.inputSearchFileName("Android");
        cloudPage.clickSearchBtn();
        cloudPage.clickFileItem("Android");
        Thread.sleep(15000);
    }

}
