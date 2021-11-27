package com.amazon.objectlibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.genericutility.WebDriverUtility;

public class Cart {

	public Cart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='a-truncate a-size-medium']")
	private WebElement cartProduct;
	
	@FindBy(id="a-autoid-0-announce")
	private WebElement dropdownbtn;
	
	@FindBy(id="quantity_10")
	private WebElement qty;
	
	@FindBy(name="quantityBox")
	private WebElement qnty;
	
	@FindBy(id="a-autoid-1-announce")
	private WebElement update;
    
	@FindBy(xpath="(//span[@id='sc-subtotal-amount-buybox'])[1]/..")
	private WebElement price;
	
	public WebElement getCartProduct() throws InterruptedException {
		 
		 return cartProduct;
	}
	
	public void clickDropdown()
	{
		dropdownbtn.click();
	}
	public void clickqty()
	{
		qty.click();
	}
	
	public void selectqty(String no)
	{
		qnty.sendKeys(no);
	}
	public void updateqty() throws InterruptedException
	{
		update.click();
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.waitAndClick(price);
	}
	public WebElement cartPrice()
	{	
	 return price;
	}
	
}
