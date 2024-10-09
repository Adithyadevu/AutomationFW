package com.demoshop.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.utils.DataUtils;

public class E2ECheckoutTest extends BaseTest{
	
	@Test
	public void verifyNewUserRegistersAndCheckoutProduct() throws InterruptedException {
		
		
			    //Registering user
			    DataUtils.initUserData();
			    loginPage.navigateToRegisterationSection();
			    registerPage.setUserData(DataUtils.firstName, DataUtils.lastName, DataUtils.uniqueEmail, DataUtils.password);
			    String expectedEmail = loginPage.getLoggedEmail();
			    Assert.assertEquals(DataUtils.uniqueEmail, expectedEmail, "Registered email is differents");
			    
			    //Searching product
			    loginPage.searchProduct(prop.getProperty("productToSearch"));
			    
			    //view product
			    cartPage.viewLaptop();
			    
			    //assertion it's 14 inch Laptop
			    String actualProductName= cartPage. getProductTitle();
			    Assert.assertEquals(prop.getProperty("expectedProductName"), actualProductName, "Product does not match");
			    cartPage.addProductToCart();
			      
			     //assert that it is added to cart
			     String actualText = cartPage.getConfirmationMsg();   
			     Assert.assertEquals(prop.getProperty("expectedText"), actualText, "Product is not added to cart");
			    
			     //navigate to cart
			     cartPage.navigateToCart();
			        
			      //check the checkboxes
			      checkoutpage.clickCheckBox();
			      Assert.assertTrue(checkoutpage.isBox1Checked(), "The checkbox should be checked, but it's not.");
			      Assert.assertTrue(checkoutpage.isBox2Checked(), "The checkbox should be checked, but it's not.");
			        
			        //move to checkout
			      checkoutpage.clickCheckOutBtn();
			        
			        
			       //billing
			      checkoutpage.selectCountry();
			      Thread.sleep(3000);
			      
			      //shipping
			      
		
		
		
		
		
		    
	}
}
	

