package utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestListener extends TestListenerAdapter {
    Log log =new Log(this.getClass());
    public static List<String> messageList=new ArrayList<String>();
    public static List<String> screenMessageList=new ArrayList<String>();
    public static List<String> screenResourceList=new ArrayList<String>();
    public static List<String> ResourceList=new ArrayList<String>();
    public static List<String> mobileSuceessMessageList=new ArrayList<String>();
    public static List<String> deviceLists=new ArrayList<String>();

    public static String ProjectPath;
    public static String ReportTile;
    public static String AppName;
    public static String Devices;
    public static String DeviceType;
    static{
        Properties pp=new Properties();
        try{
            InputStreamReader reader=new InputStreamReader(new FileInputStream("/Users/liucuilv/IdeaProjects/IOSTest/config.properties"),"UTF-8");
            pp.load(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
       Devices=pp.getProperty("DEVICES");
        String[] devices=Devices.split(",");
        for(String device:devices){
            deviceLists.add(device);
        }
        ProjectPath=pp.getProperty("WORKSPACE_PATH");
        AppName=pp.getProperty("APP_NAME");
        ReportTile=pp.getProperty("REPORT_TITLE");
        DeviceType=pp.getProperty("DEVICE_TYPE");
        String logPath=ProjectPath+"/test-output/log/";
        File path=new File(logPath);
        IOMananger.deleteFile(path);
    }
    @Override
    public void onTestStart(ITestResult tr){
        log.info("【Start】测试用例:"+tr.getTestName());
    }
    @Override
    public void onTestFailure(ITestResult tr){
        log.error("【Failed】测试用例:"+tr.getTestName());
    }
    @Override
    public void onTestSkipped(ITestResult tr){
        log.warn("【Skipped】测试用例:"+tr.getTestName());
    }
    @Override
    public void onTestSuccess(ITestResult tr){
        log.info("【Passed】测试用例:"+tr.getTestName());
    }



}
