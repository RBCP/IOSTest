package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class IOSElementAction {
    public Log log=new Log(this.getClass());
    public IOSElement getElement(IOSDriver<IOSElement> driver,String[] locator,String driverName){
        log.info("设备: "+driverName+" "+"查找方式："+locator[0]+"查看元素: "+"["+locator[1]+"]");
        IOSElement iosElement;
        switch(locator[0]){
            case "By.xpath":
                iosElement=driver.findElement(By.xpath(locator[1]));
                break;
            case "By.id":
                iosElement=driver.findElement(By.id(locator[1]));
                break;
            case "By.cssSelector":
                iosElement=driver.findElement(By.cssSelector(locator[1]));
                break;
            case "By.name":
                iosElement=driver.findElement(By.name(locator[1]));
                break;
            case "By.className":
                iosElement=driver.findElement(By.className(locator[1]));
                break;
            case "By.linkText":
                iosElement=driver.findElement(By.linkText(locator[1]));
                break;
            case "By.tagName":
                iosElement=driver.findElement(By.tagName(locator[1]));
                break;
            default:
                iosElement=driver.findElement(By.xpath(locator[1]));
        }
        return iosElement;
    }
    public IOSElement getElementByPredicate(final IOSDriver<IOSElement> driver,String selector,final String driverName,String sdkVersion){
        IOSElement iosElement=new IOSElement();
        try{
           iosElement= driver.findElementByIosNsPredicate(selector);
            log.info("设备: "+driverName+" "+"操作方式: ByIosNsPredicate"+"策略为："+selector);
        }catch(Exception e){
            log.error("设备: "+driverName+" "+"找不到对应的元素"+selector);
            TestListener.messageList.add(driverName+"版本: "+sdkVersion+"):::"+" "+"找不到该元素: "+selector);
            throw e;
        }
        return iosElement;
    }
    public List<IOSElement> getElementsByPredicate(final IOSDriver<IOSElement> driver,String selector,final String driverName,final String sdkVersion){
        List<IOSElement> list=new ArrayList<IOSElement>();
        try{
            list=driver.findElementsByIosNsPredicate(selector);
            log.info("设备: "+driverName+" "+"操作方式: ByIosNsPredicate"+"策略为: "+selector);
        }catch(Exception | Error e){
            log.error("设备: "+driverName+" "+"找不到对应的元素集");
            TestListener.messageList.add(driverName+"版本: "+sdkVersion+"):::"+" "+"找不到该元素集: "+selector);
            throw e;
        }
        return list;
    }
    public IOSElement waitForElement(final IOSDriver<IOSElement> driver,final String[] locator,final String driverName,int time,final String sdkVersion){
        IOSElement iosElement=null;
        try{
          iosElement=(new WebDriverWait(driver,time)).until(
                  new ExpectedCondition<IOSElement>(){
                      @Override
                      public IOSElement apply(WebDriver dr){
                          return getElement(driver,locator,driverName);
                      }
                  });
          return iosElement;
        }catch(Exception e){
            log.error("设备: "+driverName+" "+"【failed】等待"+time+"s 找不到元素: "+"["+locator[1]+"]"+"方式"+locator[0]);
            TestListener.messageList.add(driverName+"(版本: "+sdkVersion+"):::"+" "+"s 找不到元素: "+"["+locator[1]+"]"+"方式："+locator[0]);
            throw e;
        }
    }
    public void elementSelectForIndex(IOSDriver<IOSElement> driver,String[] locator,int index,String driverName,String sdkVersion){
        IOSElement iosElement =waitForElement(driver,locator,driverName,10,sdkVersion);
        Select select = new Select(iosElement);
        try{
            select.selectByIndex(index);
            log.info("设备: "+driverName+" "+"选择操作: index="+index);
        }catch(Exception e){
            log.error("设备: "+driverName+" "+"复选框选择失败 方式: [ index ]值 ["+index+"]");
            TestListener.messageList.add(driverName+"(版本: "+sdkVersion+"):::"+"复选框失败 方式 : [ index ]值 : ["+index+"]");
            throw e;
        }
    }
    public void elementSelectForText(IOSDriver<IOSElement> driver,String[] locator,String text,String driverName,String sdkVersion){
        IOSElement iosElement =waitForElement(driver,locator,driverName,10,sdkVersion);
        Select select =new Select(iosElement);
        try{
            select.selectByVisibleText(text);
            log.info("设备: "+driverName+" "+"选择操作: Text="+text);

        }catch(Exception e){
            log.error("设备: "+driverName+" "+"复选框选择失败 方式: [ text ] 值 : ["+text+" ] ");
            TestListener.messageList.add(driverName+"(版本: " +sdkVersion+"):::"+"复选框选择失败 方式: [text] 值 [ "+text+"]");
            throw e;
        }
    }
    public void ElementSelectForValue(IOSDriver<IOSElement> driver,String[] locator,String value,String driverName,String sdkVersion){
        IOSElement iosElement=waitForElement(driver,locator,driverName,10,sdkVersion);
        Select select =new Select(iosElement);
        try{
            select.selectByValue(value);
            log.info("设备: "+driverName+" "+"选择操作: Value"+value);
        }catch(Exception e){
            log.error("设备: "+driverName+" "+"复选框选择失败 方式 : [ value ]: [" +value+"]");
            TestListener.messageList.add(driverName+"(版本: "+sdkVersion+"):::"+"复选框选择失败 方式: [ value ]值 : ["+value+"]");
            throw e;
        }
    }
    public String elementExport(IOSDriver<IOSElement>driver,String[] locator,String driverName,String sdkVersion){
        IOSElement iosElement =waitForElement(driver,locator,driverName,10,sdkVersion);
        String text=null;
        try{
            text=iosElement.getText();
            log.info("设备: "+driverName+" "+"输出数据为: "+text);
        }catch(Exception e){
            log.error("设备: "+driverName+" "+"获取数据失败！");
            TestListener.messageList.add(driverName+"(版本: "+sdkVersion+"):::"+"获取数据失败！");
            throw e;
        }
        return text;
    }
    public void sendKeys(IOSDriver<IOSElement> driver,String[] locator,String driverName,String text,String sdkVersion){
        IOSElement iosElement=waitForElement(driver,locator,driverName,15,sdkVersion);
        try{
            iosElement.clear();
            iosElement.sendKeys(text);
            log.info("设备: "+driverName+" "+"输入的数据为: "+text);
        }catch(Exception e){
            log.error("设备: "+driverName+" "+"控件输入失败！");
            TestListener.messageList.add(driverName+"(版本: "+sdkVersion+"):::"+"控件输入失败，输入数据为"+text);
            throw e;
        }
    }
    public void click(IOSDriver<IOSElement> driver,String[] locator,String driverName,String sdkVersion){
        IOSElement iosElement=waitForElement(driver,locator,driverName,15,sdkVersion);
        try{
            log.info("设备:"+driverName+" "+"点击控件");
            iosElement.click();
        }catch(Exception e){
            log.error("设备: "+driverName+" "+"点击控件失败");
            TestListener.messageList.add(driverName+"(版本: "+sdkVersion+"):::"+"点击控件失败");
            throw e;
        }
    }
    public void clearElement(IOSDriver<IOSElement> driver,String[] locator,String driverName,String sdkVersion){
        IOSElement iosElement=waitForElement(driver,locator,driverName,10,sdkVersion);
        try{
            log.info("设备: "+driverName+" "+"清除控件信息");
            iosElement.clear();
        }catch(Exception | Error e){
            log.error("设备: "+driverName+" "+"清除控件信息失败");
            TestListener.messageList.add(driverName+"(版本: "+sdkVersion+"):::"+"清除控件信息失败");
        }
    }
   public void longPress(IOSDriver<IOSElement> driver,String[] locator,String driverName,int time,String sdkVersion){
        try{
            log.info("设备: "+driverName+" "+"长按控件");
            IOSElement iosElement =waitForElement(driver,locator,driverName,10,sdkVersion);
            TouchAction touchAction1=new TouchAction(driver);
            Duration duration=Duration.of(time, ChronoUnit.SECONDS);
            LongPressOptions longPressOptions=new LongPressOptions();
            touchAction1.longPress(longPressOptions.withElement(ElementOption.element(iosElement)).withDuration(duration)).release().perform();
        }catch(Exception | Error e){
            log.error("设备: "+driverName+" "+"长按控件失败");
            TestListener.messageList.add(driverName+"(版本: "+sdkVersion+"):::"+"长按控件失败");
            throw e;
        }
   }
   public void driverClick(IOSDriver<IOSElement> driver,String locator,String driverName,String sdkVersion){
        String[] coordinate =locator.split(",");
        log.info("设备: "+driverName+" "+"坐标点击: "+coordinate[0]+","+coordinate[1]);
        int x=Integer.valueOf(coordinate[0]);
        int y=Integer.valueOf(coordinate[1]);
        try{
            TouchAction touchAction=new TouchAction(driver);
            touchAction.press(new PointOption().withCoordinates(x,y)).release().perform();
        }catch(Exception e){
            log.error("设备: "+driverName+" "+"点击坐标失败: [ "+coordinate[0]+","+coordinate[1]+" ]");
            TestListener.messageList.add(driverName+"(版本: "+sdkVersion+"):::"+"长按控件失败");
            throw e;
        }
   }

}
