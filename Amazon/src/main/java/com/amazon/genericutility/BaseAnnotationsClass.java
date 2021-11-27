package com.amazon.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * 
 * @author Raj
 *
 */
public class BaseAnnotationsClass {
	
	public FileUtiity fLib=new FileUtiity();
	public JavaUtility jLib=new JavaUtility();
	public ExcelFileUtility eLib=new ExcelFileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	
	public WebDriver driver=null;
	 
	@BeforeClass()
	public void configBC() throws IOException
	{
		System.out.println("====>Launch The Browser<====");
		
		String browser = fLib.getPropertyKeyValue("BROWSER");
		String url = fLib.getPropertyKeyValue("URL");
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(browser.equals("ie")) {
			driver=new InternetExplorerDriver();
		}
	
		driver.manage().window().maximize();
		wLib.impliciteWait(driver, 10);
		driver.get(url);
	}
	
	/*@AfterClass()
	public void configAC()
	{
		driver.quit();
		System.out.println("====>Close The Browser<====");
	}*/
}
