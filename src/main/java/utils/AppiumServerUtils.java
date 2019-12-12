package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.IOSServerFlag;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class AppiumServerUtils {
    private String ipAddress;
    int port;
    String bp;
    AppiumDriverLocalService service;
    public AppiumServerUtils(){

    }
    public AppiumServerUtils(String ipAddress,int port){
        this.ipAddress=ipAddress;
        this.port=port;
    }

    /**
     * 默认方式启动Appium服务器
     * @return
     */
    public URL startAppiumServerByDefault(){
        AppiumDriverLocalService service=AppiumDriverLocalService.buildDefaultService();
        service.start();
        if(service==null || !service.isRunning()){
            throw new RuntimeException("An appium server node is not started！");
        }
        return service.getUrl();
    }

    /**
     * 构造一个AppiumServiceBuilder类来构建Appium服务，但不指定主机和端口号
     * @return
     */
    public URL startAppiumServiceNoRest(){
        AppiumServiceBuilder builder=new AppiumServiceBuilder();
        AppiumDriverLocalService service=AppiumDriverLocalService.buildService(builder);
        service.start();
        if(service==null || service.isRunning()){
            throw new RuntimeException("An appium node is not started");
        }
        return service.getUrl();
    }

    /**
     * 指定主机地址和端口号启动Appium服务器
     * @return
     */
    public URL startServer(){
        AppiumServiceBuilder builder=new AppiumServiceBuilder();
        builder.withIPAddress(ipAddress);
        builder.usingPort(port);
        service=AppiumDriverLocalService.buildService(builder);
        service.start();
        if(service==null || !service.isRunning()){
            throw new RuntimeException("An appium node is  not started!");
        }
        return service.getUrl();
    }
    public AppiumDriverLocalService stopSever(){
        if(service!=null){
            return service;
        }
        return null;
    }

    /**
     * 设定Appium相关配置的路径
     * @throws IOException
     */
    public static void setAppiumPath() throws IOException {
        String os=System.getProperty("os.name");
        if(os.contains("Mac")){
            Properties pp=new Properties();
            FileInputStream fis=new FileInputStream("config.properties");
            pp.load(fis);
            String appiumPath=pp.getProperty("APPIUM_JS_APTH");
            System.setProperty(AppiumServiceBuilder.APPIUM_PATH,appiumPath);
        }
    }
    public static void main(String[] args) throws Exception{
        AppiumServerUtils appiumServer= new AppiumServerUtils("127.0.0.1",4723);
        appiumServer.startServer();
    }

}
