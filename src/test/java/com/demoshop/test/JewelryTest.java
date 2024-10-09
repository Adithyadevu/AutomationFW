package com.demoshop.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JewelryTest extends BaseTest{
	
	@Test
	public void verifyUserCanSelectjewelry() {
		loginPage.searchProduct(prop.getProperty("productToSearch"));//objectname.methodname
		jewelryPage.selectjewelrychain();//parent object call .method name
		
		jewelryPage.addLengthCm(prop.getProperty("len"));
		
		String actualProductName=jewelryPage. getproducttitle();
		Assert.assertEquals(prop.getProperty("expectedproductName"), actualProductName,"Product is not matching");
	    jewelryPage.addcartchain();
	    
	   String actualmsg=jewelryPage.getmsgconfirmation();
	   Assert.assertEquals(prop.getProperty("expectedText"), actualmsg,"Not added to cart");
		 }

}
