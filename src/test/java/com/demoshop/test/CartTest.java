package com.demoshop.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
	
	@Test
	public void verifyUserisAbleToAddCart() {
		
      loginPage.searchProduct(prop.getProperty("productToSearch"));
      
      
     
      
        cartPage.viewLaptop();
        String actualProductName= cartPage. getProductTitle();
	    Assert.assertEquals(prop.getProperty("expectedProductName"), actualProductName, "Product does not match");
		
		
	    cartPage.addProductToCart();
		String actualText = cartPage.getConfirmationMsg();
        Assert.assertEquals(prop.getProperty("expectedText"), actualText, "Product is not added to cart");
			
	}
	
	
	
	


}
