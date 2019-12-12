package pages;

import org.openqa.selenium.By;

public class loginPage extends BasePage{
    private By staffBy=By.xpath("//XCUIElementTypeApplication[@name=\\\"comChat\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField");
    private By passwordBy=By.xpath("//XCUIElementTypeApplication[@name=\"comChat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField");
    private By privacyBy=By.xpath("(//XCUIElementTypeButton[@name=\"not select icon\"])[2]");
    private By policyBy=By.xpath("(//XCUIElementTypeButton[@name=\"not select icon\"])[1]");
    private By loginBtnBy=By.id("登陆");

    public void InputStaffId(String staffId){
        driver.findElement(staffBy).sendKeys(staffId);
    }
    public  void InputPassword(String password){
        driver.findElement(passwordBy).sendKeys(password);
    }
    public void clickPrivacyBtn(){
        driver.findElement(privacyBy).click();
        driver.findElement(policyBy).click();
    }
    public void clickLoginBtn(){
        driver.findElement(loginBtnBy).click();
    }
}
