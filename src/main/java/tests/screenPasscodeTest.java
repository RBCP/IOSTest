package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.loginPage;
import pages.screenPasscodePage;
import utils.TestListener;

public class screenPasscodeTest extends BaseTest {
    private static loginPage loginPage1;
    private static screenPasscodePage screenPasscodePage1;
    @BeforeClass
    public void validLogin(){
        loginPage1=new loginPage();
        loginPage1.clickPolicyBtn();
        loginPage1.clickPrivacyBtn();
        loginPage1.InputStaffId("M088163");
        loginPage1.InputPassword("lcl1702111");
        loginPage1.clickLoginBtn();
    }
    @Test
    public void passcodeTest() {
        String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try{
        screenPasscodePage1 = new screenPasscodePage();
        for (int i = 0; i < 6; i++)
            screenPasscodePage1.clickKeyboard(6);
        screenPasscodePage1.clickNextStepBtn();
        for (int i = 0; i < 6; i++)
            screenPasscodePage1.clickKeyboard(6);
        screenPasscodePage1.clickSaveBtn();
        log.info("设备："+driverName+"测试用例："+testName+"用例通过");
        TestListener.mobileSuccessMessageList.add(driverName+"(版本："+sdkVersion+")"+testName);
    }catch(Exception | Error e){
            log.error("设备："+driverName+"测试用例："+testName+"用例失败");
            TestListener.messageList.add(driverName+"(版本："+sdkVersion+")"+testName);
        }
    }
}
