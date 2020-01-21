package pages;

import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import utils.IOSElementAction;

import java.util.List;

public class saeCloudPage extends BasePage{
    private By searchEditBy=By.xpath("//XCUIElementTypeSearchField[@name=\"搜索\"]");
    private By cancelBtnBy=By.xpath("(//XCUIElementTypeButton[@name=\"取 消\"])[1]");
    private By backBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"backarrow icon gray\"]");
    private By uploadFileBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"sae cloud upload act icon\"]");
    private By searchBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"Search\"]");
    private IOSElementAction iosElementAction=new IOSElementAction();

    public IOSElement getSearchEdit(){
        String[] locator=searchEditBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getCancelBtn(){
        String[] locator=cancelBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getBackBtn(){
        String[] locator=backBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getUploadFileBtn(){
        String[] locator=uploadFileBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getSearchBtn(){
        String[] locator=searchBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public List<IOSElement> getFileItem(String fileName){

        String selector="type=='XCUIElementTypeStaticText' AND value CONTAINS "+"'"+fileName+"'";
        return iosElementAction.getElementsByPredicate(driver,selector,driverName,sdkVersion);
    }
    public void inputSearchFileName(String fileName){
        String[] locator=searchEditBy.toString().split(": ");
        iosElementAction.sendKeys(driver,locator,driverName,fileName,sdkVersion);
    }
    public void clickSearchBtn(){
        String[] locator=searchBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void clickFileItem(String fileName){
        List<IOSElement> list=getFileItem(fileName);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getText());
        }
        list.get(0).click();

    }


}
