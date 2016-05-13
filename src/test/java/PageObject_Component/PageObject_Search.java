package PageObject_Component;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_Search {
	
	public AppiumDriver driver;
	
	@FindBy(id="com.bigbasket.mobileapp:id/action_search")
	public WebElement Search_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/searchView")
	public WebElement Search_txt;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement Invalid_msg;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductCount")
	public WebElement Valid_msg;
	
	
	public PageObject_Search(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void Click_btn()
	{
		Search_btn.click();
	}
	
	public void Enter_Search(String Value)
	{
		Search_txt.sendKeys(Value  +"\n");
	}
	
	public String getInvalid_msg()
	{
		return Invalid_msg.getText();
	}
	
	public String getValid_msg()
	{
		return Valid_msg.getText();
	}
	
	

}
