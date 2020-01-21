package pages;

import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import utils.IOSElementAction;

public class screenPasscodePage extends BasePage{
    private By keyboardOneBy=By.xpath("//XCUIElementTypeKey[@name=\"1\"]");
    private By keyboardTwoBy=By.xpath("//XCUIElementTypeKey[@name=\"2\"]");
    private By keyboardThreeBy=By.xpath("//XCUIElementTypeKey[@name=\"3\"]");
    private By keyboardFourBy=By.xpath("//XCUIElementTypeKey[@name=\"4\"]");
    private By keyboardFiveBy=By.xpath("//XCUIElementTypeKey[@name=\"5\"]");
    private By keyboardSixBy=By.xpath("//XCUIElementTypeKey[@name=\"6\"]");
    private By keyboardSevenBy=By.xpath("//XCUIElementTypeKey[@name=\"7\"]");
    private By keyboardEightBy=By.xpath("//XCUIElementTypeKey[@name=\"8\"]");
    private By keyboardNineBy=By.xpath("//XCUIElementTypeKey[@name=\"9\"]");
    private By keyboardZeroBy=By.xpath("//XCUIElementTypeKey[@name=\"0\"]");
    private By nextStepBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"下一步\"]");
    private By saveBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"保存\"]");
    private By backBtnBy=By.xpath("//XCUIElementTypeStaticText[@name=\"返回\"]");

    private IOSElementAction iosElementAction =new IOSElementAction();

    public IOSElement getKeyboard(int x){
        String[] locator;
        IOSElement iosElement;
        switch(x){
            case 1:
                locator=keyboardOneBy.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
            case 2:
                locator=keyboardTwoBy.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
            case 3:
                locator=keyboardThreeBy.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
            case 4:
                locator=keyboardFourBy.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
            case 5:
                locator=keyboardFiveBy.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
            case 6:
                locator=keyboardSixBy.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
            case 7:
                locator=keyboardSevenBy.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
            case 8:
                locator=keyboardEightBy.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
            case 9:
                locator=keyboardNineBy.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;
            default:
                locator=keyboardZeroBy.toString().split(": ");
                iosElement=iosElementAction.getElement(driver,locator,driverName);
                break;

        }
        return iosElement;
    }
    public IOSElement getNextStepBtn(){
        String[] locator=nextStepBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getSaveBtn(){
        String[] locator=saveBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getBackBtn(){
        String[] locator=backBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public void clickKeyboard(int x){
        String[] locator;
        switch(x){
            case 1:
                locator=keyboardOneBy.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;
            case 2:
                locator=keyboardTwoBy.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;
            case 3:
                locator=keyboardThreeBy.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;
            case 4:
                locator=keyboardFourBy.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;
            case 5:
                locator=keyboardFiveBy.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;
            case 6:
                locator=keyboardSixBy.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;
            case 7:
                locator=keyboardSevenBy.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;
            case 8:
                locator=keyboardEightBy.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;
            case 9:
                locator=keyboardNineBy.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;
            default:
                locator=keyboardZeroBy.toString().split(": ");
                iosElementAction.click(driver,locator,driverName,sdkVersion);
                break;

        }
    }
    public void clickNextStepBtn(){
        String[] locator=nextStepBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void clickSaveBtn(){
        String[] locator=saveBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void clickBackBtn(){
        String[] locator=backBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void sendPasscode(String passcode){
        String[] locator=passcode.toString().split(": ");
        iosElementAction.sendKeys(driver,locator,driverName,passcode,sdkVersion);

    }





}
