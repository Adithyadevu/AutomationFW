package com.demoshop.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.page.Objects.CheckOutPage;
import com.demoshop.utils.DataUtils;

public class E2ECheckoutTest extends BaseTest{
	
	@Test(groups="Smoke")
	public void verifyNewUserRegistersAndCheckoutProduct() {
		
		
			    //Registering user
			    DataUtils.initUserData();
			    loginPage.navigateToRegisterationSection();
			    registerPage.setUserData(DataUtils.firstName, DataUtils.lastName, DataUtils.uniqueEmail, DataUtils.password);
			    String expectedEmail = loginPage.getLoggedEmail();
			    Assert.assertEquals(DataUtils.uniqueEmail, expectedEmail, "Registered email is differents");
			    
			    //Searching product
			    loginPage.searchProduct(prop.getProperty("productToSearch"));
			    
			    //view product
			    cartpage.viewLaptop();
			    
			    //assertion it's 14 inch Laptop
			    String actualProductName= cartpage. getProductTitle();
			    Assert.assertEquals(prop.getProperty("expectedProductName"), actualProductName, "Product does not match");
			    cartpage.addProductToCart();
			      
			     //assert that it is added to cart
			     String actualText = cartpage.getConfirmationMsg();   
			     Assert.assertEquals(prop.getProperty("expectedText"), actualText, "Product is not added to cart");
			    
			     //navigate to cart
			     cartpage.navigateToCart();//cartpageheading
			     String  actualCartHeading = cartpage. tittleOfCart();
			     Assert.assertEquals(prop.getProperty("expectedCartHeading"), actualCartHeading, "Not navigated to cart");
			        
			      //check the checkboxes
			      checkoutpage.clickCheckBox();
			      Assert.assertTrue(checkoutpage.isBox1Checked(), "The checkbox should be checked, but it's not.");
			      Assert.assertTrue(checkoutpage.isBox2Checked(), "The checkbox should be checked, but it's not.");
			        
			        //move to checkout
			      checkoutpage.clickCheckOutBtn();
			      String actualHeadingCheckOut =checkoutpage.checkOutTitle();
				  Assert.assertEquals(prop.getProperty("expectedHeadingCheckOut"), actualHeadingCheckOut, "not navigated to checkout");
				        
			        
			    
		          //order confirm
				  checkoutpage.detailsConfirmationOfOrder();
				  String actualOrderPlaced= checkoutpage.orderPlacedMsg();
			      Assert.assertEquals(prop.getProperty("expectedOrderPlaced"), actualOrderPlaced, "Order not placed");
		
		
		    
	}
}
	

