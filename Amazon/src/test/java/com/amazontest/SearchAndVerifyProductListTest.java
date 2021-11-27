package com.amazontest;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.amazon.genericutility.BaseAnnotationsClass;
import com.amazon.objectlibrary.Home;
import com.amazon.objectlibrary.ProductList;

public class SearchAndVerifyProductListTest extends BaseAnnotationsClass {
    
	@Test
	public void searchAndVerifyProduct()

	{
		Home hp=new Home(driver);
		hp.clickOnSearchTextBox("iphone 13"+Keys.ENTER);
		
		ProductList lists=new ProductList(driver);
		lists.getProductList();
		
	}
}
