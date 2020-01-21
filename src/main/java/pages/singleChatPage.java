package pages;

import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import utils.IOSElementAction;

import java.util.List;

public class singleChatPage extends BasePage{
    private By chatEditBy=By.xpath("//XCUIElementTypeImage/XCUIElementTypeTextView");
    private By voiceBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"chat mic icon\"]");
    private By emotionBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"chat expression icon\"]");
    private By moreBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"chat morefunction icon\"]");
    private By sendBtnBy=By.xpath("//XCUIElementTypeStaticText[@name=\"send\"]");
    private By voiceRecordBy=By.xpath("//XCUIElementTypeStaticText[@name=\"按住说话\"]");
    private By keyboardBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"chat mic icon\"]");
    private By allPhotoBy=By.xpath("//XCUIElementTypeCell[@name=\"所有照片\"]");
    private By sendPhotoBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"chat expression icon\"]");
    private By firstEmotionBy=By.xpath("//XCUIElementTypeScrollView/XCUIElementTypeButton[1]");
    private By gifEmotionBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"dog000\"]");
    private By jpgEmotionBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"微笑\"]");
    private By sendEmotionBtnBy=By.xpath("//XCUIElementTypeButton[@name=\"发送\"]");

    private IOSElementAction iosElementAction =new IOSElementAction();

    public IOSElement getChatEdit(){
        String[] locator=chatEditBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getVoiceBtn(){
        String[] locator=voiceBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getEmojiBtn(){
        String[] locator=emotionBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getMoreBtn(){
        String[] locator=moreBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getSendBtn(){
        String[] locator=sendBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getVoiceRecord(){
        String[] locator=voiceRecordBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);

    }
    public IOSElement getAllPhoto(){
        String[] locator=allPhotoBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getKeyboardBtn(){
        String[] locator=keyboardBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getSendPhotoBtn(){
        String[] locator=sendPhotoBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getFirstEmotion(){
        String[] locator=firstEmotionBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getGifEmotionBtn(){
        String[] locator=gifEmotionBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public IOSElement getJpgEmotionBtn(){
        String[] locator=jpgEmotionBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);
    }
    public List<IOSElement> getStaticText(){
        String selector="type=='XCUIElementTypeStaticText'";
        return iosElementAction.getElementsByPredicate(driver,selector,driverName,sdkVersion);
    }
    public List<IOSElement> getChatHistory(String value){
        String content="'"+value+"'";
        String selector="type=='XCUIElementTypeStaticText' AND value == "+"'"+value+"'";
        return iosElementAction.getElementsByPredicate(driver,selector,driverName,sdkVersion);
    }
    public List<IOSElement> getSendMessageItem(){
        String selector="type=='XCUIElementTypeButton' AND label == 'chat box2'";
        return iosElementAction.getElementsByPredicate(driver,selector,driverName,sdkVersion);
    }
    public List<IOSElement> getReceivedMessageItem(){
        String selector="type=='XCUIElementTypeButton' AND label == 'chat box1'";
        return iosElementAction.getElementsByPredicate(driver,selector,driverName,sdkVersion);
    }
    public  IOSElement getPictureBtn(){
        String selector="type=='XCUIElementTypeButton' AND label == 'chat input box photo'";
        return iosElementAction.getElementByPredicate(driver,selector,driverName,sdkVersion);
    }
    public IOSElement getSendEmotionBtn(){
        String[] locator=sendEmotionBtnBy.toString().split(": ");
        return iosElementAction.getElement(driver,locator,driverName);

    }
    public List<IOSElement> getPictureMessage(){
        String selector="type==XCUIElementTypeImage";
        return iosElementAction.getElementsByPredicate(driver,selector,driverName,sdkVersion);
    }
    public void clickSendEmotionBtn(){
        String[] locator=sendEmotionBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public IOSElement getTakePhotoBtn(){
        String selector="type=='XCUIElementTypeButton' AND label == 'chat input box take photo'";
        return iosElementAction.getElementByPredicate(driver,selector,driverName,sdkVersion);
    }
    public IOSElement getClondBtn(){
        String selector="type=='XCUIElementTypeButton' AND label == 'chat input box cloud'";
        return iosElementAction.getElementByPredicate(driver,selector,driverName,sdkVersion);
    }
    public  IOSElement getVoiceCallBtn(){
        String selector="type=='XCUIElementTypeButton' AND label == 'chat input box voice call'";
        return iosElementAction.getElementByPredicate(driver,selector,driverName,sdkVersion);
    }
    public IOSElement getFileBtn(){
        String selector="type=='XCUIElementTypeButton' AND label == 'chat input box file'";
        return iosElementAction.getElementByPredicate(driver,selector,driverName,sdkVersion);
    }
    public IOSElement getVideoCallBtn(){
        String selector="type=='XCUIElementTypeButton' AND label == 'chat video call'";
        return iosElementAction.getElementByPredicate(driver,selector,driverName,sdkVersion);
    }
    public List<IOSElement> getPhotoMenu(){
        String selector="type=='XCUIElementTypeCell' AND label == '所有照片'";
        return iosElementAction.getElementsByPredicate(driver,selector,driverName,sdkVersion);
    }
    public List<IOSElement> getPhotoAlbum(){
        String selector="type=='XCUIElementTypeCell'";
        return iosElementAction.getElementsByPredicate(driver,selector,driverName,sdkVersion);
    }
    public String getUserNameText(){
        List<IOSElement> list =getStaticText();
        return list.get(2).getText();
    }
    public String getOnlineStatus(){
        List<IOSElement> list=getStaticText();
        return list.get(3).getText();
    }
    public void inputMessage(String text){
        String[] locator=chatEditBy.toString().split(": ");
         iosElementAction.sendKeys(driver,locator,driverName,text,sdkVersion);
    }
    public void clickSendBtn(){
        String[] locator=sendBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void clickMoreBtn(){
        String[] locator=moreBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void clickPictureBtn(){
        IOSElement iosElement=getPictureBtn();
        iosElement.click();
    }
    public void clickTakePhotoBtn(){
        IOSElement iosElement=getTakePhotoBtn();
        iosElement.click();
    }
    public saeCloudPage clickClondBtn(){
        IOSElement iosElement=getClondBtn();
        iosElement.click();
        return new saeCloudPage();
    }
    public voiceCallPage clickVoiceCallBtn(){
        IOSElement iosElement =getVoiceCallBtn();
        iosElement.click();
        return new voiceCallPage();

    }
    public void clickFileBtn(){
        IOSElement iosElement=getFileBtn();
        iosElement.click();
    }
    public void clickVideoCallBtn(){
        IOSElement iosElement=getVideoCallBtn();
        iosElement.click();
    }
    public void clickAllPhoto(){
        String[] locator=allPhotoBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void clickSendPhotoBtn(){
        String[] locator=sendPhotoBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void gotoAllPhotoPage(){
        List<IOSElement> list=getPhotoMenu();
        list.get(0).click();
    }
    public void selectPhoto(){
         gotoAllPhotoPage();
        List<IOSElement> list=getPhotoAlbum();
        System.out.println("相册的大小: "+list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getAttribute("label"));
        }
        list.get(list.size()-1).click();
    }
    public void selectEmotionItem(){
        String[] locator=firstEmotionBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }

    public String getChatHistoryText(String content){
        List<IOSElement> list=getChatHistory(content);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i).getText());
        return list.get(list.size()-1).getText();
    }
    public void clickVoiceBtn(){
        String[] locator=voiceBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
    }
    public void longPressVoiceBtn(int time){
        String[] locator=voiceRecordBy.toString().split(": ");
        iosElementAction.longPress(driver,locator,driverName,time,sdkVersion);
    }
   public int getSendMessageSize(){
        List<IOSElement> list=getSendMessageItem();
        return list.size();
   }
   public void clickShutterBtn(){
        String locator="184,720";
        iosElementAction.driverClick(driver,locator,driverName,sdkVersion);
        String locator1="280,720";
        iosElementAction.driverClick(driver,locator1,driverName,sdkVersion);
   }
   public void clickKeyboardBtn(){
        String[] locator=keyboardBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);

   }
   public int getReceivedMessageSize(){
        List<IOSElement> list=getReceivedMessageItem();
        return list.size();
   }
   public void clickEmotionBtn(){
        String[] locator=emotionBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
   }
   public void clickGifEmotionBtn(){
        String[] locator=gifEmotionBtnBy.toString().split(": ");
        iosElementAction.click(driver,locator,driverName,sdkVersion);
   }

}
