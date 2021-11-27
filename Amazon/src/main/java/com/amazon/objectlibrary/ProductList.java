package com.amazon.objectlibrary;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductList {

	public ProductList(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Apple iPhone 13')]")
	  private List<WebElement> productList;
    
	@FindBy(xpath="//a[@class='a-link-normal a-text-normal']")
	  private WebElement product;
	
	public void getProductList() {
		
		for(WebElement sugg:productList)
		{
			String productLists=sugg.getText();
			System.out.println(productLists);
		}
	}
	public void getProduct()
	{
		product.click();
	}
}
