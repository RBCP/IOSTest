package utils;

import org.testng.Assert;

public class Assertion {
    private static Log log=new Log(Assert.class);
    private static void AssertionPassLog(String driverName){
        log.info("设备: "+driverName+" "+"【 Assert验证Pass】");
    }
    private static void AssertionFailedLog(String driverName){
        log.error("设备: "+driverName+" "+"【 Assert验证:failed!】");

    }
    public static void verityText(String actualText,String expectedText,String driverName,String sdkVersion){
        try{
            Assert.assertEquals(actualText,actualText);
            AssertionPassLog(driverName);
        }catch(Exception | Error e){
            TestListener.messageList.add(driverName+"(安卓版本: "+sdkVersion+"):::"+"Assert验证失败:{实际值: "+actualText+","+"预期值: "+expectedText);
            AssertionFailedLog(driverName);

        }
    }
    public static void verityInt(int actualInt,int expectedInt,String driverName,String sdkVersion){
        try{
            Assert.assertEquals(actualInt,expectedInt);
            AssertionPassLog(driverName);
        }catch(Exception | Error e){
            TestListener.messageList.add(driverName+"(安卓版本: "+sdkVersion+"):::"+"Assert验证失败: {"+"实际值: "+actualInt+","+"预期值: "+expectedInt);
            throw e;
        }
    }
}
