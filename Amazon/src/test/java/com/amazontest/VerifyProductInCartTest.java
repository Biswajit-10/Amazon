package com.amazontest;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.amazon.genericutility.BaseAnnotationsClass;
import com.amazon.objectlibrary.Cart;
import com.amazon.objectlibrary.Home;
import com.amazon.objectlibrary.ProductDetails;
import com.amazon.objectlibrary.ProductList;

public class VerifyProductInCartTest extends BaseAnnotationsClass {

	
	@Test //(retryAnalyzer=com.amazon.genericutility.RetryAnalyzer.class)
	public void searchAndVerifyProduct() throws InterruptedException

	{
		Home hp=new Home(driver);
		hp.clickOnSearchTextBox("iphone 11"+Keys.ENTER);
		
		ProductList product=new ProductList(driver);
		product.getProduct();
		
		ProductDetails pd=new ProductDetails(driver);
		pd.clickOnAddToCart(driver,20);
		pd.closePopUp();
		pd.clickOnCart(driver, 20);
		
		Cart c=new Cart(driver);
		c.getCartProduct();
		String actProduct=c.getCartProduct().getText();
		if(actProduct.contains("iPhone 11"))
		{
			System.out.println("product is added to cart");
		}
		else
			System.out.println("product is not added to cart");
	}
}
