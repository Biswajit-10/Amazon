package com.amazontest;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.amazon.genericutility.BaseAnnotationsClass;
import com.amazon.objectlibrary.Cart;
import com.amazon.objectlibrary.Home;
import com.amazon.objectlibrary.ProductDetails;
import com.amazon.objectlibrary.ProductList;

public class VerifyPriceChangedTest extends BaseAnnotationsClass {

	@Test
	public void verifyCartPrice() throws InterruptedException
	{
		Home hp=new Home(driver);
		hp.clickOnSearchTextBox("horlicks"+Keys.ENTER);
		
		ProductList product=new ProductList(driver);
		product.getProduct();
		
		ProductDetails pd=new ProductDetails(driver);
		pd.clickOnAddToCart(driver,20);
		
		pd.clickOnCart(driver, 20);
		
		Cart c=new Cart(driver);
		String s1Price=c.cartPrice().getText();
		System.out.println(s1Price);
		c.clickDropdown();
		c.clickqty();
		c.selectqty("10");
		c.updateqty();
		String s2Price=c.cartPrice().getText();
		System.out.println(s2Price);
	}
}
