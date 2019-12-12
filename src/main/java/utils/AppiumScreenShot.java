package utils;

import com.google.common.io.Files;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;


public class AppiumScreenShot {
    private IOSDriver<IOSElement> driver;
    private String driverName;
    private String caseName;
    Log log=new Log(this.getClass());
    public AppiumScreenShot(IOSDriver<IOSElement> driver){
        this.driver=driver;
    }
    public void setScreenName(String driverName,String caseName){
        this.caseName=caseName;
        this.driverName=driverName;
    }
    public void takeScreenshot(String screenPath){
        IOSDriver<IOSElement> driver2=((IOSDriver<IOSElement>) driver);
        driver2.context("NATIVE_APP");
        try{
            File scrFile=((TakesScreenshot) driver2).getScreenshotAs(OutputType.FILE);
            Files.copy(scrFile,new File(screenPath));
            log.error("错误截图："+screenPath);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void takeScreenShot(){
        String screenName=this.driverName+"-"+this.caseName+".jpg";
        File dir=new File("test-output/snapshot");
        if(!dir.exists()){
            dir.mkdirs();
        }
        String Path="../test-output/snapshot/"+screenName;
        TestListener.screenMessageList.add(Path);
        String screenPath=dir.getAbsolutePath()+"/"+screenName;
        takeScreenshot(screenPath);

    }

}
