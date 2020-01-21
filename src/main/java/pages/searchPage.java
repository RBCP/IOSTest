package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import utils.IOSElementAction;

import java.util.List;

public class searchPage extends BasePage {
    private By searchEditBy=By.xpath("//XCUIElementTypeSearchField[@name=\"搜索\"]");
    private By searchContactBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"search contacts\"]");
    private By searchHistoryBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"search chat record\"]");
    private By cancelBtnBy=By.xpath("//XCUIElementTypeStaticText[@name=\"取消\"]");
    private By searchBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"Search\"]");
    private By searchContactEditBy=By.xpath("//XCUIElementTypeSearchField[@name=\"请输入搜索联系人\"]");
    private By searchHistoryEditBy=By.xpath("//XCUIElementTypeSearchField[@name=\"请输入搜索聊天记录\"]");
    private By noSearchResultBy=By.xpath("//XCUIElementTypeStaticText[@name=\"No result\"]");
    private By searchHistoryResultBy=By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[1]");
    private By searchBackBy=By.xpath("//XCUIElementTypeButton[@name=\"返回\"]");
    private By searchContactResultBy=By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[1]");
    private IOSElementAction iosElementAction=new IOSElementAction();

    public IOSElement getSearchEdit(){
        String[] locator=searchEditBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getSearchContactBtn(){
        String[] locator=searchContactBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getSearchHistoryBtn(){
        String[] locator=searchHistoryBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getCancleBtn(){
        String[] locator=cancelBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getSearchBtn(){
        String[] locator=searchBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }

    public List<IOSElement> getSearchContactResult(){
         String selector="type=='XCUIElementTypeStaticText' AND value CONTAINS 'ITTEST'";
         return driver.findElementsByIosNsPredicate(selector);
    }
    /*public List<IOSElement> getSearchHistoryResult(){
        String selector="type=='XCUIElementTypeStaticText'";
        return driver.findElementsByIosNsPredicate(selector);
    }*/
    public IOSElement getSearchHistoryResult(){
        String[] locator=searchHistoryResultBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);

    }
    public List<IOSElement> getSearchHistoryResultItem(){
        String selector="type=='XCUIElementTypeStaticText' AND value CONTAINS 'comChat'";
        return iosElementAction.getElementsByPredicate(driver,selector,driverName,sdkVersion);
    }
    public IOSElement getSearchContactEdit(){
        String[] locator=searchContactEditBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getSearchHistoryEdit(){
        String[] locator=searchHistoryEditBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getNoSearchResult(){
        String[] locator=noSearchResultBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getSearchBackBtn(){
        String[] locator=searchBackBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public void inputSearchContactText(String text){
        String[] locator=searchContactEditBy.toString().split(": ");
        iosElementAction.sendKeys(driver,locator,driverName,text,sdkVersion);
    }
    public void inputSearchHistoryText(String text){
        String[] locator=searchHistoryEditBy.toString().split(": ");
        iosElementAction.sendKeys(driver,locator,driverName,text,sdkVersion);
    }
    public void clickSearchEditBtn(){
        String[] locator=searchEditBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void clickSearchContactBtn(){
        String[] locator=searchContactBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void clickSearchHistoryBtn(){
        String[] locator=searchHistoryBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void clickSearchBtn(){
        String[] locator=searchBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void clickCancelBtn(){
        String[] locator=cancelBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void clickSearchBackBtn(){
        String[] locator=searchBackBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void clickSearchHistoryResult(){
       String[] locator=searchHistoryResultBy.toString().split(": ");
       iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public String getSearchContactResultText(){
        List<IOSElement> iosElement =getSearchContactResult();
       return iosElement.get(1).getText();
    }
   public int getSearchHistoryItemSize(){
        List<IOSElement> list=getSearchHistoryResultItem();
        return list.size();

   }
}
