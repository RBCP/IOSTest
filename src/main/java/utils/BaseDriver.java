package utils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseDriver {
    public Log log=new Log(this.getClass());
    public IOSDriver<IOSElement> driver;
    final String URL_STRING="http://127.0.0.1:4723/wd/hub";

    public IOSDriver<IOSElement> setUpApp() throws IOException{
        String driverName=null;
        try{
            Devices devices=getDevice();
            driverName=devices.getDriverName();
            String nodeURL=devices.getNodeURL();
            String platformName=devices.getPlatformName();
            String deviceId=devices.getDeviceId();
            String deviceName=devices.getDeviceName();
            String sdkVersion=devices.getSdkVersion();
            String bundleId=devices.getBundleId();
            String bootstrapPort=devices.getBootstrapPort();
            log.info("设备："+driverName+" "+"开始执行测试");
            log.info("设备："+driverName+" "+"启动appium server");
            try{
                //AppiumServerUtils appiumServer =new AppiumServerUtils(nodeURL.split(":")[0],Integer.valueOf(nodeURL.split(":")[1]));
                // url=appiumServer.startServer();
                if(nodeURL.equals("")){
                    log.error("设备："+driverName+" "+"appium url没有配置");
                }else{
                    log.info("设备："+driverName+" "+"配置信息：Mobile Driver："+driverName);
                    log.info("设备："+driverName+" "+"Appium Server"+"http://"+nodeURL+"/wb/hub");
                    log.info("设备："+driverName+" "+"设备Id"+deviceId);
                    DesiredCapabilities capabilities=new DesiredCapabilities();
                    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,deviceId);
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,sdkVersion);
                    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
                    // capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"safari");
                    capabilities.setCapability("userNewWDA", false);
                    capabilities.setCapability("bundleId",bundleId);
                    capabilities.setCapability(MobileCapabilityType.UDID,"e15c7c76d3e80801a97660eb95a235b8c9f8e39c");
                    URL url=new URL(URL_STRING);
                    driver=new IOSDriver<IOSElement>(url,capabilities);
                    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                }

            }catch(Exception e){
                e.printStackTrace();;
                log.error("设备： "+driverName+" "+"appium环境配置失败");
            }

        }catch(Exception e){
            log.error("设备： "+driverName+" "+"读取appium配置文件失败");
            e.printStackTrace();
        }
        return driver;
    }
    public Devices getDevice(){
        Yaml yaml = new Yaml();
        Devices device=new Devices();
        try {
            InputStream in = BaseDriver.class.getResourceAsStream("/IOSDevice.yml");
            device = yaml.loadAs(in, Devices.class );

        } catch (Exception e){
            e.printStackTrace();
        }
        return device;
    }
}
