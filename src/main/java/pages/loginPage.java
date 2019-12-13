package pages;

import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import utils.IOSElementAction;

public class loginPage extends BasePage{
    private By staffIdBy=By.xpath("//XCUIElementTypeOther[1]/XCUIElementTypeTextField");
    private By passwordBy=By.xpath("//XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField");
    private By privacyBy=By.xpath("(//XCUIElementTypeButton[@name=\"not select icon\"])[2]");
    private By policyBy=By.xpath("(//XCUIElementTypeButton[@name=\"not select icon\"])[1]");
    private By loginBtnBy=By.xpath("//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton");
    private By staticStaffBy=By.xpath("//XCUIElementTypeStaticText[@name=\"工号\"]");
    private By staticPassword=By.xpath("//XCUIElementTypeStaticText[@name=\"密码\"]");
    IOSElementAction iosElementAction=new IOSElementAction();

    public IOSElement getStaffId(){
        String[] locator=staffIdBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getPassword(){
        String[] locator=passwordBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getPrivacy(){
        String[] locator=privacyBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getPolicy(){
        String[] locator=policyBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getLoginBtn(){
        String[] locator=loginBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getStaticStaff(){
        String[] locator=staticStaffBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getStaticPassword(){
        String[] locator=staticPassword.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }

    public void InputStaffId(String staffId){
        String[] locator=staffIdBy.toString().split(": ");
        iosElementAction.clearElement(driver,locator,driverName,sdkVersion);
        iosElementAction.sendKeys(driver,locator,driverName,staffId,sdkVersion);
    }
    public  void InputPassword(String password) {
        String[] locator=passwordBy.toString().split(": ");
        iosElementAction.clearElement(driver,locator,driverName,sdkVersion);
        iosElementAction.sendKeys(driver,locator,driverName,password,sdkVersion);
    }
    public void clickPrivacyBtn(){
        String[] locator=privacyBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);

    }
    public void clickPolicyBtn(){
        String[] locator=policyBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void clickLoginBtn(){
        String[] locator=loginBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public String getNullStaffToast(){
        String[] locator=staticStaffBy.toString().split(": ");
        return iosElementAction.elementExport(driver,locator,driverName,sdkVersion);
    }
    public String getNullPasswordToast(){
        String[] locator=staticPassword.toString().split(": ");
        return iosElementAction.elementExport(driver,locator,driverName,sdkVersion);
    }
}
