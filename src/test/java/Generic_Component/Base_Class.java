package Generic_Component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class {
	public Process process;	
	public AppiumDriver driver;
	
	public void Start_appiumserver() throws ExecuteException, IOException, InterruptedException
	{
		
		String Start_server="D:\\Appium\\node.exe D:\\Appium\\node_modules\\appium\\bin\\appium.js";
		Runtime runtime = Runtime.getRuntime();
		process=runtime.exec(Start_server);
		
		if(process!=null)
		{
			System.out.println("Appium started");
		}
		else
		{
			System.out.println("NOT started");
		}
		
		Thread.sleep(15000);
		
	}
	
	
	public void Stop_appiumserver() throws ExecuteException, IOException
	{
		
		if(process!=null)
		{
			process.destroy();
			System.out.println("Appium Stopped");
		}
		
	}
	
	public void InitApp() throws MalformedURLException
	{
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "GT-I9300I");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		capabilities.setCapability("appPackage", "com.bigbasket.mobileapp");
		capabilities.setCapability("appActivity", "com.bigbasket.mobileapp.activity.SplashActivity");
		
		 driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

}
	
	public void Explicit_wait(WebElement ele, long T1)
	{
		WebDriverWait wait= new WebDriverWait(driver, T1);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
}
