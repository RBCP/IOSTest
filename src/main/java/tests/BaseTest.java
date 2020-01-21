package tests;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseDriver;
import utils.Devices;
import utils.Log;

public class BaseTest extends BaseDriver {
    public Log log=new Log(this.getClass());
    public static IOSDriver<IOSElement> driver;
    public static String driverName=null;
    public static String sdkVersion=null;
    public String deviceId=null;
    @BeforeClass
    public void setup() throws Exception{
        driver=setUpApp();
        Devices devices=getDevice();
        driverName=devices.getDriverName();
        sdkVersion= devices.getSdkVersion();
        deviceId= devices.getDeviceId();
    }
    @AfterClass
    public void tearDown(){
        driver.closeApp();
        driver.quit();
    }
    public static IOSDriver<IOSElement> getDriver(){
        return driver;
    }
    public static String getDriverName(){
        return driverName;
    }
    public static String getSdkVersion(){
        return sdkVersion;
    }
}
