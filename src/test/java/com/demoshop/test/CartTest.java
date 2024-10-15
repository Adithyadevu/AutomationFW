package com.demoshop.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
	
	@Test
	public void verifyUserisAbleToAddCart() {
		
      loginPage.searchProduct(prop.getProperty("productToSearch"));
      
      
     
      
        cartpage.viewLaptop();
        String actualProductName= cartpage. getProductTitle();
	    Assert.assertEquals(prop.getProperty("expectedProductName"), actualProductName, "Product does not match");
		
		
	    cartpage.addProductToCart();
		String actualText = cartpage.getConfirmationMsg();
        Assert.assertEquals(prop.getProperty("expectedText"), actualText, "Product is not added to cart");
			
	}
	
	
	
	


}
