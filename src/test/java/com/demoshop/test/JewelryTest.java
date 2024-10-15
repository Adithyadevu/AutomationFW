package com.demoshop.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JewelryTest extends BaseTest{
	
	@Test
	public void verifyUserCanSelectjewelry() {
		loginPage.searchProduct(prop.getProperty("productToSearch"));//objectname.methodname
		jewelrypage.selectjewelrychain();//parent object call .method name
		
		jewelrypage.addLengthCm(prop.getProperty("len"));
		
		String actualProductName=jewelrypage. getproducttitle();
		Assert.assertEquals(prop.getProperty("expectedproductName"), actualProductName,"Product is not matching");
	    
		
	
		jewelrypage.addcartchain(); 
	    String actualmsg=jewelrypage.getmsgconfirmation();
	    Assert.assertEquals(prop.getProperty("expectedText"), actualmsg,"Not added to cart");
	   
		 }

}
