package pages;

import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import utils.IOSElementAction;

import java.util.List;

public class comChatPage extends BasePage{
    private By searchBtnBy=By.xpath("//XCUIElementTypeSegmentedControl[@name=\"scopeBar\"]");

    private By leftMenuBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"chat list office nav\"]");
    private By addMenuBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"添加\"]");
    private By chatHistoryBtnBy=By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[2]");
    private By systemHistoryBy=By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[1]");

    private IOSElementAction iosElementAction=new IOSElementAction();

    public IOSElement getSearchBtn(){
        String[] locator=searchBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public List<IOSElement> getOnlineStatus(){
        String selector="type=='XCUIElementTypeStaticText' AND value CONTAINS '在线'";
        return iosElementAction.getElementsByPredicate(driver,selector,driverName,sdkVersion);
    }
    public IOSElement getLeftMenuBtn(){
        String[] locator=leftMenuBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getAddMenuBtn(){
        String[] locator=addMenuBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getChatHistory(){
        String[] locator=chatHistoryBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getSystemHistory(){
        String[] locator=systemHistoryBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public int getOnlineStatusSize(){
        List<IOSElement> list=getOnlineStatus();
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));
        return list.size();
    }
   public searchPage clickSearchBtn(){
        String[] locator=searchBtnBy.toString().split(": ");
         iosElementAction.click(driver,locator,driverName,sdkVersion);
         return new searchPage();
   }
   public singleChatPage clickChatHistoryBtn(){
        String[] locator=chatHistoryBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
        return new singleChatPage();
   }

}
