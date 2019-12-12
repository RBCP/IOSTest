package utils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}
