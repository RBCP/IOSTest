package pages;

import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import utils.IOSElementAction;

public class voiceCallPage extends BasePage {
    private By teleBugleBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"tele bugle icon normal\"]");
    private By teleMicroPhoneBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"tele microphone on icon\"]");
    private By teleKeyboardBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"tele switch to keyboard icon p\"]");
    private By teleHandUpBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"tele hang up icon normal\"]");
    private By keyboardNo1By=By.xpath("//XCUIElementTypeStaticText[@name=\"1\"]");
    private By keyboardNo2By=By.xpath("//XCUIElementTypeStaticText[@name=\"2\"]");
    private By keyboardNo3By=By.xpath("//XCUIElementTypeStaticText[@name=\"3\"]");
    private By keyboardNo4By=By.xpath("//XCUIElementTypeStaticText[@name=\"4\"]");
    private By keyboardNo5By=By.xpath("//XCUIElementTypeStaticText[@name=\"5\"]");
    private By keyboardNo6By=By.xpath("//XCUIElementTypeStaticText[@name=\"6\"]");
    private By keyboardNo7By=By.xpath("//XCUIElementTypeStaticText[@name=\"7\"]");
    private By keyboardNo8By=By.xpath("//XCUIElementTypeStaticText[@name=\"8\"]");
    private By keyboardNo9By=By.xpath("//XCUIElementTypeStaticText[@name=\"9\"]");
    private By keyboardNo0By=By.xpath("//XCUIElementTypeStaticText[@name=\"0\"]");
    private By keyboardSp1By=By.xpath("//XCUIElementTypeStaticText[@name=\"*\"]");
    private By keyboardSp2By=By.xpath("//XCUIElementTypeStaticText[@name=\"#\"]");

    private IOSElementAction iosElementAction=new IOSElementAction();

    public IOSElement getTeleBygleBtn(){
        String[] locator=teleBugleBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getTeleMicroPhoneBtn(){
        String[] locator=teleMicroPhoneBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getTeleKeyboardBtn(){
        String[] locator=teleKeyboardBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getTeleHandUpBtn(){
        String[] locator=teleHandUpBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getKeyboardNo(int x){
        String[] locator;
        IOSElement iosElement=new IOSElement();
        switch(x){
            case 1:
                locator=keyboardNo1By.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
            case 2:
                locator=keyboardNo2By.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
            case 3:
                locator=keyboardNo3By.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
            case 4:
                locator=keyboardNo4By.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
            case 5:
                locator=keyboardNo5By.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
            case 6:
                locator=keyboardNo6By.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
            case 7:
                locator=keyboardNo7By.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
            case 8:
                locator=keyboardNo8By.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
            case 9:
                locator=keyboardNo9By.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
            default:
                locator=keyboardNo0By.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
        }
        return iosElement;
    }
    public IOSElement getKeyboardSp1(){
        String[] locator=keyboardSp1By.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getKeyboardSp2(){
        String[] locator=keyboardSp2By.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public void clickTeleBugleBtn(){
        String[] locator=teleBugleBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void clickTeleMicroPhoneBtn(){
        String[] locator=teleMicroPhoneBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void clickTeleHandUpBtn(){
        String[] locator=teleHandUpBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void clickTeleKeyboard(int x){
        String[] locator;
        switch(x){
            case 1:
                locator=keyboardNo1By.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;
            case 2:
                locator=keyboardNo2By.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;
            case 3:
                locator=keyboardNo3By.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;
            case 4:
                locator=keyboardNo4By.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;
            case 5:
                locator=keyboardNo5By.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;
            case 6:
                locator=keyboardNo6By.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;
            case 7:
                locator=keyboardNo7By.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;
            case 8:
                locator=keyboardNo8By.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;
            case 9:
                locator=keyboardNo9By.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;
            default:
                locator=keyboardNo0By.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;

        }
    }
    public void clickKeyboardSp1(){
        String[] locator=keyboardSp1By.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void clickKeyboardSp2(){
        String[] locator=keyboardSp2By.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }


}
