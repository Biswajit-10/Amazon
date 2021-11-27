package com.amazon.objectlibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.genericutility.WebDriverUtility;

public class ProductDetails {

	public ProductDetails(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="submit.add-to-cart")
	  private WebElement product;
	
	@FindBy(id="attach-close_sideSheet-link")
	  private WebElement closePopUp;
	
	@FindBy(xpath="//a[@id='nav-cart']")
	  private WebElement cart;
	
	public void clickOnAddToCart(WebDriver driver, int waitTime)
	{
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.switchToWindow(driver, "Apple iPhone-11");
		WebDriverUtility wLibb=new WebDriverUtility();
		wLibb.waitForElementsTobeVisible(driver, product, waitTime);
		product.click();
	}
	public void closePopUp()
	{
		closePopUp.click();
	}
	public void clickOnCart(WebDriver driver,int waitTime ) throws InterruptedException
	{
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.waitAndClick(cart);
	}
}

