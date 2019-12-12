package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

public class BasePage {
    private static final int TIMEOUT=1;
    private static final int TIMEOUT_LONG=20;
    public IOSDriver<IOSElement> driver;
    public String driverName;
    public String sdkVersion;
    public WebDriverWait driverWait;
    public WebDriverWait driverLongWait;
    public BasePage(){
        this.driver= BaseTest.getDriver();
        this.driverName= BaseTest.getDriverName();
        this.driverName=BaseTest.getSdkVersion();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
    }
}
