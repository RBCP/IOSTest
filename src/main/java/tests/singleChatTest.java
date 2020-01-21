package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utils.AppiumScreenShot;
import utils.Assertion;
import utils.TestListener;

public class singleChatTest extends BaseTest{
    private static loginPage loginPage1;
    private static screenPasscodePage screenPasscodePage1;
    private static comChatPage comChatPage1;
    private static singleChatPage singleChatPage1;
    public void validLogin() throws InterruptedException{
        /*loginPage1=new loginPage();
        loginPage1.clickPolicyBtn();
        loginPage1.clickPrivacyBtn();
        loginPage1.InputStaffId("ITTEST03");
        loginPage1.InputPassword("123456789");
        loginPage1.clickLoginBtn();
        screenPasscodePage1=new screenPasscodePage();
        for(int i=0;i<6;i++)
            screenPasscodePage1.clickKeyboard(6);
        screenPasscodePage1.clickNextStepBtn();*/
        for(int i=0;i<6;i++)
            screenPasscodePage1.clickKeyboard(6);
        //screenPasscodePage1.clickSaveBtn();
        Thread.sleep(15000);
        comChatPage1 =new comChatPage();
    }
    @BeforeClass
    public void checkStatus() throws InterruptedException{
        String testName=Thread.currentThread().getStackTrace()[1].getMethodName();
        validLogin();
        try{
            Thread.sleep(15000);
            int size=comChatPage1.getOnlineStatusSize();
            boolean condiction=size>0?true:false ;
            Assert.assertTrue(condiction);
            log.info("设备: "+driverName+" 当前用户处于在线状态");
            singleChatPage1=comChatPage1.clickChatHistoryBtn();
        }catch(Exception | Error e){
            AppiumScreenShot appiumScreenShot =new AppiumScreenShot(driver);
            appiumScreenShot.setScreenName(driverName,testName);
            appiumScreenShot.takeScreenShot();
            log.error("设备: "+driverName+"当前用户不是处于在线状态");
            throw e;
        }
    }
    @Test
    public void continuousMessageTest(){
        String testName=Thread.currentThread().getStackTrace()[1].getMethodName();
        String userName=singleChatPage1.getUserNameText();
        try {
            for (int i = 0; i < 20; i++) {
                singleChatPage1.inputMessage(String.valueOf(i));
                singleChatPage1.clickSendBtn();
                String history = singleChatPage1.getChatHistoryText(String.valueOf(i));
                log.info("设备: "+driverName+" "+"向用户: "+userName+"发送了内容为\" "+history+"\""+"消息");
            }
            log.info("设备: "+driverName+" "+"测试用例: "+testName+"用例通过");
            TestListener.mobileSuccessMessageList.add(driverName+"(版本: "+sdkVersion+")"+testName);
        }catch(Exception | Error e){
            AppiumScreenShot appiumScreenShot = new AppiumScreenShot(driver);
            appiumScreenShot.setScreenName(driverName,testName);
            appiumScreenShot.takeScreenShot();
            log.error("设备: "+driverName+" "+"测试用例: "+testName+"用例失败");
            TestListener.messageList.add(driverName+"(版本: "+sdkVersion+")"+testName);
            throw e;

        }

    }
    @Test
    public void voiceMessageTest(){
        String testName=Thread.currentThread().getStackTrace()[1].getMethodName();
        String userName=singleChatPage1.getUserNameText();
        try {
            int size1 = singleChatPage1.getSendMessageSize();

            singleChatPage1.clickVoiceBtn();
            singleChatPage1.longPressVoiceBtn(11);
            int size2 = singleChatPage1.getSendMessageSize();
            singleChatPage1.clickKeyboardBtn();
            Assertion.verityInt(size1, size2, driverName, sdkVersion);
            log.info("设备: "+driverName+" "+"向用户: "+userName+"发了一条10s的语音消息");
            log.info("设备: "+driverName+" "+"测试用例: "+testName+"用例通过");
            TestListener.mobileSuccessMessageList.add(driverName+"(版本："+sdkVersion+")"+testName);
        }catch(Exception | Error e){
            AppiumScreenShot appiumScreenShot = new AppiumScreenShot(driver);
            appiumScreenShot.setScreenName(driverName,testName);
            appiumScreenShot.takeScreenShot();
            log.error("设备: "+driverName+" "+"测试用例: "+testName+"用例失败");
            TestListener.messageList.add(driverName+"(版本: "+sdkVersion+")"+testName);
            throw e;

        }
    }
    @Test
    public void sendPhotoTest(){
        String testName=Thread.currentThread().getStackTrace()[1].getMethodName();
        String userName=singleChatPage1.getUserNameText();
        try {
            int size1 = singleChatPage1.getSendMessageSize();
            singleChatPage1.clickMoreBtn();
            singleChatPage1.clickPictureBtn();
            singleChatPage1.selectPhoto();
            singleChatPage1.clickSendPhotoBtn();
            int size2 = singleChatPage1.getSendMessageSize();
            Assertion.verityInt(size1,size2,driverName,sdkVersion);
            log.info("设备: "+driverName+" "+"向用户: "+userName+"发送了一条图片消息");
            log.info("设备: "+driverName+" "+"测试用例: "+testName+"用例通过");
            TestListener.mobileSuccessMessageList.add(driverName+"(版本: "+sdkVersion+")"+testName);
        }catch(Exception | Error e){
            AppiumScreenShot appiumScreenShot=new AppiumScreenShot(driver);
            appiumScreenShot.setScreenName(driverName,testName);
            appiumScreenShot.takeScreenShot();
            log.error("设备: "+driverName+" "+"测试用例: "+testName+"用例失败");
            TestListener.messageList.add(driverName+"(版本: "+sdkVersion+")"+testName);
            throw e;
        }

    }
    @Test
    public void takePhotoTest() throws InterruptedException{
        String testName=Thread.currentThread().getStackTrace()[1].getMethodName();
        String userName=singleChatPage1.getUserNameText();
        try {
            singleChatPage1.clickMoreBtn();
            singleChatPage1.clickTakePhotoBtn();
            singleChatPage1.clickShutterBtn();
            Thread.sleep(30000);
            log.info("设备: "+driverName+" "+"向用户: "+userName+"发送了刚拍摄的照片");
            log.info("设备: "+driverName+" "+"测试用例: "+testName+"用例通过");
            TestListener.mobileSuccessMessageList.add(driverName+"(版本: "+sdkVersion+")"+testName);
        }catch(Exception | Error e){
            AppiumScreenShot appiumScreenShot=new AppiumScreenShot(driver);
            appiumScreenShot.setScreenName(driverName,testName);
            appiumScreenShot.takeScreenShot();
            log.error("设备: "+driverName+" "+"测试用例: "+testName+"用例失败");
            TestListener.messageList.add(driverName+"(版本: "+sdkVersion+")"+testName);
            throw e;
        }
    }
    @Test
    public void sendEmotionMessageTest() throws InterruptedException{
        String testName=Thread.currentThread().getStackTrace()[1].getMethodName();
        String userName=singleChatPage1.getUserNameText();
        try {
            singleChatPage1.clickEmotionBtn();
            singleChatPage1.selectEmotionItem();
            singleChatPage1.clickSendEmotionBtn();
            System.out.println(singleChatPage1.getSendMessageSize());
            log.info("设备: "+driverName+" "+"向用户: "+userName+"发送了一条表情消息");
            singleChatPage1.clickGifEmotionBtn();
            singleChatPage1.selectEmotionItem();
            singleChatPage1.clickSendEmotionBtn();
            System.out.println(singleChatPage1.getSendMessageSize());
            log.info("设备: "+driverName+" "+"向用户: "+userName+"发送了一条动态表情消息");
            Thread.sleep(15000);
            log.info("设备: "+driverName+" "+"测试用例: "+testName+" 用例通过");
            TestListener.mobileSuccessMessageList.add(driverName+"(版本: "+sdkVersion+")"+testName);
        }catch(Exception | Error e){
            AppiumScreenShot appiumScreenShot=new AppiumScreenShot(driver);
            appiumScreenShot.setScreenName(driverName,testName);
            appiumScreenShot.takeScreenShot();
            log.error("设备: "+driverName+" "+"测试用例"+testName+" 用例失败");
            TestListener.mobileSuccessMessageList.add(driverName+"(版本: "+sdkVersion+")"+testName);

        }
    }
    @Test
    public void voiceCallTest() throws InterruptedException{
        voiceCallPage voiceCallPage1=new voiceCallPage();
        singleChatPage1.clickMoreBtn();
        voiceCallPage1=singleChatPage1.clickVoiceCallBtn();
        voiceCallPage1.clickTeleBugleBtn();
        Thread.sleep(3000);
        voiceCallPage1.clickTeleBugleBtn();
        voiceCallPage1.clickTeleMicroPhoneBtn();
        Thread.sleep(3000);
        voiceCallPage1.clickTeleMicroPhoneBtn();
        voiceCallPage1.clickTeleHandUpBtn();

    }

}
