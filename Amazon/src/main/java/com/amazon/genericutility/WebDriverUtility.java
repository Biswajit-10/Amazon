package com.amazon.genericutility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void impliciteWait(WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public void waitForElementsTobeVisible(WebDriver driver, WebElement element, int waitTime)
	{
		WebDriverWait wait=new WebDriverWait(driver,waitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
				
	}
	
/**
* This method wait for the element to be clicked , its custom wait created to avoid elemenInterAceptable Exception
* @param element
* @throws throwable
* 
*/


	   public void waitAndClick(WebElement element) throws InterruptedException
	   {
		int count = 0;
	       while(count<20) {
			   try {
			element.click();
			       break;
			}catch(Throwable e){
				Thread.sleep(1000);
				   count++;
			   }
	       }

	   }

	
	  public void goToElement(WebDriver driver, WebElement target) {
		
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();
	}
	  
	    /** This method performs right click operation 
	    * @param driver
	    * @param element
	    */
	   public void rightClick(WebDriver driver,WebElement element)
	   {
		   Actions act = new Actions(driver);
		act.contextClick(element).perform();
	   }


	
	  public void switchToWindow(WebDriver driver, String titleContains)
	  {
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()) {
			
			String windowAddress=it.next();
			driver.switchTo().window(windowAddress);
			
			if(driver.getTitle().contains(titleContains))
			{
				break;
			}
		}
	  }

/**
* this methods enables user to handle dropdown using visible text
* @param element
* @param option
*/	
	 public void select(WebElement element, String option)
	 {
	        Select select=new Select(element);
	        select.selectByVisibleText(option);
	 }
	 public void select(WebElement element, int index)
	 {
	        Select select=new Select(element);
	        select.selectByIndex(index);
	 }
	 
	   /**
	    * Accept alert 
	    * @param driver
	    */

	   public void acceptAlert(WebDriver driver)
	   {
		driver.switchTo().alert().accept();
	   }

}
