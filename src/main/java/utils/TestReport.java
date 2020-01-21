package utils;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class TestReport implements IReporter {
    private static final String OUTPUT_FOLDER="test-output/";
    private static final String FILE_NAME="TestReport.html";
    private ExtentReports extent;


    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite>suites,String outputDIrectory){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String date=dateFormat.format(new Date());
        init(TestListener.ReportTile);
        for(ISuite suite:suites){
            Map<String, ISuiteResult> result=suite.getResults();
            for(ISuiteResult r:result.values()){
                ITestContext context=r.getTestContext();
                buildTestNodes(context.getFailedTests(),Status.FAIL);
                buildTestNodes(context.getPassedTests(),Status.PASS);
            }
        }
        for(String s : Reporter.getOutput()){
            extent.setTestRunnerOutput(s);
        }
        extent.flush();
    }
    public void init(String reportName){
        ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(OUTPUT_FOLDER+FILE_NAME);
        htmlReporter.config().setDocumentTitle("ComChat自动化测试报告");
        htmlReporter.config().setReportName(reportName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setEncoding("utf-8");
        extent=new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS",System.getProperty("os.name"));
        extent.setSystemInfo("User Name",System.getProperty("user.name"));
        extent.setSystemInfo("Java Version",System.getProperty("java.version"));
        extent.setSystemInfo("Appium Version","1.15.1");
        extent.setReportUsesManualConfiguration(true);
    }
    private void buildTestNodes(IResultMap tests, Status status){
        ExtentTest test=null;
        String DeviceName=null;
        if(tests.size()>0){
            int i=0;
            int j=0;
            for(ITestResult result : tests.getAllResults()){
                switch(result.getStatus()){
                    case 1:
                        DeviceName=TestListener.mobileSuccessMessageList.get(i);
                        String CaseName=result.getMethod().toString();
                        test=extent.createTest(DeviceName+"-"+CaseName);
                        String DeviceName2=DeviceName.split("\\(")[0];
                        String txtName1=DeviceName2+"_"+CaseName;
                        test.assignCategory(DeviceName);
                        test.log(status,"Test "+status.toString().toLowerCase()+"ed");
                    i++;
                    break;
                    case 2:
                        String[] testDevice=TestListener.messageList.get(j).split(":::");
                        String CaseName2=result.getMethod().toString();
                        DeviceName=testDevice[0].split("\\(")[0];
                        String txtName2=DeviceName+"_"+CaseName2;
                        test=extent.createTest(testDevice[0]+"-"+CaseName2);
                        test.assignCategory(testDevice[0]);
                        test.log(status,testDevice[1]);
                        test.log(status,testDevice[1]);
                        test.log(status,result.getThrowable());
                        j++;
                        break;
                }
               test.getModel().setStartTime(getTime(result.getStartMillis()));

            }
        }

    }
    private Date getTime(long mills){
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(mills);
        return calendar.getTime();
    }

}
